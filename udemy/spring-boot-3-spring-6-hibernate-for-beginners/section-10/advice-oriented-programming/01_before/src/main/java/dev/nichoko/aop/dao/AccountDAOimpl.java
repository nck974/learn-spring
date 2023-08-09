package dev.nichoko.aop.dao;

import org.springframework.stereotype.Repository;

import dev.nichoko.aop.entity.Account;

@Repository
public class AccountDAOimpl implements AccountDAO {

    @Override
    public void addAccount(Account account) {
        System.out.println(getClass() +  ": executing addAccount...");
    }
    
    @Override
    public boolean addOrder() {
        System.out.println(getClass() +  ": executing addOrder...");
        return false;
    }

}
