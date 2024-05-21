package com.infinityiterators.bookwms.receipt.model.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookDTO {

    private String bookID;
    private String title;
    private String author;
    private String publisher;
//    private String ISBN;
    private String nationCode;
    private String genreCode;
}
