package com.cevier.algorithm.LlinearSearch;

import org.junit.jupiter.api.Test;

public class LinearSearch {

    private LinearSearch(){}

    public static int findIndex(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target)
                return i;
        }
        return -1;
    }

    @Test
    public void Test() {
        int[] arr = {1,2,5,3,9,7,5,6,8,4,2,5,11,35};
        System.out.println(findIndex(arr, 8));
    }
}
