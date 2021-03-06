package com.cevier.algorithm.UnionFind;

public interface UF {
    int getSize();
    boolean isConnected(int p, int q);
    void union(int p, int q);
}
