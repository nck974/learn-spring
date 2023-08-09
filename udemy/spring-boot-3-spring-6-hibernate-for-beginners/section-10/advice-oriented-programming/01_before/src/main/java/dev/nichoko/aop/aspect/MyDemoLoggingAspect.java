package dev.nichoko.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Before("execution(public void addAccount(..))")
    public void addLoggingAllAddAccount() {
        System.out.println(getClass() + ": Logging before execution of addAccount");
    }

    @Before("execution(public void dev.nichoko.aop.dao.AccountDAO.addAccount(..))")
    public void addLoggingSinglePackageFunction() {
        System.out.println(getClass() + ": Logging before execution targeted");
    }

    @Before("execution(public void add*(..))")
    public void addLoggingAnyFunctionStartingWithAdd() {
        System.out.println(getClass() + ": Logging before execution of add method");
    }

    @Before("execution(public void addOrder(..))")
    public void addLoggingToMatchOnlyType() {
        System.out.println(getClass() + ": Logging before execution of void addOrder");
    }

    @Before("execution(public * addOrder(..))")
    public void addLoggingToMatchAllTypes() {
        System.out.println(getClass() + ": Logging before execution of any type addOrder");
    }

    @Before("execution(public void addAccount(dev.nichoko.aop.entity.Account))")
    public void addLoggingAllAddAccountWithInputAccount() {
        System.out.println(getClass() + ": Logging before execution of addAccount with parameter Account");
    }
    
    @Before("execution(public * dev.nichoko.aop.dao.*.*(..))")
    public void addLoggingAllMethodsInPackage() {
        System.out.println(getClass() + ": Logging before execution of any method in package dao");
    }
}
