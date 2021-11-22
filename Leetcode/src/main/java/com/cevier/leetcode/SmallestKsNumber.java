package com.cevier.leetcode;

import java.sql.Array;
import java.util.Arrays;
import java.util.Random;

//找出数组中最小的k个数
//https://leetcode-cn.com/problems/smallest-k-lcci/
public class SmallestKsNumber {
    static class Solution {
        public int[] smallestK(int[] arr, int k) {
            if(k == 0)
                return new int[0];

            findPosition(arr, 0, arr.length - 1, k, new Random());
            return Arrays.copyOfRange(arr, 0, k);
        }

        private void findPosition(int[] arr, int l, int r, int k, Random rdm){
            int[] p = partition(arr, l, r, rdm);

            if(k <= p[0] + 1){
                findPosition(arr, l, p[0], k, rdm);
            }else if(k >= p[1] + 1){
                findPosition(arr, p[1], r, k, rdm);
            }
        }

        private int[] partition(int[] arr, int l, int r, Random rdm){
            int p = l + rdm.nextInt(r - l + 1);
            swap(arr, l, p);
            int[] lr = {l,  r + 1};
            p = l + 1;
            while (p < lr[1]){
                if(arr[p] < arr[l])
                    swap(arr, ++lr[0], p++);
                else if(arr[p] == arr[l])
                    p++;
                else
                    swap(arr, --lr[1], p);
            }
            swap(arr, l, lr[0]--);
            return lr;
        }

        private void swap(int[] arr, int i, int j){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8};
        Solution s = new Solution();
        arr = s.smallestK(arr, 5);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
