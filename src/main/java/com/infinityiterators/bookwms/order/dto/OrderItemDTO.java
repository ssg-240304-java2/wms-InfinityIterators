package com.infinityiterators.bookwms.order.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderItemDTO {
    private int orderItemId;
    private int orderId;
    private int BookID; // BookID -> bookId
    private int quantity;
}