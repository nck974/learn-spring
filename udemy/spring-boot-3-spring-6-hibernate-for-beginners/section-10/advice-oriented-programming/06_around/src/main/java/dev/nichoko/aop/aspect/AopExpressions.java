package dev.nichoko.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AopExpressions {

    // Pointcut declarations
    @Pointcut("execution(public * dev.nichoko.aop.entity.*.*(..))")
    private void forEntityPackage() {
    }

    @Pointcut("execution(public * dev.nichoko.aop.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("execution(public * set*(..))")
    private void forSetter() {
    }

    @Pointcut("execution(public * get*(..))")
    private void forGetter() {
    }

    @Pointcut("(forDaoPackage() || forEntityPackage()) && !forGetter() && !forSetter()")
    public void anyPackageMethodNoGetterNoSetter() {
    }

}
