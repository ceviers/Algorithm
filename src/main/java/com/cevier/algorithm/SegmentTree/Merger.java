package com.cevier.algorithm.SegmentTree;

public interface Merger <E> {
    E merge(E item1, E item2);
}
