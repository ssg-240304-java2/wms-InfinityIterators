package com.infinityiterators.bookwms.account;

public interface AccountLogMapper {
    int insertCreateAccountTaskLog(User user);

    void insertLoginTaskLog(User user);

    void insertChangePasswordTaskLog(User usr);
}
