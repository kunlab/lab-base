package com.kunlab.base.core.util;


/**
 * @author likun
 * @date 2021/4/26
 */
public class DataSourceHolderTest {

    private static final ThreadLocal<String> LOCAL = new ThreadLocal<String>();

    static void print(String str) {
        System.out.println(str + ": " + LOCAL.get());
        LOCAL.remove();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                LOCAL.set("t1");
                print("t1");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                LOCAL.set("t2");
                print("t2");
            }
        });

        t1.start();
        t2.start();
    }
}
