package com.example.dailytest.testmain.algorithm;

public class TestLongestPalindrome {
    //https://leetcode-cn.com/problems/longest-palindromicsubstring/description/
    static class Solution {
        private int index, len;
        public String longestPalindrome(String s) {
            if (s.length() < 2)
                return s;
            for (int i = 0; i < s.length() - 1; i++) {
                /*
                思路就是以一个元素为基准，同时向左和向右遍历，判断两边所经过的元素是否都相等
                当然要分两种情况：总长度为偶数和总长度为奇数
                 */
                PalindromeHelper(s, i, i);
                PalindromeHelper(s, i, i + 1);
            }
            return s.substring(index, index + len);
        }
        public void PalindromeHelper(String s, int l, int r) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (len < r - l - 1) {
                index = l + 1;
                len = r - l - 1;
            }
        }
    }

    public static void main(String[] args) {
        String string = "cbbd";
        System.out.println(new Solution().longestPalindrome(string));
    }
}
