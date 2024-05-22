package com.infinityiterators.bookwms.cancelOrder.model.dto;

import lombok.*;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class OrderDTO {
    private int orderId; // 필드 이름을 변경
    private int userCode; // 필드 이름을 변경
    private Date orderDate;
    private String status;
}
