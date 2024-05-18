package com.infinityiterators.receipt.model.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReceiptDTO {

    private String receiptID;
    private int inAmount;
    private Date receiptDate;
    private String bookID;
}
