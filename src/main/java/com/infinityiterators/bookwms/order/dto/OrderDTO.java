package com.infinityiterators.bookwms.order.model.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor    // 기본생성자
@AllArgsConstructor   // 모든필드 초기화하는 매개변수 있는 생성자
@Getter
@Setter
@ToString
public class OrderDTO {
    private int orderId;
    private int user_code;
    private Date orderDate;
    private String status;
}
