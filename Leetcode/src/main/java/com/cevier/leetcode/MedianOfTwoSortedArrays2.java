package com.cevier.leetcode;

/**
 * 寻找两个正序数组的中位数
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/description/
 */
public class MedianOfTwoSortedArrays2 {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int l = nums1.length + nums2.length;
            if (l % 2 == 0) {
                return 0.5 * getNMinNumber(nums1, nums2, 0, 0, l / 2 + 1) + 0.5 * getNMinNumber(nums1, nums2, 0, 0, l / 2);
            } else {
                return getNMinNumber(nums1, nums2, 0, 0, l / 2 + 1);
            }
        }

        public int getNMinNumber(int[] a1, int[] a2, int is1, int is2, int n) {
            if (is1 == a1.length) {
                return a2[is2 + n - 1];
            }
            if (is2 == a2.length) {
                return a1[is1 + n - 1];
            }
            if (n == 1) {
                return Math.min(a1[is1], a2[is2]);
            }

            int m1 = Math.min(a1.length, is1 + n / 2) - 1;
            int m2 = Math.min(a2.length, is2 + n / 2) - 1;
            if (a1[m1] > a2[m2]) {
                return getNMinNumber(a1, a2, is1, m2 + 1, n + is2 - m2 - 1);
            } else {
                return getNMinNumber(a1, a2, m1 + 1, is2, n + is1 - m1 - 1);
            }
        }

    }

}
