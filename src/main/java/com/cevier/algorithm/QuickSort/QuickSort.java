package com.cevier.algorithm.QuickSort;

import com.cevier.algorithm.MergeSort.MergeSort4;

import java.util.Random;

import static com.cevier.algorithm.Tools.TestTools.arraySortFunctionTimeTester;

public class QuickSort {
    private QuickSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        Random random = new Random();
        quickSort(arr, 0 ,arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void quickSort(E[] arr, int l, int r, Random random){
        if(l >= r)
            return;
        int p = partition(arr, l, r, random);
        quickSort(arr, l, p - 1, random);
        quickSort(arr, p + 1, r, random);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random){
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);
        p = l;
        for(int i = l; i <= r; i++)
            if(arr[l].compareTo(arr[i]) > 0)
                swap(arr, ++p, i);
        swap(arr, l, p);
        return p;
    }

    private static <E> void swap(E[] arr, int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n = 1000000;
        arraySortFunctionTimeTester(QuickSort.class, "sort", n);
        arraySortFunctionTimeTester(MergeSort4.class, "sort", n);
    }
}
