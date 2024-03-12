package com.example.welcomedog_core.entity;

import com.example.welcomedog_core.entity.role.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicInsert
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderSeq;

    private LocalDate date;
    private int totalPrice;

    @Enumerated(value = EnumType.STRING)
    @ColumnDefault("'PREPARING'")
    private OrderStatus status;

    @Column(length = 6)
    private String zipcode;

    private String recipient_tel;
    private String name;
    private String addr;
    private String detailAddr;
    private int itemCNT;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "memberSeq")
    private Member memberSeq;
}
