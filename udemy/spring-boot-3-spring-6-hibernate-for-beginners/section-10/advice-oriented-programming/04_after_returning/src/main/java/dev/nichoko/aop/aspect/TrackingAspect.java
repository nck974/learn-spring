package dev.nichoko.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class TrackingAspect {

    @Before("dev.nichoko.aop.aspect.AopExpressions.anyPackageMethodNoGetterNoSetter()")
    public void trackAnalytics() {
        System.out.println(getClass() + ": Tracking analytics");
    }

}
