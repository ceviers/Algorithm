package com.cevier.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class QueueAsStack {
    private MyQueue queue;
    private MyQueue queue2;

    public QueueAsStack(){
        queue = new MyQueue();
        queue2 = new MyQueue();
    }

    public void push(int x) {
        queue.pushToBack(x);
    }

    public int pop() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.pushToBack(queue.popFromFront());
        }
        int r = queue.popFromFront();
        size = queue.size();
        for (int i = 0; i < size; i++) {
            queue2.pushToBack(queue.popFromFront());
        }
        queue = queue2;
        return r;
    }

    public int top() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.pushToBack(queue.popFromFront());
        }
        int r = queue.peekFromFront();
        queue.pushToBack(queue.popFromFront());
        for (int i = 0; i < size; i++) {
            queue2.pushToBack(queue.popFromFront());
        }
        queue = queue2;
        return r;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    class MyQueue{
        private Queue<Integer> queue;
        public MyQueue(){
            queue = new LinkedList<>();
        }
        public void pushToBack(int a){
            queue.offer(a);
        }
        public int peekFromFront(){
            return queue.peek();
        }

        public int popFromFront(){
            return queue.poll();
        }

        public int size(){
            return queue.size();
        }
        public boolean isEmpty(){
            return queue.isEmpty();
        }
    }
}
