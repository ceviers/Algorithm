package com.cevier.algorithm.Queue;

public class LoopQueue<E> implements Queue<E> {
    private E[] queue;
    private int front, tail;

    public LoopQueue(){
        this.queue = (E[])new Object[5];
        this.front = 0;
        this.tail = 0;
    }

    @Override
    public int getSize() {
        if(front == tail)
            return 0;
        if(front > tail)
            return front - tail;
        return front - tail + queue.length;
    }

    @Override
    public void offer(E e) {
        int postFront = front == queue.length - 1 ? 0 : front + 1;
        if(postFront == tail)
            resize(queue.length * 2);
        queue[front] = e;
        front = ++front % queue.length;
    }

    @Override
    public E poll() {
        if(getSize() == 0)
            throw new RuntimeException("the queue is empty");
        E lastElement = queue[tail];
        tail = ++tail % queue.length;
        if(getSize() < queue.length / 4 && queue.length > 2)
            resize(queue.length / 2);
        return lastElement;
    }

    @Override
    public E peek() {
        return queue[front == 0 ? queue.length : front - 1];
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0 ? true : false;
    }

    private void resize(int capacity){
        E[] newQueue = (E[])new Object[capacity];
        int queueSize = getSize();
        for (int i = 0; i <= queueSize; i++) {
            newQueue[i] = queue[(i + tail) % queue.length];
        }
        queue = newQueue;
        tail = 0;
        front = getSize();
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("size: " + getSize() + " capacity: " + (queue.length - 1) + "\n[");
        int preFront = front == 0 ? queue.length - 1 : front - 1;
        for (int i = tail; i != front; i = ++i % queue.length) {
            s.append(queue[i]);
            if (i != preFront)
                s.append(", ");
        }
        s.append("] front" + front + " tail" + tail);
        return s.toString();
    }
}
