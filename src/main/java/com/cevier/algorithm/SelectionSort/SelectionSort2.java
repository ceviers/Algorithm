package com.cevier.algorithm.SelectionSort;

import org.junit.jupiter.api.Test;

public class SelectionSort2 {

    private SelectionSort2(){}

    public static <E extends Comparable<E>>void sort(E[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }
            E temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    @Test
    public void test(){
        Integer[] arr = {-1,3,-8,5,9,-4,5,6,9,-7,1,-2,5,-6};
//        AnObject[] arr = {new AnObject(1, "tom", 25), new AnObject(2, "jerry", 29), new AnObject(4, "tommy", 21)};
        sort(arr);
        for (Integer a: arr) {
            System.out.print(a + " ");
        }
    }

}

