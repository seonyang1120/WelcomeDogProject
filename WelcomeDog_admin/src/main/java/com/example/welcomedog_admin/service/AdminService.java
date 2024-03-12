package com.example.welcomedog_admin.service;

import com.example.welcomedog_core.dto.ItemDTO;
import com.example.welcomedog_core.dto.OrderDTO;
import com.example.welcomedog_core.entity.Item;
import com.example.welcomedog_core.entity.Member;
import com.example.welcomedog_core.entity.Order;

import java.util.List;

public interface AdminService {

    // 상품 등록
    void reg(ItemDTO.Request request);
    // 모든 회원 조회
    List<Member> selectAllMember();

    // 모든 상품 조회
    List<Item> selectAllItem();

    // 모든 주문 조회
    List<Order> selectAllOrder();

    // 배송상태 변경
    boolean updateOrderStatus(OrderDTO.Request request);
}
