package com.example.welcomedog_core.dto;

import com.example.welcomedog_core.entity.Member;
import com.example.welcomedog_core.entity.Order;
import com.example.welcomedog_core.entity.role.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class OrderDTO {

    @Getter
    @Setter
    public static class Request {
        private Long orderSeq;
        private Member memberSeq;
        private String memberId;
        private String zipcode;
        private String recipient_tel;
        private String name;
        private OrderStatus status;
        private String addr;
        private String detailAddr;
        private int itemCNT;
        private LocalDate date;
        private int totalPrice;

        public Order toEntity(Request request) {
            return Order.builder()
                    .orderSeq(request.orderSeq)
                    .memberSeq(request.memberSeq)
                    .zipcode(request.zipcode)
                    .recipient_tel(request.recipient_tel)
                    .name(request.name)
                    .status(request.status)
                    .addr(request.addr)
                    .detailAddr(request.detailAddr)
                    .itemCNT(request.itemCNT)
                    .date(LocalDate.now())
                    .totalPrice(request.totalPrice)
                    .build();
        }
    }
}
