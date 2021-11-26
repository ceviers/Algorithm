package com.cevier.algorithm.Trie;

import java.util.Map;
import java.util.TreeMap;

public class Trie {
    private class Node{
        public String value;
        public Map<Character, Node> next;
        public Node(){
            this(null);
        }
        public Node(String value){
            this.value = value;
            next = new TreeMap<>();
        }
        @Override
        public String toString(){
            return value;
        }
    }

    private int size;
    private Node root;

    public Trie(){
        size = 0;
        root = new Node();
    }

    public int getSize(){
        return size;
    }

    public void add(String word, String meaning){
        if(word.length() == 0) return;
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.next.get(c) == null)
                curr.next.put(c, new Node());
            curr = curr.next.get(c);
        }
        if(curr.value == null)
            size++;
        curr.value = meaning;
    }

    public String query(String word){
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.next.get(c) == null)
                return null;
            else
                curr = curr.next.get(c);
        }
        return curr.value;
    }

    public boolean isPrefix(String prefix){
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(curr.next.get(c) == null)
                return false;
            curr = curr.next.get(c);
        }
        return true;
    }
    
    public String delete(String word){
        Node curr = root;
        Node preWord = root;
        char preChar = word.charAt(0);
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.next.get(c) == null)
                return null;
            if (curr.next.keySet().size() > 1 || curr.value != null) {
                preWord = curr;
                preChar = c;
            }
            curr = curr.next.get(c);
        }
        String meaning = curr.value;

        if(meaning != null)
            size--;

        if(!curr.next.keySet().isEmpty())
            curr.value = null;
        else
            preWord.next.remove(preChar);


        return meaning;
    }
}
