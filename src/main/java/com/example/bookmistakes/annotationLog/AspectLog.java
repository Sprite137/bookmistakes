package com.example.bookmistakes.annotationLog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Aspect
@Component
public class AspectLog {

    @Pointcut("@annotation(SystemLog)")
    public void pt(){};

    @Before("@annotation(systemLog)")
    public void beforeLog(JoinPoint joinPoint,SystemLog systemLog){
//        String filePath = "example.txt";
//        String content = "日志来自"+joinPoint.getSignature()+systemLog.logName();
//
//        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.APPEND)) {
//            writer.write(content);
//            System.out.println("写入成功。");
//        }catch (IOException e) {
//            System.err.println(e);
//        }
    }

}
