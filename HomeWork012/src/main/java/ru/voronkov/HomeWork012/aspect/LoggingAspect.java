package ru.voronkov.HomeWork012.aspect;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log
public class LoggingAspect {

    //Аспект для методов помеченных аннотацией TrackUserAction
    @Around("@annotation(ru.voronkov.HomeWork008Task1.aspect.TrackUserAction)")
    public Object methodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Метод " + joinPoint.getSignature().getName() + "был вызван");
        return joinPoint.proceed();
    }

    //Аспект для методов помеченных аннотацией TimeExecute
    @Around("@annotation(ru.voronkov.HomeWork008Task1.aspect.TimeExecute)")
    public Object timeExecute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        System.out.println("Метод " + joinPoint.getSignature().getName() + " выполнялся " + executionTime + " ms");
        return result;

    }
}


