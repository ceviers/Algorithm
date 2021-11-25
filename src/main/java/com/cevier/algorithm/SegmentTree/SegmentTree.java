package com.cevier.algorithm.SegmentTree;

public class SegmentTree<E> {
    private Merger merger;
    private E[] data;
    private E[] tree;

    public SegmentTree(E[] arr, Merger merger){
        this.merger = merger;
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++)
            data[i] = arr[i];
        tree = (E[])new Object[4 * arr.length];
        generateTree(0, 0, data.length - 1);
    }

    private int leftChild(int rootIndex){
        return 2 * rootIndex + 1;
    }

    private int rightChild(int rootIndex){
        return 2 * rootIndex + 2;
    }

    private E generateTree(int rootIndex, int l, int r){
        if(l == r) {
            tree[rootIndex] = data[l];
            return tree[rootIndex];
        }
        int mid = l + (r - l) / 2;
        int leftChildIndex = leftChild(rootIndex);
        int rightChildIndex = rightChild(rootIndex);
        E left = generateTree(leftChildIndex, l, mid);
        E right = generateTree(rightChildIndex, mid + 1, r);
        tree[rootIndex] = (E)merger.merge(left, right);
        return tree[rootIndex];
    }

    public E query(int LBound, int RBound){
        return query(0, 0, data.length - 1, LBound, RBound);
    }

    private E query(int rootIndex, int l, int r, int LBound, int RBound){
        if(l == LBound && r == RBound)
            return tree[rootIndex];

        int mid = l + (r - l) / 2;
        int leftChildIndex = leftChild(rootIndex);
        int rightChildIndex = rightChild(rootIndex);
        if(LBound >= mid + 1) {
            return query(rightChildIndex, mid + 1, r, LBound, RBound);
        }else if(RBound <= mid) {
            return query(leftChildIndex, l, mid, LBound, RBound);
        }else{
            E left = query(leftChildIndex, l, mid, LBound, mid);
            E right = query(rightChildIndex, mid + 1, r, mid + 1, RBound);
            return (E)merger.merge(left, right);
        }
    }

    public void update(int index, E e){
        data[index] = e;
        update(0, 0, data.length - 1, index, e);
    }

    private void update(int rootIndex, int l, int r, int index, E e){
        if(l == r) {//l == r == index}
            tree[rootIndex] = e;
            return;
        }

        int mid = l + (r - l) / 2;
        int leftChildIndex = leftChild(rootIndex);
        int rightChildIndex = rightChild(rootIndex);
        if(index <= mid)
            update(leftChildIndex, l, mid, index, e);
        else
            update(rightChildIndex, mid + 1, r, index, e);

        tree[rootIndex] = (E)merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
    }

    @Override
    public String toString(){
        String r = "[";
        for (int i = 0; i < tree.length; i++) {
            if(tree[i] != null)
                r += tree[i];
            else
                r += "null";
            if(i < tree.length - 1)
                r += ", ";
        }
        r += "]";
        return r;
    }
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7};
        SegmentTree<Integer> st = new SegmentTree<>(arr, (a, b) -> (int)a + (int)b);
        System.out.println(st);
        System.out.println(st.query(2,5));
        st.update(0,100);
        st.update(0,0);
        System.out.println(st);
    }
}
