package com.example.welcomedog_core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "cart")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartSeq;

    @JoinColumn(name = "itemSeq") @ManyToOne(fetch = FetchType.EAGER)
    private Item itemSeq;

    @JoinColumn(name = "memberSeq") @ManyToOne(fetch = FetchType.EAGER)
    private Member memberSeq;

    private int cartItemCNT;
}
