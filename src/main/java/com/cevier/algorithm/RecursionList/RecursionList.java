package com.cevier.algorithm.RecursionList;

public class RecursionList<E> {
    private class Node<E>{
        public E e;
        public Node next;
        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e, null);
        }
        @Override
        public String toString(){
            return e.toString();
        }
    }

    private int size;
    private Node head;

    public RecursionList(){
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public void add(int index, E e){
        head = add(head, index, e);
    }

    public void add(E e){
        add(0, e);
    }

    public void removeElement(E e){
        head = removeElement(head, e);
    }

    public void remove(int index){
        head = removeElementByIndex(head, index);
    }

    public void remove(){
        head = removeElementByIndex(head, 0);
    }

    private Node add(Node headNode, int index, E e){
        if (index < 0 || index > size)
            return headNode;

        if (index == 0) {
            size++;
            return new Node<E>(e, headNode);
        }
        headNode.next = add(headNode.next, index - 1, e);
        return headNode;
    }

    private Node removeElement(Node headNode, E e){
        if (headNode.next == null)
            return null;

        if (headNode.e.equals(e)) {
            size--;
            return headNode.next;
        }else{
            headNode.next = removeElement(headNode.next, e);
            return headNode;
        }
    }

    private Node removeElementByIndex(Node headNode, int index){
        if (index < 0 || index >= size)
            return headNode;

        if(index == 0) {
            size--;
            return headNode.next;
        } else {
            headNode.next = removeElementByIndex(headNode.next, index - 1);
            return headNode;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("size: " + size + "\nhead: ");
        Node curr = head;
        while (curr != null){
            s.append(curr.e);
            if (curr.next != null)
                s.append(" -> ");
            curr = curr.next;
        }
        return s.toString();
    }
}
