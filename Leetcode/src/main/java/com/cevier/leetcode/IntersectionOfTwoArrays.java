package com.cevier.leetcode;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

//349. 两个数组的交集
//https://leetcode-cn.com/problems/intersection-of-two-arrays/submissions/
public class IntersectionOfTwoArrays {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new TreeSet();
            for (int num : nums1)
                set.add(num);
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : nums2)
                if(set.contains(num)){
                    list.add(num);
                    set.remove(num);
                }
            int[] r = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                r[i] = list.get(i);
            }
            return  r;
        }
    }
}
