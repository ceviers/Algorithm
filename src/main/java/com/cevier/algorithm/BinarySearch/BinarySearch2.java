package com.cevier.algorithm.BinarySearch;

public class BinarySearch2 {
    private BinarySearch2(){}

    public static <E extends Comparable<E>> int search(E[] arr, E target){
        int l = 0, r = arr.length;
        while (l < r){
            int mid = l + (r - l) / 2;
            if(arr[mid].compareTo(target) == 0)
                return mid;
            if(arr[mid].compareTo(target) < 0)
                l = mid + 1;
            else
                r = mid;
        }
        return -1;
    }
}
