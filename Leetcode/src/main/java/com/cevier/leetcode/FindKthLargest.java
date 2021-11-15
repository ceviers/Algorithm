package com.cevier.leetcode;

import java.util.Random;

public class FindKthLargest {
    class Solution {
        public int findKthLargest(int[] arr, int k) {
            findPosition(arr, 0, arr.length - 1, k, new Random());
            return arr[k-1];
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
                if(arr[p] > arr[l])
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
}
