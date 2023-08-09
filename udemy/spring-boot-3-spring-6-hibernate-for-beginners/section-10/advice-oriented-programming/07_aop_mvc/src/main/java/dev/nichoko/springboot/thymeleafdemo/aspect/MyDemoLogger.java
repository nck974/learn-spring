package dev.nichoko.springboot.thymeleafdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogger {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* dev.nichoko.springboot.thymeleafdemo.controller.*.*(..))")
    void forAllControllers() {
    }

    @Pointcut("execution(* dev.nichoko.springboot.thymeleafdemo.service.*.*(..))")
    void forAllServices() {
    }

    @Pointcut("execution(* dev.nichoko.springboot.thymeleafdemo.entity.*.*(..))")
    void forAllEntities() {
    }
    @Pointcut("execution(* dev.nichoko.springboot.thymeleafdemo.dao.*.*(..))")
    void forAllDaos() {
    }

    @Before("forAllControllers()")
    public void logEverythingInController(JoinPoint joinPoint) {
        logger.info("Executing controller " + joinPoint.getSignature().getName());
    }

    @Before("forAllServices()")
    public void logEverythingInService(JoinPoint joinPoint) {
        logger.info("Executing service " + joinPoint.getSignature().getName());
    }

    @Before("forAllEntities()")
    public void logEverythingInEntities(JoinPoint joinPoint) {
        logger.info("Executing entity " + joinPoint.getSignature().getName());
    }
    @Before("forAllDaos()")
    public void logEverythingInDaos(JoinPoint joinPoint) {
        logger.info("Executing dao " + joinPoint.getSignature().getName());
    }
}
