package com.kunlab.demo.aopdemo.annotation;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author likun
 * @date 2021/4/29
 */
public class AppConfigTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Boy boy = context.getBean("boy", Boy.class);
        boy.buy();
    }

}
