package dev.nichoko.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOimpl implements MembershipDAO {

    @Override
    public void addAccount() {
        System.out.println(getClass() +  ": executing addAccount...");
    }

    @Override
    public void addOrder() {
        System.out.println(getClass() +  ": executing addOrder...");
    }

}
