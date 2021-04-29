package cn.longq.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @description: 增强2
 * @author: Liu Hualong
 * @created: 2021/04/27 10:57
 */
@Order(0)
@Component
@Aspect
public class BooksProxy {


    @Pointcut(value = "execution(* cn.longq.aopanno.Book.add(..))")  //公共部分抽取
    public void pointcut(){ }

    @Before(value = "pointcut()")
    public void before(){
        System.out.println("books before。。。。。。。");
    }
}
