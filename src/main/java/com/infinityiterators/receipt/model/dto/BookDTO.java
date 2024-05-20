package com.infinityiterators.receipt.model.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookDTO {

    private String BookID;
    private String Title;
    private String Author;
    private String Publisher;
    private String ISBN;
    private String NationCode;
    private String GenreCode;

    private int inAmount;       // 입고량
    private Date receiptDate;       // 입고일
}
