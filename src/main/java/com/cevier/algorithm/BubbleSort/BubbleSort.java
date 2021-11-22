package com.cevier.algorithm.BubbleSort;

public class BubbleSort {
    private BubbleSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j].compareTo(arr[j + 1]) > 0){
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if(flag) break;
        }
    }

    private static <E> void swap(E[] arr, int i, int j){
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] =  t;
    }
}
