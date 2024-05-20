package com.infinityiterators.bookwms.order.model.dto;

import java.util.List;

import com.infinityiterators.bookwms.order.model.CartItem;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CartDTO {
    private int cartId;
    private int userCode;
    private List<CartItem> items; // 장바구니 항목 리스트
}

