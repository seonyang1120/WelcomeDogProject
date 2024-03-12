package com.example.welcomedog_core.entity;

import com.example.welcomedog_core.entity.role.MemberRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberSeq;

    @Column(unique = true, length = 10)
    private String memberId;

    @Column(nullable = false, length = 20)
    private String password;

    private String memberName;
    private String tel;
    private String email;

    @Enumerated(value = EnumType.STRING)
    private MemberRole memberRole;

    @OneToMany(mappedBy = "memberSeq")
    @Builder.Default
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "memberSeq")
    @Builder.Default
    private List<Cart> cart = new ArrayList<>();
}
