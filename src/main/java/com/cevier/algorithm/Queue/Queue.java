package com.cevier.algorithm.Queue;

public interface Queue<E> {
    int getSize();
    void offer(E e);
    E poll();
    E peek();
    boolean isEmpty();
}
