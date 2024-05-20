package com.infinityiterators.bookwms.receipt.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StockDTO {

    private String BookID;
    private int Amount;
}
