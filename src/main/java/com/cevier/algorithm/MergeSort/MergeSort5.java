package com.cevier.algorithm.MergeSort;

import java.util.Arrays;

import static com.cevier.algorithm.Tools.TestTools.arraySortFunctionTimeTester;

//自下而上的归并排序
public class MergeSort5 {

    private MergeSort5(){};

    public static <E extends Comparable<E>> void sort(E[] arr){
        E[] temp = Arrays.copyOf(arr, arr.length);
        mergeSort(arr, 1, temp);
    }

    private static <E extends Comparable<E>> void mergeSort(E[] arr, int size, E[] temp){
        if(size >= arr.length)
            return;

        for(int i = 0; i + size < arr.length; i += 2 * size){;
            int mid = i + size - 1;
            int r = i + 2 * size - 1 < arr.length ? i + 2 * size - 1 : arr.length - 1;
            if(arr[mid].compareTo(arr[mid + 1]) > 0 )
                merge(arr, i, mid, r, temp);
        }
        mergeSort(arr, 2 * size, temp);
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
//        for (int i = 0; i < 100; i++) {
//            arraySortFunctionTimeTester(MergeSort5.class, "sort", i);
//        }
        arraySortFunctionTimeTester(MergeSort.class, "sort", 10000000);
        arraySortFunctionTimeTester(MergeSort4.class, "sort", 10000000);
        arraySortFunctionTimeTester(MergeSort5.class, "sort", 10000000);

    }
}
