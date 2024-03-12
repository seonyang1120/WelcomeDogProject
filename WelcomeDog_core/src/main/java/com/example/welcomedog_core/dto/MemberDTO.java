package com.example.welcomedog_core.dto;

import com.example.welcomedog_core.entity.Member;
import com.example.welcomedog_core.entity.role.MemberRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

public class MemberDTO {

    @Getter
    @Setter
    public static class Request {
        private Long memberSeq;
        private String memberId;
        private String password;
        private String memberName;
        private String tel;
        private String email;

        public Member toEntity() {
            return Member.builder()
                    .memberSeq(this.memberSeq)
                    .memberId(this.memberId)
                    .password(this.password)
                    .memberName(this.memberName)
                    .email(this.email)
                    .tel(this.tel)
                    .memberRole(MemberRole.USER)
                    .build();
        }

        public Member toAdminEntity() {
            return Member.builder()
                    .memberId("admin")
                    .password("1234")
                    .memberName("admin")
                    .memberRole(MemberRole.ADMIN)
                    .build();
        }
    }

    @Getter
    public static class Response {
        private Long memberSeq;
        private String memberId;
        private String memberName;
        private String tel;
        private String email;
        private MemberRole memberRole;

        public Response(Member member) {
            this.memberSeq = member.getMemberSeq();
            this.memberId = member.getMemberName();
            this.memberName = member.getMemberName();
            this.tel = member.getTel();
            this.email = member.getEmail();
            this.memberRole = member.getMemberRole();
        }
    }
}
