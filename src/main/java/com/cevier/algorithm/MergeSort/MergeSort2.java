package com.cevier.algorithm.MergeSort;

import com.cevier.algorithm.InsertionSort.InsertionSort4;

import java.util.Arrays;

import static com.cevier.algorithm.Tools.TestTools.arraySortFunctionTimeTester;

public class MergeSort2 {
    private MergeSort2(){}

    public static <E extends Comparable<E>> void  sort(E[] arr){
        mergeSort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void mergeSort(E[] arr, int l, int r){
        if(l >= r)
            return;

        int mid = l + (r - l) / 2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        if(arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l ,mid, r);
    }

    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r){
        int i = l, j = mid + 1;
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);
        for(int k = l; k <= r; k++)
            if(i > mid)
                arr[k] = temp[j++ - l];
            else if(j > r)
                arr[k] = temp[i++ - l];
            else
                arr[k] = temp[i - l].compareTo(temp[j - l]) <= 0 ? temp[i++ - l] : temp[j++ - l];

    }

    public static void main(String[] args) {
        int n = 100000;
//        arraySortFunctionTimeTester(MergeSort.class, "sort", n);
        arraySortFunctionTimeTester(MergeSort2.class, "sort", n);
//        arraySortFunctionTimeTester(InsertionSort4.class, "sort", n);
    }
}
