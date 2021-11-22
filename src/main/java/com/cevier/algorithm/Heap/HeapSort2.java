package com.cevier.algorithm.Heap;

public class HeapSort2 {
    private HeapSort2(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        if(arr.length <= 1)
            return;
        for (int i = (arr.length -2) / 2; i >= 0; i--)
            siftDown(arr, i, arr.length);

        for (int i = arr.length - 1; i > 0 ; i--) {
            swap(arr, 0, i);
            siftDown(arr, 0, i);
        }
    }

    private static <E extends Comparable<E>> void siftDown(E[] arr, int index, int n){
        while((2 * index + 1) < n){
            int index1 = 2 * index + 1, index2 = index1 + 1;
            if(index2 < n && arr[index2].compareTo(arr[index1]) > 0)
                index1 = index2;
            if(arr[index].compareTo(arr[index1]) >= 0)
                break;
            swap(arr, index, index1);
            index = index1;
        }
    }

    private static <E extends Comparable<E>>void swap(E[] arr, int index1, int index2){
        E t = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = t;
    }
}
