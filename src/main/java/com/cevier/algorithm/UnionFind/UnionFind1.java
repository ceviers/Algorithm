package com.cevier.algorithm.UnionFind;

public class UnionFind1 implements  UF{
    private int[] id;

    public UnionFind1(int size){
        for (int i = 0; i < size; i++)
            id[i] = i;
    }

    @Override
    public int getSize() {
        return id.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p), qId = find(q);
        if(pId == qId)
            return;
        for (int i = 0; i < id.length; i++)
            if(id[i] == pId)
                id[i] = qId;
    }

    private int find(int index){
        return id[index];
    }
}
