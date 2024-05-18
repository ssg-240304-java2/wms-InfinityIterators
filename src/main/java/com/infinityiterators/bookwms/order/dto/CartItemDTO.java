package com.infinityiterators.bookwms.order.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CartItemDTO {
    private int cartItemId;
    private int cartId;
    private int bookId;
    private int quantity;

}
