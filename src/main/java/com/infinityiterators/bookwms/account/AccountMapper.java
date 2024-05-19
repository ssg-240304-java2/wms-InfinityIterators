package com.infinityiterators.bookwms.account;

public interface AccountMapper {
    User selectUserById(String id);

    int insertAccount(Account account);

    int insertUser(User user);
}
