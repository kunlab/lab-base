package com.kunlab.base.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author likun
 * @date 2021/6/2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class SpringTest {

    @Value("${mq.broker.address}")
    private String mqBrokerAddress;

    @Test
    public void defaultConfig() {
        System.out.println("--------" + this.mqBrokerAddress);
    }
}
