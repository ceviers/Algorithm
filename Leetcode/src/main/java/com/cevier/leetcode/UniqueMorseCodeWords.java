package com.cevier.leetcode;

import java.util.HashSet;
import java.util.Set;

//804. 唯一摩尔斯密码词
//https://leetcode-cn.com/problems/unique-morse-code-words/
public class UniqueMorseCodeWords {
    class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            String codes[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
            Set<String> set = new HashSet();
            for (String word : words) {
                String code = "";
                for (int i = 0; i < word.length(); i++)
                    code += codes[(int)word.charAt(i) - 97];
                set.add(code);
            }
            return set.size();
        }
    }
}
