package com.cevier.algorithm.Heap;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxHeap<E extends Comparable<E>> {
    private ArrayList<E> data;

    public MaxHeap(){
        data = new ArrayList<>();
    }
    public MaxHeap(E[] arr){
        data = new ArrayList<>(Arrays.asList(arr));
        heapify();
    }

    public int getSize(){
        return data.size();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    private int parent(int index){
        if (index == 0)
            return -1;
        return (index - 1) / 2;
    }

    private int leftChild(int index){
        return 2 * index + 1;
    }

    private int rightChild(int index){
        return 2 * index + 2;
    }

    public void add(E e){
        data.add(e);
        int index = data.size() - 1;
        while(index > 0 && data.get(index).compareTo(data.get(parent(index))) > 0) {
            swap(index, parent(index));
            index = parent(index);
        }
    }
    private void swap(int index1, int index2){
        E t = data.get(index1);
        data.set(index1, data.get(index2));
        data.set(index2, t);
    }

    public E findMax(){
        if(isEmpty())
            return null;
        return data.get(0);
    }

    public E extractMax(){
        if(isEmpty())
            return null;
        E max = data.get(0);
        swap(0, data.size() - 1);
        data.remove(data.size() - 1);
        int index = 0;
        siftDown(index);
        return max;
    }

    private void siftDown(int index){
        while (leftChild(index) < data.size()){
            int index1 = leftChild(index), index2 = rightChild(index);
            if(index2 < data.size() && data.get(index2).compareTo(data.get(index1)) > 0)
                index1 = index2;
            if(data.get(index).compareTo(data.get(index1)) >= 0)
                break;
            swap(index, index1);
            index = index1;
        }
    }

    public E replace(E e){
        E max = findMax();
        data.set(0, e);
        siftDown(0);
        return max;
    }

    public void print(){
        for (E d : data) {
            System.out.print(d + " ");
        }
        System.out.println();
    }

    public void heapify(){
        for(int index = data.size() - 1; index >= 0; index--)
            siftDown(index);
    }
}
