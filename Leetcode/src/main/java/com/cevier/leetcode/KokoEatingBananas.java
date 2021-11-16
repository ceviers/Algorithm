package com.cevier.leetcode;

import java.util.Arrays;

//875. 爱吃香蕉的珂珂
//https://leetcode-cn.com/problems/koko-eating-bananas/
public class KokoEatingBananas {
    static class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int minSpeed = 1, maxSpeed = 1, speed;
            for (int pile : piles)
                if(maxSpeed < pile)
                    maxSpeed = pile;
            int totalTime;
            while (minSpeed <= maxSpeed){
                speed = minSpeed + (maxSpeed - minSpeed) / 2;
                totalTime = 0;
                for(int i = 0; i < piles.length; i++)
                    totalTime += (piles[i] + speed - 1)/ speed;
                if(totalTime == h){
                    while ((totalTime == h)){
                        speed--;
                        totalTime = 0;
                        for(int i = 0; i < piles.length; i++)
                            totalTime += (piles[i] + speed - 1)/ speed;
                    }
                    return ++speed;
                }

                if(totalTime > h)
                    minSpeed = speed + 1;
                else
                    maxSpeed = speed - 1;
            }
            return minSpeed;
        }
    }

    class Solution2 {
        public int minEatingSpeed(int[] piles, int h) {
            int minSpeed = 1, maxSpeed = 1, speed;
            for (int pile : piles)
                if(maxSpeed < pile)
                    maxSpeed = pile;
            int totalTime;
            while (minSpeed < maxSpeed){
                speed = minSpeed + (maxSpeed - minSpeed) / 2;
                totalTime = 0;
                for(int i = 0; i < piles.length; i++)
                    totalTime += (piles[i] + speed - 1)/ speed;

                if(totalTime > h)
                    minSpeed = speed + 1;
                else
                    maxSpeed = speed;
            }
            return maxSpeed;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,999};

        int h = 10;
        Solution s = new Solution();
        System.out.println(s.minEatingSpeed(arr, h));
    }
}
