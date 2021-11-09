package com.cevier.algorithm.SelectionSort;

import org.junit.jupiter.api.Test;

public class SelectionSort {

    private SelectionSort(){}

    public static void sort(Integer[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[j] < arr[minIndex])
                    minIndex = j;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    @Test
    public void test(){
        Integer[] arr = {-1,3,-8,5,9,-4,5,6,9,-7,1,-2,5,-6};
        sort(arr);
        for (int a: arr) {
            System.out.print(a + " ");
        }
    }

}
