package com.cevier.algorithm.LinearSearch;

import org.junit.jupiter.api.Test;

public class LinearSearch2 {

    private LinearSearch2(){}

    public static <E> int findIndex(E[] arr, E target){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(target))
                return i;
        }
        return -1;
    }

    @Test
    public void Test() {
//        Integer[] arr = {1,2,5,3,9,7,5,6,8,4,2,5,11,35};
//        String[] arr = {"1","2","5","3","9","77","5","6"};
//        System.out.println(findIndex(arr, 7));
        AnObject[] arr = {new AnObject(1, "Tom", 13), new AnObject(23, "jerry", 32)};
        System.out.println(findIndex(arr, new AnObject(23, "Tom cat", 24)));
    }
}
