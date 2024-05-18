package com.infinityiterators.bookwms.order.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor   // 기본생성자
@AllArgsConstructor  // 모든필드초기화하는 매개변수있는생성자
@Getter              // getter메소드
@Setter              // setter메소드
@ToString            // toString
public class OrderDTO {
    private int orderId;
    private int user_code;
    private Date orderDate;
    private String status;
}
