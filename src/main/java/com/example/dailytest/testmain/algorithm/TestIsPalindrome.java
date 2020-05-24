package com.example.dailytest.testmain.algorithm;

public class TestIsPalindrome {
    public static boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;
        int l = 0, r = s.length() - 1;
        while (l < r) {
// 从头和尾开始向中间遍历
            if (!Character.isLetterOrDigit(s.charAt(l))) {// 字符不是字⺟和数字的情况
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {// 字符不是字⺟和数字的情况
                r--;
            } else {
// 判断⼆者是否相等
                if (Character.toLowerCase(s.charAt(l)) !=
                        Character.toLowerCase(s.charAt(r)))
                    return false;
                l++;
                r--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String string = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(string));
    }
}
