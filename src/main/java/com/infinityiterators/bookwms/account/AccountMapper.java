package com.infinityiterators.bookwms.account;

import java.util.List;

public interface AccountMapper {
    User selectUserById(String id);

    int insertAccount(Account account);

    int insertUser(User user);

    int updatePassword(User usr);

    List<User> selectAllUsers();

}
