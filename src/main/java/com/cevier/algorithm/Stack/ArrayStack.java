package com.cevier.algorithm.Stack;

import com.cevier.algorithm.Array.Array;

public class ArrayStack<E> implements Stack<E>{
    private Array<E> stack;

    public ArrayStack(){
        stack = new Array<>();
    }

    @Override
    public void push(E e) {
        stack.addElement(e);
    }

    @Override
    public E pop() {
        return stack.removeElementByIndex(stack.getSize() - 1);
    }

    @Override
    public E peek() {
        return stack.getElement(stack.getSize() - 1);
    }

    @Override
    public int getSize() {
        return stack.getSize();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

}
