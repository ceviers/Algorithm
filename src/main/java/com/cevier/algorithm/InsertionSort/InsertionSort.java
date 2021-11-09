package com.cevier.algorithm.InsertionSort;

import com.cevier.algorithm.Tools.AnObject;
import org.junit.jupiter.api.Test;

public class InsertionSort {

    private InsertionSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        for (int i = 0; i < arr.length; i++) {
            for(int j = i; j > 0; j--){
                if(arr[j].compareTo(arr[j - 1]) < 0){
                    E temp = arr[j];
                    arr[j] = arr[j -1];
                    arr[j - 1] = temp;
                }else{
                    break;
                }
            }
        }
    }

    @Test
    public void test(){
//        Integer[] arr = {1,2,8,9,7,6,-4,-8,10};
        AnObject[] arr = {new AnObject(1, "tom", 25), new AnObject(2, "jerry", 29), new AnObject(4, "tommy", 21)};
        sort(arr);
        for (AnObject a : arr) {
            System.out.print(a + " ");

        }
    }

}
