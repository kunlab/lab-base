package com.kunlab.demo.aopdemo.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 定义一个切面
 * @author likun
 * @date 2021/4/29
 */
@Aspect //表明这是一个切面
@Component
public class BuyAspectJ {

    @Before("execution(* com.kunlab.demo.aopdemo.annotation.IBuy.buy(..))") //声明切点，@Before表示调用方法前执行
    public void haha() {
        System.out.println("孩子们买了自己喜欢的玩具");
    }
}
