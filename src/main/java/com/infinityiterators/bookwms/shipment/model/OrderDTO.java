package com.infinityiterators.bookwms.shipment.model;

import lombok.*;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class OrderDTO {

    private int order_id;
    private int user_code;
    private Date order_date;
    private char status;

}
