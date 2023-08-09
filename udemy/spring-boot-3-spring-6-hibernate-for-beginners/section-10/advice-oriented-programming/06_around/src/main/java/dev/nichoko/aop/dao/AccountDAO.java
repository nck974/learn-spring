package dev.nichoko.aop.dao;

import java.util.List;

import dev.nichoko.aop.entity.Account;

public interface AccountDAO {
    void addAccount(Account account);

    boolean addOrder();

    List<Account> findAccounts();

}
