package com.cevier.leetcode;

//307. 区域和检索 - 数组可修改
//https://leetcode-cn.com/problems/range-sum-query-mutable/
public class RangeSumQueryMutable {
    class NumArray {

        private SegmentTree segTree;

        public NumArray(int[] nums) {
            segTree = new SegmentTree(nums);
        }

        public void update(int index, int val) {
            segTree.update(index, val);
        }

        public int sumRange(int left, int right) {
            return segTree.query(left, right);
        }

        private class SegmentTree {
            private int[] data;
            private int[] tree;

            public SegmentTree(int[] arr){
                data = new int[arr.length];
                for (int i = 0; i < arr.length; i++)
                    data[i] = arr[i];
                tree = new int[4 * arr.length];
                generateTree(0, 0, data.length - 1);
            }

            private int leftChild(int rootIndex){
                return 2 * rootIndex + 1;
            }

            private int rightChild(int rootIndex){
                return 2 * rootIndex + 2;
            }

            private int generateTree(int rootIndex, int l, int r){
                if(l == r) {
                    tree[rootIndex] = data[l];
                    return tree[rootIndex];
                }
                int mid = l + (r - l) / 2;
                int leftChildIndex = leftChild(rootIndex);
                int rightChildIndex = rightChild(rootIndex);
                int left = generateTree(leftChildIndex, l, mid);
                int right = generateTree(rightChildIndex, mid + 1, r);
                tree[rootIndex] = left + right;
                return tree[rootIndex];
            }

            public int query(int LBound, int RBound){
                return query(0, 0, data.length - 1, LBound, RBound);
            }

            private int query(int rootIndex, int l, int r, int LBound, int RBound){
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
                    int left = query(leftChildIndex, l, mid, LBound, mid);
                    int right = query(rightChildIndex, mid + 1, r, mid + 1, RBound);
                    return left + right;
                }
            }

            public void update(int index, int e){
                data[index] = e;
                update(0, 0, data.length - 1, index, e);
            }

            private void update(int rootIndex, int l, int r, int index, int e){
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

                tree[rootIndex] = tree[leftChildIndex] + tree[rightChildIndex];
            }

        }
    }


}
