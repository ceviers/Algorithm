package com.cevier.DoubleLinkedList;

public class DoubleLinkedList {
    private int capacity;
    private Node head;
    private Node tail;
    private int size;

    public DoubleLinkedList() {
        this.capacity = 0xffff;
        this.size = 0;
    }

    public DoubleLinkedList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public Node addHead(Node node){

        if(size >= capacity)
            throw new ArrayIndexOutOfBoundsException();

        if(this.head == null){
            this.head = node;
            this.tail = node;
            this.head.setPreNode(null);
            this.tail.setPostNode(null);
        }else{
            this.head.setPreNode(node);
            node.setPostNode(this.head);
            node.setPreNode(null);
            this.head = node;
        }
        this.size++;

        return node;
    }

    public Node addTail(Node node){
        if(size >= capacity)
            throw new ArrayIndexOutOfBoundsException();

        if(this.tail == null){
            this.head = node;
            this.tail = node;
            this.head.setPreNode(null);
            this.tail.setPostNode(null);
        }else{
            this.tail.setPostNode(node);
            node.setPreNode(this.tail);
            node.setPostNode(null);
            this.tail = node;
        }
        this.size++;
        return node;
    }

    public Node removeNode(Node node){
        if(node == this.head){
            popHead();
        }else if(node == this.tail){
            popTail();
        }else if(node != null){
            node.getPreNode().setPostNode(node.getPostNode());
            node.getPostNode().setPreNode(node.getPreNode());
            this.size--;
        }
        return node;
    }

    public Node popHead(){
        if(this.head == null)
            return null;
        Node node = this.head;
        if(this.head.getPostNode() != null){
            this.head = this.head.getPostNode();
            this.head.setPreNode(null);
        }else{
            this.head = null;
            this.tail = null;
        }
        this.size--;
        return node;
    }

    public Node popTail(){
        if(this.tail == null)
            return null;
        Node node = this.tail;
        if(this.tail.getPreNode() != null){
            this.tail = this.tail.getPreNode();
            this.tail.setPostNode(null);
        }else{
            this.head = null;
            this.tail = null;
        }
        this.size--;
        return node;
    }

    public String toString(){
        Node n = this.head;
        String ns = "";
        while(n != null){
            ns += n.toString() + "->";
            n = n.getPostNode();
        }
        return ns;
    }
}
