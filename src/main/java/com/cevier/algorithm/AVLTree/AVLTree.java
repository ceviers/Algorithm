package com.cevier.algorithm.AVLTree;

import java.util.ArrayList;

public class AVLTree<K extends Comparable<K>, V> {
    private class Node{
        public K key;
        public V value;
        public int height;
        public Node left;
        public Node right;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
        public Node(K key){
            this(key, null);
        }
    }

    private Node root;
    private int size;

    public AVLTree(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getHeight(Node node){
        if(node == null)
            return 0;
        return node.height;
    }

    public void add(K key, V value){
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value){
        if(node == null) {
            size++;
            return new Node(key, value);
        }

        if(node.key.compareTo(key) < 0)
            node.right = add(node.right, key, value);
        else if(node.key.compareTo(key) > 0)
            node.left = add(node.left, key, value);
        else
            node.value = value;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        return balance(node);
    }

    private Node balance(Node node){
        if(balanceFactor(node) > 1 && balanceFactor(node.left) >= 0)
            return rightRotate(node);
        if(balanceFactor(node) < -1 && balanceFactor(node.right) <= 0)
            return leftRotate(node);
        if(balanceFactor(node) > 1 && balanceFactor(node.left) < 0){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if(balanceFactor(node) < -1 && balanceFactor(node.right) > 0){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private int balanceFactor(Node node){
        if (node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    private Node rightRotate(Node node){
        Node L = node.left;
        Node LR = node.left.right;
        L.right = node;
        node.left = LR;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        L.height = Math.max(getHeight(L.left), getHeight(L.right)) + 1;
        return L;
    }

    private Node leftRotate(Node node){
        Node R = node.right;
        Node RL = node.right.left;
        R.left = node;
        node.right = RL;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        R.height = Math.max(getHeight(R.left), getHeight(R.right)) + 1;
        return R;
    }

    public void remove(K key){
        root = remove(root, key);
    }

    private Node remove(Node node, K key){
        if(node == null)
            return null;
        Node subRoot;
        if(key.compareTo(node.key) == 0){
            if(node.left == null){
                Node right = node.right;
                node.right = null;
                size--;
                subRoot = right;
            }else if(node.right == null){
                Node left = node.left;
                node.left = null;
                size--;
                subRoot = left;
            }else{
                Node successor = minimum(node.right);
                successor.right = remove(node.right, successor.key);
                successor.left = node.left;
                node.left = node.right = null;
                subRoot = successor;
            }
        }else if(key.compareTo(node.key) > 0){
            node.right = remove(node.right, key);
            subRoot = node;
        }else{
            node.left = remove(node.left, key);
            subRoot = node;
        }

        if(subRoot == null)
            return null;
        subRoot.height = Math.max(getHeight(subRoot.left), getHeight(subRoot.right)) + 1;
        return balance(subRoot);
    }

    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    public boolean isBSTree(){
        ArrayList<K> arr = new ArrayList<>();
        inOrder(root, arr);
        for (int i = 0; i < arr.size() - 1; i++)
            if(arr.get(i).compareTo(arr.get(i + 1)) > 0)
                return false;
        return true;
    }

    private void inOrder(Node node, ArrayList<K> arr){
        if(node == null)
            return;
        inOrder(node.left, arr);
        arr.add(node.key);
        inOrder(node.right, arr);
    }

    public boolean isAVLTree(){
        return isAVLTree(root);
    }

    private boolean isAVLTree(Node node){
        if(node == null)
            return true;
        if(balanceFactor(node) <= 1 && balanceFactor(node) >= -1)
            return isAVLTree(node.left) && isAVLTree(node.right);
         return false;
    }
}