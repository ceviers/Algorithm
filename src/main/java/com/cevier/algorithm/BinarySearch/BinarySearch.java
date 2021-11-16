package com.cevier.algorithm.BinarySearch;

public class BinarySearch {
    private BinarySearch(){}

    public static <E extends Comparable<E>> int search(E[] arr, E target){
        return binarySearch(arr, 0, arr.length - 1, target);
    }

    private static <E extends Comparable<E>> int binarySearch(E[] arr, int l, int r, E target){
        if (l > r)
            return -1;

        int mid = l + (r - l) / 2;

        if(arr[mid].compareTo(target) == 0)
            return mid;

        if(arr[mid] .compareTo(target) < 0)
            return binarySearch(arr, mid + 1, r, target);

        return binarySearch(arr, l, mid - 1, target);
    }
}
