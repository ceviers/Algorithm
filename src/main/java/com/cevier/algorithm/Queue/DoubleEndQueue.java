package com.cevier.algorithm.Queue;

public class DoubleEndQueue<E> {

    private E[] deque;
    private int first;
    private int last;

    public DoubleEndQueue(){
        deque =  (E[]) new Object[10];
    }

    public int getSize(){
        if(first == last)
            return 0;
        if(last > first)
            return last - first;
        else
            return deque.length + last - first;
    }

    public void addFirst(E e){
        first = first == 0 ? deque.length - 1 : first - 1;
        if(first == last)
            resize(deque.length * 2);
        deque[first] = e;
    }

    public void addLast(E e){
        int nextIndex = (last + 1) % deque.length;
        if (first == nextIndex)
            resize(deque.length * 2);
        deque[last] = e;
        last = (last + 1) % deque.length;
    }

    public E popFirst(){
        if(first == last)
            throw new RuntimeException("the queue is empty");
        E firstElement = deque[first];
        first = (first + 1) % deque.length;
        if(getSize() < deque.length / 4 && deque.length > 2)
            resize(deque.length/2);
        return firstElement;
    }

    public E popLast(){
        if(first == last)
            throw new RuntimeException("the queue is empty");
        last = last == 0 ? deque.length - 1 : last - 1;
        E lastElement = deque[last];
        if(getSize() < deque.length / 4 && deque.length > 2)
            resize(deque.length/2);
        return lastElement;
    }

    public void resize(int capacity){
        E[] newData = (E[])new Object[capacity];
        int i = 0;
        for (i = 0; i < getSize(); i++) {
            newData[i] = deque[(first + i) % deque.length];
        }
        first = 0;
        last = i;
        deque = newData;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("size: " + getSize() + " capacity: " + (deque.length - 1));
        s.append("\nfirst [");
        for (int i = first; i != last; i = ++i % deque.length) {
            s.append(deque[i] );
            if(i != (last == 0 ? deque.length - 1 :last - 1))
                s.append(", ");
        }
        s.append("] last");

        return s.toString();
    }
}
