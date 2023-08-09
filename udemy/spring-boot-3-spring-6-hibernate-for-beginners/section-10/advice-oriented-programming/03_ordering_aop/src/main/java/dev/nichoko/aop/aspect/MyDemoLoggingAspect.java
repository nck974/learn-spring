package dev.nichoko.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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

}
