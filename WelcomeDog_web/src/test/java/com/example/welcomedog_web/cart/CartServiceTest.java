package com.example.welcomedog_web.cart;

import com.example.welcomedog_core.dto.CartDTO;
import com.example.welcomedog_core.dto.MemberDTO;
import com.example.welcomedog_core.entity.Cart;
import com.example.welcomedog_web.service.CartService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CartServiceTest {

    @Autowired
    CartService cartService;

    @Test
    @DisplayName("Add Item to Cart")
    void add() {
        // given
        CartDTO.Request request = new CartDTO.Request();
        request.setCartItemCNT(3);
        request.setMemberId("rjy1209");
        request.setItemName("itemA");

        // when
        cartService.add(request);
        boolean result = cartService.findCart(1L);

        // then
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("My Cart List")
    void myCart() {
        // given
        MemberDTO.Request request = new MemberDTO.Request();
        request.setMemberId("rjy1209");

        // when
        List<Cart> myCart = cartService.findMyCart(request);

        // then
        for (int i=0; i< myCart.size(); i++) {
            System.out.println(myCart.get(i));
        }
    }
}
