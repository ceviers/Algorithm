package com.cevier.algorithm.LinkList;

public class LinkList<E> {

    private class Node<E>{
        public E e;
        public Node next;

        public Node(E e){
            this(e, null);
        }

        public Node(E e, Node node){
            this.e = e;
            this.next = node;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyNode;
    private int size;

    public LinkList(){
        dummyNode = new Node(null, null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public void add(int index, E e){
        if(index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException("index is illegal");
        Node pre = dummyNode;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(e, pre.next);
        size++;
    }

    public void add(E e){
        add(0,e);
    }

    public E remove(int index){
        if(index < 0 || index > size - 1)
            throw new ArrayIndexOutOfBoundsException("index is illegal");
        Node pre = dummyNode;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node curr = pre.next;
        pre.next = curr.next;
        curr.next = null;
        size--;
        return (E)curr.e;
    }

    public boolean find(E e){
        Node curr = dummyNode.next;
        while(curr != null){
            if(curr.e.equals(e))
                return true;
            curr = curr.next;
        }
        return false;
    }

    public void set(int index, E e){
        Node curr = dummyNode.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.e = e;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("head:");
        for(Node curr = dummyNode.next; curr != null; curr = curr.next)
            s.append(" -> " + curr);
        s.append(" -> NULL");
        return s.toString();
    }
}
