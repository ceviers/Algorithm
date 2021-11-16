package com.cevier.leetcode;

//1011. 在 D 天内送达包裹的能力
//https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
public class CapacityToShipPackagesWithinDDays {
    static class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int min = 1, max = 0, mid, total, pack;
            for (int weight : weights) {
                if(min < weight)
                    min = weight;
                max += weight;
            }
            while (min < max){
                mid = (max + min) / 2;
                total = 1;
                pack = 0;
                for (int weight : weights) {
                    if (pack + weight <= mid) {
                        pack += weight;
                    }else {
                        pack = weight;
                        total++;
                    }
                }

                if(total > days)
                    min = mid + 1;
                else
                    max = mid;
            }
            return min;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        int h = 5;
        Solution s = new Solution();
        System.out.println(s.shipWithinDays(arr, h));
    }
}
