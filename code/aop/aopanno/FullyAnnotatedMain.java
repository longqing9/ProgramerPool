package cn.longq.aopanno;

import cn.longq.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description: 完全注解开发
 * @author: Liu Hualong
 * @created: 2021/04/27 11:17
 */
public class FullyAnnotatedMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Book book = context.getBean("book", Book.class);
        book.add();
    }
}
