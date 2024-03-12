package com.example.welcomedog_admin.service.impl;

import com.example.welcomedog_admin.service.AdminService;
import com.example.welcomedog_core.dto.ItemDTO;
import com.example.welcomedog_core.dto.MemberDTO;
import com.example.welcomedog_core.dto.OrderDTO;
import com.example.welcomedog_core.entity.Item;
import com.example.welcomedog_core.entity.Member;
import com.example.welcomedog_core.entity.Order;
import com.example.welcomedog_core.repository.ItemRepository;
import com.example.welcomedog_core.repository.MemberRepository;
import com.example.welcomedog_core.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;

    // 상품 등록
    @Override
    @Transactional
    public void reg(ItemDTO.Request request) {
        itemRepository.save(request.toEntity(request));
    }

    // 모든 회원 조회
    @Override
    public List<Member> selectAllMember() {
        ArrayList<Member> allMember = memberRepository.findAll();
        return allMember;
    }

    // 모든 상품 조회
    @Override
    public List<Item> selectAllItem() {
        ArrayList<Item> allItem = itemRepository.findAll();
        return allItem;
    }

    // 모든 주문 조회
    @Override
    public List<Order> selectAllOrder() {
        ArrayList<Order> allOrder = orderRepository.findAll();
        return allOrder;
    }

    // 배송상태 변경
    @Override
    @Transactional
    public boolean updateOrderStatus(OrderDTO.Request request) {
        Optional<Order> byOrder = orderRepository.findOrderByOrderSeq(request.getOrderSeq());
        if (byOrder.isPresent()) {
            Order order = byOrder.get();
            if (order.getStatus().equals(request.getStatus())) {
                return false;
            } else {
                request.setName(order.getName());
                request.setAddr(order.getAddr());
                request.setDetailAddr(order.getDetailAddr());
                request.setZipcode(order.getZipcode());
                request.setItemCNT(order.getItemCNT());
                request.setMemberSeq(order.getMemberSeq());
                request.setDate(order.getDate());
                request.setRecipient_tel(order.getRecipient_tel());
                request.setTotalPrice(order.getTotalPrice());

                orderRepository.save(request.toEntity(request));
                return true;
            }
        } else {
            throw new NullPointerException("Not Found");
        }
    }
}
