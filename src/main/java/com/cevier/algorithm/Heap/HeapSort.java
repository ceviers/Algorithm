package com.cevier.algorithm.Heap;

public class HeapSort {
    private HeapSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        MaxHeap<E> mh = new MaxHeap<>();
        for (E e : arr)
            mh.add(e);
        for (int i = arr.length - 1; i >= 0; i--)
            arr[i] = mh.extractMax();
    }
}
