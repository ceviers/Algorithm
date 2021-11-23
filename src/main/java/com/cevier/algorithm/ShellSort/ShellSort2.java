package com.cevier.algorithm.ShellSort;

public class ShellSort2 {
    private ShellSort2(){};

    public static <E extends Comparable<E>> void sort(E[] arr){
        int h = 0;
        while(h < arr.length / 3) h = 3 * h + 1;
        while(h > 0){
            for (int i = h; i < arr.length; i++) {
                E t = arr[i];
                int j;
                for (j = i; j >= h && t.compareTo(arr[j - h]) < 0; j -= h)
                    arr[j] = arr[j - h];
                arr[j] = t;
            }
            h = h / 3;
        }
    }
}
