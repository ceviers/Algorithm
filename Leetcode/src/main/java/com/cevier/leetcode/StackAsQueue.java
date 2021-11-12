package com.cevier.leetcode;

import java.util.Stack;

public class StackAsQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public StackAsQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int r = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return r;
    }

    public int peek() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int r = stack2.peek();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return r;

    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}
