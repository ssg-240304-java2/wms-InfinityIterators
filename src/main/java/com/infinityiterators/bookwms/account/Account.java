package com.infinityiterators.bookwms.account;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String id;
    private String pwHash;
    private String pwSalt;
    private Timestamp lastPwChangedOn;
}
