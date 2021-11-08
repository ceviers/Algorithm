package com.cevier.algorithm.DoubleLinkedList;

/*
    链表节点
 */
public class Node<K, V>{
    private K key;
    private V value;
    private Node preNode;
    private Node postNode;

    public Node(K key, V value){
        this.key = key;
        this.value = value;
        this.preNode = null;
        this.postNode = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node getPreNode() {
        return preNode;
    }

    public void setPreNode(Node preNode) {
        this.preNode = preNode;
    }

    public Node getPostNode() {
        return postNode;
    }

    public void setPostNode(Node postNode) {
        this.postNode = postNode;
    }

    @Override
    public String toString() {
        return "{" + key + ':' +value + '}';
    }
}
