package com.cevier.leetcode.SumOfTwoNumbers;

import java.util.PriorityQueue;

public class FindKthLargest2 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < k; i++)
                pq.add(nums[i]);
            for (int i = k; i < nums.length; i++)
                if(!pq.isEmpty() && nums[i] > pq.peek()){
                    pq.remove();
                    pq.add(nums[i]);
                }
            return pq.peek();
        }
    }
}
