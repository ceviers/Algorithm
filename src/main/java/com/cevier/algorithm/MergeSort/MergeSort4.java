package com.cevier.algorithm.MergeSort;

import javax.management.StandardEmitterMBean;
import java.util.Arrays;

import static com.cevier.algorithm.Tools.TestTools.arraySortFunctionTimeTester;

public class MergeSort4 {
    private MergeSort4(){}

    public static <E extends Comparable<E>> void  sort(E[] arr){
        E[] temp = Arrays.copyOf(arr, arr.length);
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable<E>> void mergeSort(E[] arr, int l, int r, E[] temp){
        if(l >= r)
            return;

        int mid = l + (r - l) / 2;

        mergeSort(arr, l, mid, temp);
        mergeSort(arr, mid + 1, r, temp);

        if(arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l ,mid, r, temp);
    }

    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp){
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l, j = mid + 1;
        for(int k = l; k <= r; k++)
            if(i > mid)
                arr[k] = temp[j++];
            else if(j > r)
                arr[k] = temp[i++];
            else
                arr[k] = temp[i].compareTo(temp[j]) <= 0 ? temp[i++] : temp[j++];

    }

    public static void main(String[] args) {
        int n = 10000000;
        arraySortFunctionTimeTester(MergeSort.class, "sort", n);
        arraySortFunctionTimeTester(MergeSort2.class, "sort", n);
        arraySortFunctionTimeTester(MergeSort3.class, "sort", n);
        arraySortFunctionTimeTester(MergeSort4.class, "sort", n);
    }
}
