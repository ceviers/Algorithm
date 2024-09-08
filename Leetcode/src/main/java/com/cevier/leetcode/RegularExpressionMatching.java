package com.cevier.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        // 用正则解题
//        return java.util.regex.Pattern.compile(p).matcher(s).matches();

        // 错误答案
        return isMatch(s, this.parse(p));
    }

    public boolean isMatch(String s, List<String> patterns) {
        if (s.isEmpty() || patterns.isEmpty()) {
            return s.isEmpty() == patterns.isEmpty();
        }

        String pattern = patterns.get(0);
        int idx = 0;
        if (pattern.length() == 2 && pattern.charAt(1) == '*') {
            if (pattern.charAt(0) == '.') {
                idx = pattern.length();
            } else {
                while (idx < s.length() && s.charAt(idx) == pattern.charAt(0)) {
                    idx++;
                }
            }
        } else if (pattern.contains("*")) {
            // abcdabd
            // .*d.*abd
            String[] split = pattern.split("\\*");
            if (s.equals(split[1])) {
                idx = s.length();
            } else {
                if (split[1].equals(".")) {
                    if (s.length() == 1) {
                        return true;
                    }
                    if (s.charAt(0) == pattern.charAt(0)) {
                        while (idx < s.length() && s.charAt(idx) == pattern.charAt(0)) {
                            idx++;
                        }
                        idx++;
                    } else {
                        idx = 1;
                    }
                } else {
                    if (!s.contains(split[1])) {
                        return false;
                    }
                    String[] split1 = s.split(split[1]);
                    if (s.contains(split[1] + split[1])) {
                        int i = s.indexOf(split[1], s.indexOf(split[1]) + 1);
                        split1 = new String[2];
                        split1[0] = s.substring(0, i + 1);
                        split1[1] = s.substring(i + 1);
                    }

                    ArrayList<String> objects = new ArrayList<>(1);
                    objects.add(split[0] + "*");
                    if (isMatch(split1[0], objects)) {
                        idx = split1[0].length() + split[1].length();
                    } else {
                        return false;
                    }
                }
            }
        } else if (pattern.equals(".")) {
            idx = 1;
        } else {
            if (s.startsWith(pattern)) {
                idx = pattern.length();
            } else {
                return false;
            }
        }
        // a* .* .*c a*c a .

        return isMatch(s.substring(idx), patterns.subList(1, patterns.size()));
    }

    public List<String> parse(String p) {
        List<String> r = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                sb.append(p.charAt(i));
                r.add(sb.toString());
                sb = new StringBuilder();
            } else if (p.charAt(i) == '.') {
                if (sb.length() > 0) {
                    r.add(sb.toString());
                }
                sb = new StringBuilder().append(p.charAt(i));
            } else {
                if (sb.length() == 1 && sb.charAt(0) == '.') {
                    r.add(sb.toString());
                    sb = new StringBuilder();
                }
                if (i + 1 < p.length() && p.charAt(i + 1) == '*') {
                    if (sb.length() > 0) {
                        r.add(sb.toString());
                        sb = new StringBuilder();
                    }
                }
                sb.append(p.charAt(i));
            }

        }
        if (sb.length() > 0) {
            r.add(sb.toString());
        }

//        return r;

        List<String> a = new ArrayList<>(r.size());
        int idx = -1;
        for (int i = 1; i < r.size(); i++) {
            if (r.get(i - 1).charAt(r.get(i - 1).length() - 1) == '*' && r.get(i).charAt(r.get(i).length() - 1) != '*') {
                a.add(r.get(i - 1) + r.get(i));
                idx = i;
                i++;
            } else {
                idx = i - 1;
                a.add(r.get(i - 1));
            }
        }
        if (idx + 1 != r.size()) {
            a.add(r.get(r.size() - 1));
        }

        List<String> b = new ArrayList<>(a.size());
        idx = -1;
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i - 1).contains("*") && a.get(i).equals(".")) {
                b.add(a.get(i - 1) + a.get(i));
                idx = i;
                i++;
            } else {
                idx = i - 1;
                b.add(a.get(i - 1));
            }
        }
        if (idx + 1 != a.size()) {
            b.add(a.get(a.size() - 1));
        }

        return b;
    }

    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching().parse("a*b*c"));
        System.out.println(new RegularExpressionMatching().parse("abc"));
        System.out.println(new RegularExpressionMatching().parse(".*abc"));
        System.out.println(new RegularExpressionMatching().parse("abc."));
        System.out.println(new RegularExpressionMatching().parse("abc.*"));
        System.out.println(new RegularExpressionMatching().parse("abc*"));
        System.out.println(new RegularExpressionMatching().parse("abc*a"));
        System.out.println(new RegularExpressionMatching().parse("abc*c"));
        System.out.println(new RegularExpressionMatching().parse("abc*c."));
        System.out.println(new RegularExpressionMatching().parse("abc*c*b*a*"));
        System.out.println(new RegularExpressionMatching().parse("a.a"));


        System.out.println(new RegularExpressionMatching().isMatch("aaa", "ab*ac*a"));
        System.out.println(new RegularExpressionMatching().isMatch("aaa", "a*a"));
        System.out.println(new RegularExpressionMatching().isMatch("aaa", "a.a"));
        System.out.println(new RegularExpressionMatching().isMatch("aa", "a*"));
        System.out.println(!new RegularExpressionMatching().isMatch("aa", "a"));
        System.out.println(new RegularExpressionMatching().isMatch("aa", ".*"));
        System.out.println(!new RegularExpressionMatching().isMatch("aa", "."));
        System.out.println(new RegularExpressionMatching().isMatch("aabc", "a*b*c"));
        System.out.println(new RegularExpressionMatching().isMatch("aab", "c*a*b"));
        System.out.println(!new RegularExpressionMatching().isMatch("mississippi", "mis*is*p*."));
        System.out.println(new RegularExpressionMatching().isMatch("ppi", "p*."));
        System.out.println(new RegularExpressionMatching().isMatch("mississippi", "mis*is*ip*."));

    }
}
