package com.example.welcomedog_core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "items")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemSeq;

    private String itemName;
    private int price;
    private String itemImg;
    private String itemInfo;

    @OneToMany(mappedBy = "itemSeq")
    @Builder.Default
    private List<Cart> item = new ArrayList<>();
}
