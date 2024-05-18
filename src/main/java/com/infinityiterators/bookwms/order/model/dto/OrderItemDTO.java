package com.infinityiterators.bookwms.order.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderItemDTO {
    private int orderItemId;
    private int orderId;
    private int bookId;
    private int quantity;
}