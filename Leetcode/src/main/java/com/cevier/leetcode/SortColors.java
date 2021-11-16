package com.cevier.leetcode;

public class SortColors {
    class Solution {
        public void sortColors(int[] nums) {
            if(nums.length < 1)
                return;

            int lr = -1, rl = nums.length, p = 0;
            while(p < rl)
                if(nums[p] < 1)
                    swap(nums, ++lr, p++);
                else if(nums[p] == 1)
                    p++;
                else
                    swap(nums, --rl, p);
        }
        private void swap(int[] arr, int i, int j){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }
}
