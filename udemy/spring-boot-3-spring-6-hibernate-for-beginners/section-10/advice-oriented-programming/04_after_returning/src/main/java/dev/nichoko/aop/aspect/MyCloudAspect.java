package dev.nichoko.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyCloudAspect {

    @Before("dev.nichoko.aop.aspect.AopExpressions.anyPackageMethodNoGetterNoSetter()")
    public void logToCloud() {
        System.out.println(getClass() + ": Logging to cloud");
    }
}
