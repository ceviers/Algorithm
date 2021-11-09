package com.cevier.algorithm.Tools;

import java.lang.reflect.Constructor;
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
            Constructor cons = c.getDeclaredConstructor();
            cons.setAccessible(true);
            Object o = cons.newInstance();
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

    /**
     * 数组排序耗时测试
     * @param c 方法所在类
     * @param method 被测试方法名
     * @param n 测试数据长度
     */
    public static void arraySortFunctionTimeTester(Class c, String method, int n){

        Integer[][] arrs = new Integer[3][n];

        arrs[0] = TestData.randomIntegerArray(n);
        arrs[1] = TestData.orderedIntegerArray(n);
        arrs[2] = TestData.inverseOrderedIntegerArray(n);

        try {
            Constructor cons = c.getDeclaredConstructor();
            cons.setAccessible(true);
            Object o = cons.newInstance();
            Method[] methods = c.getMethods();
            Method m = null;
            for (Method mtd: methods) {
                if(method.equals(mtd.getName())){
                    m = mtd;
                    break;
                }
            }

            for (int i = 0; i < arrs.length; i++) {
                Object a = arrs[i];
                long t0 = System.nanoTime();
                m.invoke(o, a);
                long t1 = System.nanoTime();

                for (int j = 1; j < arrs[i].length; j++) {
                    if(arrs[i][j - 1].compareTo(arrs[i][j]) > 0){
                        System.err.println("======================排序出错!======================");
                        break;
                    }
                }

                String r = "";
                switch(i){
                    case 0: r = "Random: " + (t1 - t0)/1000000.0 + "ms"; break;
                    case 1: r = "Ordered: " + (t1 - t0)/1000000.0 + "ms"; break;
                    case 2: r = "Inverse Order: " + (t1 - t0)/1000000.0 + "ms"; break;
                }
                System.out.println(r);
            }

        } catch (Exception e) {
            System.out.println("timeTester: Test error.");
            e.printStackTrace();
        }
    }

    /**
     * 长度为10000的数组排序耗时测试
     * @param c 方法所在类
     * @param method 被测试方法名
     */
    public static void arraySortFunctionTimeTester(Class c, String method){
        arraySortFunctionTimeTester(c, method, 10000);
    }
}
