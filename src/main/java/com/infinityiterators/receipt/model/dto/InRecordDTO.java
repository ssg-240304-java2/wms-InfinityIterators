package com.infinityiterators.receipt.model.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InRecordDTO {

    private String inRecordID;
    private int inAmount;
    private Date receiptDate;
    private String bookID;
}
