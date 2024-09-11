package com.cevier.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/substring-with-concatenation-of-all-words/description/">串联所有单词的子串</a>
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int l = words.length;
        int n = words[0].length();

        List<Integer> r = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i + l * n > s.length()) {
                break;
            }

            Map<String, Integer> f = new HashMap<>(l);
            for (String word : words) {
                f.put(word, f.getOrDefault(word, 0) - 1);
            }
            for (int j = 0; j < l; j++) {
                String seg = s.substring(i + j * n, i + (j + 1) * n);
                f.put(seg, f.getOrDefault(seg, 0) + 1);
                if (f.get(seg) == 0) {
                    f.remove(seg);
                }
            }
            for (int j = i; j <= s.length() - l * n; j += n) {
                if (i != j) {
                    String seg = s.substring(j + l * n - n, j + l * n);
                    f.put(seg, f.getOrDefault(seg, 0) + 1);
                    if (f.get(seg) == 0) {
                        f.remove(seg);
                    }
                    seg = s.substring(j - n, j);
                    f.put(seg, f.getOrDefault(seg, 0) - 1);
                    if (f.get(seg) == 0) {
                        f.remove(seg);
                    }
                }
                if (f.isEmpty()) {
                    r.add(j);
                }
            }

        }

        return r;
    }

    public static void main(String[] args) {
        new SubstringWithConcatenationOfAllWords().findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"});
    }
}
