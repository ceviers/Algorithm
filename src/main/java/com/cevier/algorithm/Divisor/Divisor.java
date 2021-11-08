package com.cevier.algorithm.Divisor;

import org.junit.jupiter.api.Test;

//约数
public class Divisor {

    public static void printDivisor1(int n){
        for (int i = 1; i <= n; i++) {
            if(n % i == 0)
                System.out.println(i);
        }
    }

    public static void printDivisor2(int n){
        for (int i = 1; i * i <= n; i++) {
            if(n % i == 0){
                System.out.println(i);
                if(n / i != i)
                    System.out.println(n / i);
            }
        }
    }

    @Test
    public void test(){
        printDivisor1(64);
        System.out.println("-------------");
        printDivisor2(64);
    }
}
