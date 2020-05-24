package com.example.dailytest.testmain.algorithm;

public class TestReplaceSpace {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("How are you");
        System.out.println(replaceSpace(stringBuffer));
        System.out.println(replaceSpace2(stringBuffer));
    }
    //https://www.weiweiblog.cn/replacespace/
        /**
         * 第⼀种⽅法：常规⽅法。利⽤String.charAt(i)以及
         String.valueOf(char).equals(" "
         * )遍历字符串并判断元素是否为空格。是则替换为"%20",否则不替换
         */
        public static String replaceSpace(StringBuffer str) {
            int length = str.length();
// System.out.println("length=" + length);
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < length; i++) {
                char b = str.charAt(i);
                if (String.valueOf(b).equals(" ")) {
                    result.append("%20");
                } else {
                    result.append(b);
                }
            }
            return result.toString();
        }
        /**
         * 第⼆种⽅法：利⽤API替换掉所⽤空格，⼀⾏代码解决问题
         */
        public static String replaceSpace2(StringBuffer str) {
            return str.toString().replaceAll("\\s", "%20");
        }

}
