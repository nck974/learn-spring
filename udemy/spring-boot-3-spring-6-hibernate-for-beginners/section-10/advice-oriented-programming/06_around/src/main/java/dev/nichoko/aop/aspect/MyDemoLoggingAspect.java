package dev.nichoko.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import dev.nichoko.aop.entity.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    @Before("dev.nichoko.aop.aspect.AopExpressions.anyPackageMethodNoGetterNoSetter()")
    public void addLoggingAllMethodsInCombinedPackages(JoinPoint joinPoint) {
        System.out.println(getClass() + ": Logging before execution of any method in package");
        System.out.println(getClass() + " : Executed AOP before of: " + joinPoint.getSignature());

        if (joinPoint.getArgs().length > 0) {
            System.out.println(getClass() + " : Arguments are:");
            for (Object argument : joinPoint.getArgs()) {
                System.out.println(getClass() + " : " + argument);
            }
        }
    }

    @AfterReturning(pointcut = "execution(* findAccounts(..))", returning = "accounts")
    public void addLoggingOnFindAccounts(JoinPoint joinPoint, List<Account> accounts) {
        System.out.println(getClass() + ": Logging after execution of any method in package");

        if (accounts != null) {
            System.out.println(getClass() + " : " + "Accounts intercepted: " + accounts);

            // Modify values:
            for (Account account : accounts) {
                if (account.getName() == "name") {
                    account.setName("name1");
                }
            }
        }
    }

    @AfterThrowing(pointcut = "execution(* findAccounts(..))", throwing = "exception")
    public void addLoggingOnFindAccountsException(JoinPoint joinPoint, Throwable exception) {
        System.out.println(getClass() + ": Logging after exception found " + exception.toString());

    }

    @After("execution(* findAccounts(..))")
    public void addLoggingOnFindAccountsFinally(JoinPoint joinPoint) {
        System.out.println(getClass() + ": Logging after method finishes");

    }

    @Around("execution(* getFortune(..))")
    public Object addLoggingAroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long begin = System.currentTimeMillis();

        System.out.println(getClass() + ": Logging before around");
        Object result = proceedingJoinPoint.proceed();
        System.out.println(getClass() + ": Logging after around");

        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println("Execution took " + duration + "ms");

        return result;
    }

}
