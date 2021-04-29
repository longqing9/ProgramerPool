package cn.longq.aopxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: Liu Hualong
 * @created: 2021/04/27 11:07
 */
public class AOPXmlMain {
    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext("bean4.xml");

        User user = context.getBean("user", User.class);
        user.add();
    }

}
