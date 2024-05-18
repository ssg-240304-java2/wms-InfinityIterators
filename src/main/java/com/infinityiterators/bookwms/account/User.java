package com.infinityiterators.bookwms.account;

import lombok.*;

import java.time.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int code;
    private String name;
    private LocalDate dateOfBirth;
    private String email;
    private String phone;
    private String address;
    private String accountId;
    private Account account;    // Association
}
