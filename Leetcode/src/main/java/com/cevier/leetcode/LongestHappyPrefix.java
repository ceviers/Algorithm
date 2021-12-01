package com.cevier.leetcode;

// 1392. 最长快乐前缀
// https://leetcode-cn.com/problems/longest-happy-prefix/
public class LongestHappyPrefix {

    class Solution {
        public String longestPrefix(String s) {
            long M = (long)(1E9 + 7);
            long[] preHash = new long[s.length()];
            long[] postHash = new long[s.length()];
            preHash[0] = s.charAt(0) - 'a';
            postHash[postHash.length - 1] = s.charAt(s.length() - 1) - 'a';
            for (int i = 1; i < preHash.length; i++) {
                preHash[i] = (preHash[i - 1] * 26  + (s.charAt(i) - 'a')) % M;
            }
            long[] pow26 = new long[s.length()];
            pow26[0] = 1;
            for (int i = 1; i < pow26.length; i++) {
                pow26[i] = (pow26[i - 1] * 26) % M;
            }
            for (int i = postHash.length - 2; i >= 0; i--) {
                postHash[i] = (postHash[i + 1] + (s.charAt(i) - 'a')* pow26[postHash.length - i - 1]) % M;
            }

            for (int i = s.length() - 1; i > 0; i--) {
                if(preHash[i - 1] == postHash[s.length() - i])
                    return s.substring(0, i);
            }
            return "";
        }
    }
}
