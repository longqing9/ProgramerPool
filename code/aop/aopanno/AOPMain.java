package cn.longq.aopanno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: AOP操作
 *  1、切入点表达式：execution([权限修饰符][返回类型][方法名称]([参数列表]))
 *      例如：
 *          execution(*cn.longq.service.Dao.add(..)) 对dao中的add方法增强；
 *          execution(*cn.longq.service.Dao.*(..)) 对dao中的所有方法增强；
 *          execution(*cn.longq.service.*.*(..)) 对service包中的a所有方法增强；
 *  2、多种通知类型
 *      前置通知    @Before
 *      后置通知    @After
 *      环绕通知    @Around
 *      异常通知    @AfterThrowing
 *      最终通知    @AfterReturning
 *  3、切点两种实现形式  详见BookProxy类
 *      1、定义方法使用 @Pointcut 后续使用该方法即可；
 *      2、@After(value = "execution(* cn.longq.aopanno.Book.add(..))")
 *  4、多个增强类的优先级
 *      1、使用注解：@Order(1) 指定执行的循序
 *
 *  5、完全注解方式：
 *      1、
 *
 *
 * @author: Liu Hualong
 * @created: 2021/04/27 10:09
 */
public class AOPMain {


    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext("bean3.xml");

        Book book = context.getBean("book", Book.class);
        Integer add = book.add();
//        System.out.println(add);


        return;
    }
}
