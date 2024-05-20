package com.infinityiterators.bookwms.receipt.model.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InRecordDTO {

    private String InRecordID;
    private int InAmount;
    private Date ReceiptDate;
    private String BookID;
}
