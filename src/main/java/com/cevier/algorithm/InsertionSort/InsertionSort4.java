package com.cevier.algorithm.InsertionSort;

import com.cevier.algorithm.Tools.AnObject;
import org.junit.jupiter.api.Test;

public class InsertionSort4 {

    private InsertionSort4(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        for (int i = arr.length - 1; i >= 0; i--) {
            E temp = arr[i];
            int j = i;
            for(; j < arr.length - 1 && temp.compareTo(arr[j + 1]) > 0; j++){
                arr[j] = arr[j + 1];
            }
            arr[j] = temp;
        }
    }

    @Test
    public void test(){
//        Integer[] arr = {11,2,8,9,7,6,-4,-8,10};
        AnObject[] arr = {new AnObject(1, "tom", 25), new AnObject(2, "jerry", 29), new AnObject(4, "tommy", 21)};
        sort(arr);
        for (AnObject a : arr) {
            System.out.print(a + " ");

        }
    }

}
