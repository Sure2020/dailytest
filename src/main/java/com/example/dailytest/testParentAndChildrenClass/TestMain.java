package com.example.dailytest.testParentAndChildrenClass;

public class TestMain {
    public static void main(String[] args) {
        TestChildren testChildren = new TestChildren("Jobs");
        testChildren.callMe();

        /*
        java 调用子类构造函数时，如果子类没有通过super调用父类构造方法，则会默认调用父类无参构造方法
        但如果父类中有声明有参数的构造方法，则默认的无参构造方法会失效，这种情况下需要在父类中手动声明无参构造函数
         */
    }
}
