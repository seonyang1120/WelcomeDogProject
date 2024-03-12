package com.example.welcomedog_web.controller;

import com.example.welcomedog_core.entity.Item;
import com.example.welcomedog_web.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    @GetMapping("/selectItemList")
    public String selectAllItem(Model model) {
        List<Item> items = itemService.selectAllItem();
        model.addAttribute("allItem", items);
        return "page/item";
    }
}
