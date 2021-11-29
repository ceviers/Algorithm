package com.cevier.algorithm.RedBlackTree;

public class RedBlackTree<K extends Comparable<K>, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{
        public K key;
        public V value;
        public boolean color;
        Node left, right;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
            color = RED;
            left = right = null;
        }
    }

    private int size;
    private Node root;

    public RedBlackTree(){
        size = 0;
        root = null;
    }

    public int getSize(){
        return size;
    }

    public boolean isRed(Node node) {
        if(node == null)
            return BLACK;
        return node.color;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(K key, V value){
        root = add(root, key, value);
        root.color = BLACK;
    }

    private Node add(Node node, K key, V value){
        if(node == null) {
            size++;
            return new Node(key, value);
        }

        if(key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else if(key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else
            node.value = value;

        if(isRed(node.right) && !isRed(node.left))
            node = leftRotate(node);

        if(isRed(node.left) && isRed(node.left.left))
            node = rightRotate(node);

        if(isRed(node.left) && isRed(node.right))
            flipColors(node);

        return node;
    }

    public boolean contains(K key){
        Node node = getNode(root, key);
        return node != null;
    }

    public V get(K key){
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    private Node getNode(Node node, K key){
        if(node == null)
            return null;
        if(key.compareTo(node.key) > 0)
            return getNode(node.right, key);
        else if(key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else
            return node;
    }

    public void set(K key, V value){
        Node node = getNode(root, key);
        if(node != null)
            node.value = value;
    }

    private Node leftRotate(Node node){
        Node R = node.right;
        node.right = R.left;
        R.left = node;
        R.color = node.color;
        node.color = RED;
        return R;
    }

    private void flipColors(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    private Node rightRotate(Node node){
        Node L = node.left;
        node.left = L.right;
        L.right = node;
        L.color = node.color;
        node.color = RED;
        return L;
    }
}
