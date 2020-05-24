package com.example.dailytest.testmain.algorithm;

import java.util.HashSet;

public class TestLengthOfPalindrome {

    //https://leetcode-cn.com/problems/longest-palindrome/description/
        public static int longestPalindrome(String s) {
            if (s.length() == 0)
                return 0;
// ⽤于存放字符
            HashSet<Character> hashset = new HashSet<Character>();
            char[] chars = s.toCharArray();
            int count = 0;
            for (int i = 0; i < chars.length; i++) {
                if (!hashset.contains(chars[i])) {// 如果hashset没有该字符就保存进去
                    hashset.add(chars[i]);
                } else {// 如果有,就让count++（说明找到了⼀个成对的字符），然后把该字符移除(这里很巧妙，没想到。我想到的是统计各字符出现的次数，再各除以2云云)
                    hashset.remove(chars[i]);
                    count++;
                }
            }
            return hashset.isEmpty() ? count * 2 : count * 2 + 1;
        }

    public static void main(String[] args) {
        int length = longestPalindrome("aaabbb");
        System.out.println(length);
    }
}
