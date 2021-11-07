package ru.spring.project.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* ru.spring.project.utils.ResourceReader.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Прокси : " + joinPoint.getThis().getClass().getName());
        System.out.println("Класс : " + joinPoint.getTarget().getClass().getName());
        System.out.println("Вызов метода : " + joinPoint.getSignature().getName());

        System.out.println("Параметры метода:" + Arrays.toString(joinPoint.getArgs()));
        Object proceed = joinPoint.proceed();
        return proceed;
    }
}
