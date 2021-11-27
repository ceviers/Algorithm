package com.cevier.algorithm.UnionFind;

import java.util.Random;

public class UnionFind3 implements UF{
    private int[] parent;
    private int[] rank;

    public UnionFind3(int size){
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize(){
        return parent.length;
    }

    private int find(int id){
        if(id == parent[id])
            return parent[id];
        else
            parent[id] = find(parent[id]);
        return parent[id];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p), qRoot = find(q);
        if(pRoot == qRoot)
            return;
        if(rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = parent[pRoot];
        }else if(rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = parent[qRoot];
        }else{
            parent[pRoot] = parent[qRoot];
            rank[qRoot]++;
        }
    }
}
