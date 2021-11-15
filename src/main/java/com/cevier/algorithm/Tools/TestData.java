package com.cevier.algorithm.Tools;

import java.util.Random;

public class TestData {

    private TestData(){}

    public static Integer[] randomIntegerArray(int n){
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i % 2 == 0 ? random.nextInt(n) : 0 - random.nextInt(n);
        }
        return arr;
    }

    public static Integer[] orderedIntegerArray(int n){
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i - n / 2;
        }
        return arr;
    }

    public static Integer[] inverseOrderedIntegerArray(int n){
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = n / 2 - i;
        }
        return arr;
    }

    public static Integer[] sameValeArray(int n){
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        return arr;
    }
}
