package com.cevier.algorithm.Queue;

import com.cevier.algorithm.Array.Array;

public class ArrayQueue<E> implements Queue<E> {
    private Array<E> queue;

    public ArrayQueue(){
        this.queue = new Array<>();
    }

    @Override
    public int getSize() {
        return queue.getSize();
    }

    @Override
    public void offer(E e) {
        queue.addElement(e);
    }

    @Override
    public E poll() {
        return queue.removeElementByIndex(0);
    }

    @Override
    public E peek() {
        return queue.getElement(0);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
