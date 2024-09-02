package com.cevier.leetcode;

/**
 * 寻找两个正序数组的中位数
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/description/
 */
public class MedianOfTwoSortedArrays {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            if (nums1.length == 0) {
                if (nums2.length % 2 == 0) {
                    return 0.5 * nums2[nums2.length / 2] + 0.5 * nums2[nums2.length / 2 - 1];
                } else {
                    return nums2[nums2.length / 2];
                }
            }
            if (nums2.length == 0) {
                if (nums1.length % 2 == 0) {
                    return 0.5 * nums1[nums1.length / 2] + 0.5 * nums1[nums1.length / 2 - 1];
                } else {
                    return nums1[nums1.length / 2];
                }
            }

            int i1 = 0;
            int i2 = 0;
            boolean f1 = false;
            boolean f2 = false;
            int val = Integer.MIN_VALUE;
            int preVal = 0;
            int l = nums1.length + nums2.length;
            for (int j = 0; j < l / 2 + 1; j++) {
                if (nums1[i1] < nums2[i2]) {
                    if (i1 == nums1.length - 1 && f1) {
                        preVal = val;
                        val = nums2[i2];
                        i2 = Math.min(i2 + 1, nums2.length - 1);
                        continue;
                    } else if (i1 == nums1.length - 1) {
                        f1 = true;
                    }
                    preVal = val;
                    val = nums1[i1];
                    i1 = Math.min(i1 + 1, nums1.length - 1);
                } else {
                    if (i2 == nums2.length - 1 && f2) {
                        preVal = val;
                        val = nums1[i1];
                        i1 = Math.min(i1 + 1, nums1.length - 1);
                        continue;
                    } else if (i2 == nums2.length - 1) {
                        f2 = true;
                    }
                    preVal = val;
                    val = nums2[i2];
                    i2 = Math.min(i2 + 1, nums2.length - 1);
                }
            }
            if (l % 2 == 0) {
                return 0.5 * preVal + 0.5 * val;
            } else {
                return val;
            }
        }
    }
}
