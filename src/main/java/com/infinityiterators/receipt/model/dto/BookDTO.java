package com.infinityiterators.receipt.model.dto;

import lombok.*;

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

    private int Amount;
}
