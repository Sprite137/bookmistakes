package com.example.bookmistakes.annotationLog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLog {

    @Pointcut("@annotation(SystemLog)")
    public void pt(){};

    @Before("@annotation(systemLog)")
    public void beforeLog(JoinPoint joinPoint,SystemLog systemLog){
        System.err.println("日志来自"+joinPoint.getSignature()+systemLog.logName());
    }

}
