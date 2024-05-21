package com.infinityiterators.bookwms.shipment.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StockOutDTO {

    private String bookID;

    private int bookAmount;
}
