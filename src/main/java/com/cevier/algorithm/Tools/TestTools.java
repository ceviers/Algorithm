package com.cevier.algorithm.Tools;

import java.lang.reflect.Method;

public class TestTools {
    /**
     * 测试方法执行loops次的时间
     * @param c 方法所属类
     * @param methods 方法名
     * @param loops 方法执行次数
     */
    public static void timeTester(Class c, int loops, String... methods){
        if(methods.length <= 0)
            return;

        try {
            Object o = c.newInstance();
            for (String method: methods) {
                Method m = c.getMethod(method);
                long t0 = System.nanoTime();
                for (int i = 0; i < loops; i++) {
                    m.invoke(o);
                }
                long t1 = System.nanoTime();
                System.out.println(method + ": " + (t1 - t0)/1000000 + "ms");
            }
        } catch (Exception e) {
            System.out.println("timeTester: Test error.");
            e.printStackTrace();
        }
    }

    /**
     * 测试方法执行1000000次的时间
     * @param c 方法所属类
     * @param methods 方法数组
     */
    public static void timeTester(Class c, String... methods){
        timeTester(c, 1000000, methods);
    }
}
