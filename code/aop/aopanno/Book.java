package cn.longq.aopanno;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Liu Hualong
 * @created: 2021/04/27 10:21
 */
@Component
public class Book {

    public Integer  add(){
        System.out.println("add...........");

//       int q = 1/0;

       return 0;
    }

}
