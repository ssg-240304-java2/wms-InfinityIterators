package com.infinityiterators.bookwms.order.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDTO {
    private int orderId;
    private int user_code;
    private Date orderDate;
    private String status;
}
