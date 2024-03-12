package com.example.welcomedog_web.member;

import com.example.welcomedog_core.dto.MemberDTO;
import com.example.welcomedog_core.entity.Member;
import com.example.welcomedog_web.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("Join Success")
    void join() {
        // given
        MemberDTO.Request request = new MemberDTO.Request();
        request.setMemberId("rjy1209");
        request.setPassword("1234");
        request.setMemberName("JY");
        request.setTel("010-1111-1111");
        request.setEmail("rjy1209@naver.com");

        // when
        memberService.join(request);
        boolean result = memberService.findMember("rjy1209");

        // then
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("Login Success")
    void login() {
        // given
        MemberDTO.Request request = new MemberDTO.Request();
        request.setMemberId("rjy1209");
        request.setPassword("1234");

        // when
        Member login = memberService.login(request);

        // then
        Assertions.assertThat(login.getMemberId()).isEqualTo("rjy1209");
    }

    @Test
    @DisplayName("Delete Complete")
    void delete() {
        // given
        MemberDTO.Request request = new MemberDTO.Request();
        request.setMemberSeq(2L);

        // when
        memberService.delete(request.getMemberId());
        boolean result = memberService.findMember("rjy1209");

        //then
        Assertions.assertThat(result).isEqualTo(false);
    }
}
