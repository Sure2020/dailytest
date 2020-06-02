package com.example.dailytest.testmain;

public class TestEquel {
    public static void main(String[] args) {
        String a = new String("ab"); // a 为⼀个引⽤
        String b = new String("ab"); // b为另⼀个引⽤,对象的内容⼀样
        String aa = "ab"; // 放在常量池中
        String bb = "ab"; // 从常量池中查找
        if (aa == bb) // true
            System.out.println("aa==bb");
        if (a == b) // false，⾮同⼀对象
            System.out.println("a==b");
        if (a.equals(b)) // true  (String 的euqel是被重写过的，是比较对象的内容)
            System.out.println("aEQb");
        if (42 == 42.0) { // true
            System.out.println("true");
        }

        b = a;
        if (a == b) // true
            System.out.println("a==b");
        if (a.equals(b)) // true  (String 的euqel是被重写过的，是比较对象的内容)
            System.out.println("aEQb");

        //test hashCode
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(aa.hashCode());
        System.out.println(bb.hashCode());
        System.out.println("test".hashCode());
    }
}
