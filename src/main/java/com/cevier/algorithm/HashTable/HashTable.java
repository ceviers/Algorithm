package com.cevier.algorithm.HashTable;

import java.util.TreeMap;

public class HashTable <K, V>{

    private static  final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int[] capacities = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469, 12582917, 25165843,
            50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

    private int capacityIndex = 0;
    private TreeMap<K, V>[] hashTable;
    private int size;
    private int M;

    public HashTable(){
        this.M = capacities[capacityIndex];
        size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < hashTable.length; i++)
            hashTable[i] = new TreeMap<>();
    }

    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize(){
        return size;
    }

    public void add(K key, V value){
        TreeMap<K, V> map = hashTable[hash(key)];
        if(map.containsKey(key)){
            map.put(key, value);
        }else{
            map.put(key, value);
            size++;
            if(size >= M * upperTol)
                resize(capacities[++capacityIndex < capacities.length ? capacityIndex : capacities.length - 1]);
        }
    }

    private void resize(int newM){
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newHashTable.length; i++)
            newHashTable[i] = new TreeMap<>();

        int oldM = M;
        M = newM;

        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashTable[i];
            for(K key: map.keySet())
                newHashTable[hash(key)].put(key, map.get(key));
        }

        hashTable = newHashTable;
    }

    public V remove(K key){
        TreeMap<K, V> map = hashTable[hash(key)];
        V r = null;
        if(map.containsKey(key)) {
            r = map.remove(key);
            size--;
            if(size <= M * lowerTol && size > capacities[0])
                resize(capacities[--capacityIndex >= 0 ? capacityIndex : 0]);
        }
        return r;
    }

    public void set(K key, V value){
        TreeMap<K, V> map = hashTable[hash(key)];
        if(!map.containsKey(key))
            throw new IllegalArgumentException("key " + key + " doesn't exist");
        map.put(key, value);
    }

    public boolean contains(K key){
        return hashTable[hash(key)].containsKey(key);
    }

    public V get(K key){
        return hashTable[hash(key)].get(key);
    }
}