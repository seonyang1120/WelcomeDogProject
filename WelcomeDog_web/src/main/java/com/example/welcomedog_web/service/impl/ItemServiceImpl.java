package com.example.welcomedog_web.service.impl;

import com.example.welcomedog_core.dto.ItemDTO;
import com.example.welcomedog_core.entity.Item;
import com.example.welcomedog_core.repository.ItemRepository;
import com.example.welcomedog_web.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    // 상품번호로 조회
    @Override
    public boolean findItem(Long itemSeq) {
        return itemRepository.existsByItemSeq(itemSeq);
    }

    // 모든 상품 조회
    @Override
    public List<Item> selectAllItem() {
        ArrayList<Item> allItem = itemRepository.findAll();
        return allItem;
    }
}
