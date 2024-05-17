package com.infinityiterators.receipt.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StockDTO {

    private String bookID;
    private int amount;
}
