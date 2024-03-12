package com.example.welcomedog_core.dto;

import com.example.welcomedog_core.entity.Cart;
import com.example.welcomedog_core.entity.Item;
import com.example.welcomedog_core.entity.Member;
import lombok.Getter;
import lombok.Setter;

public class CartDTO {

    @Getter
    @Setter
    public static class Request {
            private Long cartSeq;
            private Member memberSeq;
            private Item itemSeq;
            private String memberId;
            private String itemName;
            private int cartItemCNT;

            public Cart toEntity(Request request) {
                return Cart.builder()
                        .cartSeq(request.cartSeq)
                        .memberSeq(request.memberSeq)
                        .itemSeq(request.itemSeq)
                        .cartItemCNT(request.cartItemCNT)
                .build();
            }
    }
}
