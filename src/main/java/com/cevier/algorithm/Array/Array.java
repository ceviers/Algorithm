package com.cevier.algorithm.Array;

import java.util.Arrays;

public class Array<E> {

    private E[] data;
    private int size;

    public Array(){
        this.data = (E[])new Object[10];
        this.size = 0;
    }

    /**
     * @return 数组大小
     */
    public int getSize(){
        return size;
    }

    /**
     * @return 数组容量
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 添加元素
     * @param index 索引位置
     * @param e 被添加的元素
     */
    public void addElement(int index, E e){
        if(index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException("index " + index + " is not accessible");

        if(size == data.length)
            resize(2* data.length);

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    /**
     * 添加元素
     * @param e 被添加的元素
     */
    public void addElement(E e){
        addElement(size, e);
    }

    /**
     * 查找元素
     * @param e
     * @return 所查找元素的索引，不存在时返回 -1
     */
    public int find(E e){
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 根据索引获取元素
     * @param index 索引
     * @return
     */
    public E getElement(int index){
        if(index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("index " + index + " is not accessible");

        return data[index];
    }

    /**
     * 判断数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0 ? true : false;
    }

    /**
     * 删除索引位置上的元素
     * @param index 索引
     * @return 被删除元素
     */
    public E removeElementByIndex(int index){
        if(index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("index " + index + " is not accessible");

        E e = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;

        if(size == data.length/4 && data.length > 2)
            resize((int)(data.length / 2));

        return e;
    }

    /**
     * 删除数组中第一个元素 e
     * @param e
     * @return
     */
    public E removeElement(E e){
        int index = find(e);
        if(index >= 0)
            removeElementByIndex(index);
        return e;
    }

    /**
     * 修改元素
     * @param index 被修改元素的索引
     * @param e
     */
    public void setElement(int index, E e){
        if(index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("index " + index + " is not accessible");

        data[index] = e;
    }

    private void resize(int capacity){
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("size: " + size + "\tcapacity: " + data.length + "\n");
        s.append("[");
        for (int i = 0; i < size; i++) {
            s.append(data[i]);
            if(i != size - 1)
                s.append(", ");
        }
        s.append("]");
        return s.toString();
    }
}
