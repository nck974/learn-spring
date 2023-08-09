package dev.nichoko.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import dev.nichoko.aop.entity.Account;

@Repository
public class AccountDAOimpl implements AccountDAO {

    private String name;
    private String serviceCode;

    public String getName() {
        System.out.println(getClass() + ": executing getName...");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": executing setName...");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": executing getServiceCode...");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": executing setServiceCode...");
        this.serviceCode = serviceCode;
    }

    @Override
    public void addAccount(Account account) {
        System.out.println(getClass() + ": executing addAccount...");
    }

    @Override
    public boolean addOrder() {
        System.out.println(getClass() + ": executing addOrder...");
        return false;
    }

    @Override
    public String toString() {
        return "AccountDAOimpl [name=" + name + ", serviceCode=" + serviceCode + "]";
    }

    @Override
    public List<Account> findAccounts() {
        System.out.println(getClass() + ": executing findAccounts...");
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("name", "level"));
        accounts.add(new Account("name2", "level2"));
        if (accounts.get(0).getName().equals("name")) {
            throw new RuntimeException();
        }
        return accounts;
    }

}
