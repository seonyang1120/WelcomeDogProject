package com.example.welcomedog_web.service;

import com.example.welcomedog_core.dto.OrderDTO;

public interface OrderService {
    // 주문 생성
    boolean createOrder(OrderDTO.Request request);

    // Seq로 상품 조회
    boolean findOrder(Long orderSeq);
}
