package com.cevier.algorithm.QuickSort;

import com.cevier.algorithm.MergeSort.MergeSort4;

import java.util.Random;

import static com.cevier.algorithm.Tools.TestTools.arraySortFunctionTimeTester;

public class QuickSort3 {
    private QuickSort3(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        Random random = new Random();
        quickSort(arr, 0 ,arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void quickSort(E[] arr, int l, int r, Random random){
        if(l >= r)
            return;
        int p[] = partition(arr, l, r, random);
        quickSort(arr, l, p[0], random);
        quickSort(arr, p[1], r, random);
    }

    private static <E extends Comparable<E>> int[] partition(E[] arr, int l, int r, Random random){
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);
        p = l + 1;
        int[] lr = {l, r + 1};//存储左右两路数组的右、左边界
        while(p < lr[1])
            if(arr[p].compareTo(arr[l]) < 0)
                swap(arr, ++lr[0], p++);
            else if(arr[p].compareTo(arr[l]) == 0)
                p++;
            else
                swap(arr, p, --lr[1]);
        swap(arr, l, lr[0]--);
        return lr;
    }

    private static <E> void swap(E[] arr, int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n = 1000000;
        arraySortFunctionTimeTester(QuickSort2.class, "sort", n);
        arraySortFunctionTimeTester(QuickSort3.class, "sort", n);
        arraySortFunctionTimeTester(MergeSort4.class, "sort", n);
    }
}
