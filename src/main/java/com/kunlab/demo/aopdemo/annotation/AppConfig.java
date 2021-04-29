package com.kunlab.demo.aopdemo.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author likun
 * @date 2021/4/29
 */
@Configuration
@ComponentScan(basePackageClasses = {com.kunlab.demo.aopdemo.annotation.IBuy.class})
public class AppConfig {
}
