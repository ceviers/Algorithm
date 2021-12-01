package com.cevier.algorithm.CountingSort;

import java.util.Arrays;
import java.util.Random;

public class CountingSort<E> {
    public static void main(String[] args) {
        int R = 10;
        Animal[] anis = new Animal[15];
        for (int i = 0; i < anis.length; i++) {
            anis[i] = new Animal(new Random().nextInt(R), "dog" + i);
        }

        int[] count = new int[R];
        for (Animal ani : anis)
            count[ani.getAmount()]++;

        int[] index = new int[R + 1];
        for (int i = 1; i < index.length; i++)
            index[i] = index[i - 1] + count[i - 1];

        Animal[] temp = Arrays.copyOf(anis, anis.length);
        for (Animal ani : anis)
            temp[index[ani.getAmount()]++] = ani;

        for (int i = 0; i < temp.length; i++)
            anis[i] = temp[i];

        for (Animal ani : anis) {
            System.out.println(ani);
        }
    }
}
