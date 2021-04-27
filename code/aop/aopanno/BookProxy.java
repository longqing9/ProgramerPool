package cn.longq.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Liu Hualong
 * @created: 2021/04/27 10:21
 */
@Component
@Aspect
@Order(1)
public class BookProxy {



    @Pointcut(value = "execution(* cn.longq.aopanno.Book.add(..))")  //公共部分抽取
    public void pointcut(){ }

    @Before(value = "pointcut()")
    public void before(){
        System.out.println("before。。。。。。。");
    }

    @After(value = "execution(* cn.longq.aopanno.Book.add(..))")
    public void after(){
        System.out.println("after。。。。。。。");
    }

    @AfterReturning(value = "execution(* cn.longq.aopanno.Book.add(..))")
    public void afterReturning(){
        System.out.println("AfterReturning。。。。。。。");
    }

    @AfterThrowing(value = "execution(* cn.longq.aopanno.Book.add(..))")
    public void afterThrowing(){
        System.out.println("AfterThrowing。。。。。。。");
    }

    @Around(value = "execution(* cn.longq.aopanno.Book.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around1。。。。。。。");

        proceedingJoinPoint.proceed();

        System.out.println("Around2。。。。。。。");

    }






}
