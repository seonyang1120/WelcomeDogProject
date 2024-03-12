package com.example.welcomedog_web.service.impl;

import com.example.welcomedog_core.dto.OrderDTO;
import com.example.welcomedog_core.entity.Member;
import com.example.welcomedog_core.repository.MemberRepository;
import com.example.welcomedog_core.repository.OrderRepository;
import com.example.welcomedog_web.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;

    // 주문 생성
    @Override
    @Transactional
    public boolean createOrder(OrderDTO.Request request) {
        Optional<Member> byMemberId = memberRepository.findByMemberId(request.getMemberId());
        if (byMemberId.isPresent()) {
            Member member = byMemberId.get();
            request.setMemberSeq(member);
            orderRepository.save(request.toEntity(request));
            return true;
        } else {
            throw new NullPointerException("Member Not Found");
        }
    }

    // 주문내역 확인
    @Override
    public boolean findOrder(Long orderSeq) {
        return orderRepository.existsByOrderSeq(orderSeq);
    }
}