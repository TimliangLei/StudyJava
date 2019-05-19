package com.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AOP {
    @Before("execution(* com.factory.*.*())")
    public void begin(){
        System.out.println("开始事务...");
    }
    @After("execution(* com.factory.*.*())")
    public void close(){
        System.out.println("提交事务...");
    }
}
