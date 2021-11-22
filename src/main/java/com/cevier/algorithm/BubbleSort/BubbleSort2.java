package com.cevier.algorithm.BubbleSort;

public class BubbleSort2 {
    private BubbleSort2(){}

    public static <E extends Comparable<E>> void sort(E[] arr){

        for (int i = 0; i < arr.length - 1;) {
            int lastSwappedIndex = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j].compareTo(arr[j + 1]) > 0){
                    swap(arr, j, j + 1);
                    lastSwappedIndex = j + 1;
                }
            }
            i = arr.length - lastSwappedIndex;
        }
    }

    private static <E> void swap(E[] arr, int i, int j){
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] =  t;
    }
}
