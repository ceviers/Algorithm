package com.cevier.leetcode;

import java.util.BitSet;

/**
 * <a href="https://leetcode.cn/problems/first-missing-positive/description/">缺失的第一个正数</a>
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int max = nums.length + 2;
        boolean[] bitSet = new boolean[max];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] >= max) {
                max--;
            } else {
                bitSet[nums[i]] = true;;
            }
        }
        for (int i = 1; i < max; i++) {
            if (!bitSet[i]) {
                return i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        bitSet.set(Integer.MAX_VALUE);
        System.out.println(bitSet);
    }

}
