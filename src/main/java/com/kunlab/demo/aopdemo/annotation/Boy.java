package com.kunlab.demo.aopdemo.annotation;

import org.springframework.stereotype.Component;

/**
 * @author likun
 * @date 2021/4/29
 */
@Component
public class Boy implements IBuy{

    @Override
    public String buy() {
        System.out.println("男孩买了一个游戏机");
        return "游戏机";
    }
}
