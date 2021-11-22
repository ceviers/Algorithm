package com.cevier.algorithm.PriorityQueue;

import com.cevier.algorithm.Heap.MaxHeap;
import com.cevier.algorithm.Queue.Queue;

public class PriorityQueue<E extends Comparable<E>> implements Queue {
    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public void offer(Object o) {
        maxHeap.add((E)o);
    }

    @Override
    public E poll() {
        return maxHeap.extractMax();
    }

    @Override
    public E peek() {
        return maxHeap.findMax();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
