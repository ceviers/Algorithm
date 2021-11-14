package com.cevier.leetcode;

import java.util.Arrays;

//剑指 Offer 51. 数组中的逆序对
//https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
public class ReversePairs {
    class Solution {
        int count = 0;

        public int reversePairs(int[] nums) {
            count = 0;
            int[] temp = Arrays.copyOf(nums, nums.length);
            mergeSort(nums, 0, nums.length - 1, temp);
            return count;
        }

        private void mergeSort(int[]arr, int l, int r, int[] temp){
            if(l >= r)
                return;
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m, temp);
            mergeSort(arr, m + 1, r, temp);

            if(arr[m] > arr[m + 1])
                merge(arr, l, m, r, temp);
        }

        private void merge(int[] arr, int l, int m, int r, int[] temp){
            System.arraycopy(arr, l, temp, l, r - l + 1);
            for(int k = l, i = l, j = m + 1; k <= r; k++){
                if(i > m){
                    arr[k] = temp[j++];
                }else if(j > r){
                    arr[k] = temp[i++];
                }else{
                    if(temp[i] <= temp[j]) {
                        arr[k] = temp[i++];
                    }else {
                        count += m - i + 1;
                        arr[k] = temp[j++];
                    }
                }
            }
        }
    }
}
