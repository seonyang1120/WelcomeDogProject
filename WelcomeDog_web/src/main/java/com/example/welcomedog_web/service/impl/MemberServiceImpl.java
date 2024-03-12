package com.example.welcomedog_web.service.impl;

import com.example.welcomedog_core.dto.MemberDTO;
import com.example.welcomedog_core.entity.Member;
import com.example.welcomedog_core.repository.MemberRepository;
import com.example.welcomedog_web.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    // 회원가입 기능
    @Override
    @Transactional
    public void join(MemberDTO.Request request) {
        memberRepository.save(request.toEntity());
    }

    // 로그인 기능
    @Override
    public Member login(MemberDTO.Request request) {
        try {
            Optional<Member> byId = memberRepository.findByMemberId(request.getMemberId());

            if (byId.isPresent()){
                Member member = byId.get();
                if(member.getPassword().equals(request.getPassword())){
                    return member;
                } else {
                    throw new IllegalArgumentException("Access Fail\n No Matching Password!");
                }
            } else {
                throw new IllegalArgumentException("Access Fail\n No Matching Id!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 아이디를 조회하여 유저 존재 여부 확인
    @Override
    public boolean findMember(String memberId) {
        return memberRepository.existsByMemberId(memberId);
    }

    // 아이디로 회원 삭제
    @Override
    @Transactional
    public void delete(String memberId) {
        Optional<Member> memberDetail = memberRepository.findByMemberId(memberId);
        Member member = memberDetail.get();

        memberRepository.deleteById(member.getMemberSeq());
    }

    // 아이디로 회원 상세조회
    @Override
    public MemberDTO.Response memberDetail(String memberSeq) {
        Optional<Member> byMemberId = memberRepository.findByMemberId(memberSeq);

        if (byMemberId.isPresent()) {
            return new MemberDTO.Response(byMemberId.get());
        } else {
            throw new NullPointerException("Member Not found");
        }
    }
}
