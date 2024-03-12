package com.example.welcomedog_core.dto;

import com.example.welcomedog_core.entity.Item;
import lombok.Getter;
import lombok.Setter;

public class ItemDTO {

    @Getter
    @Setter
    public static class Request {
        private Long itemSeq;
        private String itemName;
        private String itemImg;
        private int price;
        private String itemInfo;

        public Item toEntity(Request request) {
            return Item.builder()
                    .itemSeq(request.itemSeq)
                    .itemName(request.itemName)
                    .itemImg(request.itemImg)
                    .price(request.price)
                    .itemInfo(request.itemInfo)
                    .build();
        }
    }

    @Getter
    public static class Response {
        private Long itemSeq;
        private String itemName;
        private String itemImg;
        private int price;
        private String itemInfo;

        public Response(Item item) {
            this.itemSeq = item.getItemSeq();
            this.itemName = item.getItemName();
            this.itemImg = item.getItemImg();
            this.price = item.getPrice();
            this.itemInfo = item.getItemInfo();
        }
    }
}
