package com.cevier.algorithm.MergeSort;

import java.util.Arrays;

import static com.cevier.algorithm.Tools.TestTools.arraySortFunctionTimeTester;

public class MergeSort3 {
    private MergeSort3(){}

    public static <E extends Comparable<E>> void  sort(E[] arr){
        mergeSort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void mergeSort(E[] arr, int l, int r){
        if(r - l < 15) {
            insertionSort(arr, l, r);
            return;
        }

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

    private static <E extends Comparable<E>> void insertionSort(E[] arr, int l, int r){
        for (int i = l; i <= r; i++) {
            E temp = arr[i];
            int j = i;
            for(; j - 1 >= l && temp.compareTo(arr[j - 1]) < 0; j--){
                arr[j] = arr[j -1];
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int n = 10000000;
        arraySortFunctionTimeTester(MergeSort.class, "sort", n);
        arraySortFunctionTimeTester(MergeSort2.class, "sort", n);
        arraySortFunctionTimeTester(MergeSort3.class, "sort", n);
    }
}
