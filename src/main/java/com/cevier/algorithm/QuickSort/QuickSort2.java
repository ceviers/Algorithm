package com.cevier.algorithm.QuickSort;

import com.cevier.algorithm.MergeSort.MergeSort4;

import java.util.Random;

import static com.cevier.algorithm.Tools.TestTools.arraySortFunctionTimeTester;

public class QuickSort2 {
    private QuickSort2(){}

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

        p = r;
        int i = l + 1;
        while(true){
            while (i <= p && arr[i].compareTo(arr[l]) < 0) i++;
            while (p >= i && arr[p].compareTo(arr[l]) > 0) p--;
            if(i >= p) break;
            swap(arr, i++, p--);
        }
        swap(arr, l, p);
        return p;
    }

    private static <E> void swap(E[] arr, int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n = 10000;
        arraySortFunctionTimeTester(QuickSort.class, "sort", n);
        arraySortFunctionTimeTester(QuickSort2.class, "sort", n);
        arraySortFunctionTimeTester(MergeSort4.class, "sort", n);
    }
}
