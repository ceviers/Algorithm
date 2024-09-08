package com.cevier.leetcode;

/**
 * 正则表达式匹配
 * <a href="https://leetcode.cn/problems/regular-expression-matching/solutions/">正则表达式匹配</a>
 */
public class RegularExpressionMatching2 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    if (isMatch(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else {
                    if (isMatch(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public boolean isMatch(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j -1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching2().isMatch("aaa", "a*a"));
        System.out.println(new RegularExpressionMatching2().isMatch("aaa", "ab*ac*a"));
        System.out.println(new RegularExpressionMatching2().isMatch("aaa", "a*a"));
        System.out.println(new RegularExpressionMatching2().isMatch("aaa", "a.a"));
        System.out.println(new RegularExpressionMatching2().isMatch("aa", "a*"));
        System.out.println(!new RegularExpressionMatching2().isMatch("aa", "a"));
        System.out.println(new RegularExpressionMatching2().isMatch("aa", ".*"));
        System.out.println(!new RegularExpressionMatching2().isMatch("aa", "."));
        System.out.println(new RegularExpressionMatching2().isMatch("aabc", "a*b*c"));
        System.out.println(new RegularExpressionMatching2().isMatch("aab", "c*a*b"));
        System.out.println(!new RegularExpressionMatching2().isMatch("mississippi", "mis*is*p*."));
        System.out.println(new RegularExpressionMatching2().isMatch("ppi", "p*."));
        System.out.println(new RegularExpressionMatching2().isMatch("mississippi", "mis*is*ip*."));

    }
}
