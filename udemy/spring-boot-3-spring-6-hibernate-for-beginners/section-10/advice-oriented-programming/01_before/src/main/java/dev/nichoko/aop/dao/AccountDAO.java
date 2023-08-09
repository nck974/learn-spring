package dev.nichoko.aop.dao;

import dev.nichoko.aop.entity.Account;

public interface AccountDAO {
    void addAccount(Account account);
    boolean addOrder();

}
