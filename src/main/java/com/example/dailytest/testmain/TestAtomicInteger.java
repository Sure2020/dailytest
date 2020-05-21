package com.example.dailytest.testmain;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInteger {
    public static void main(String[] args) {
        //AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
        System.out.println(AtomicIntegerTest.getCount());
        AtomicIntegerTest.increment();
        System.out.println(AtomicIntegerTest.getCount());

    }
    static class  AtomicIntegerTest {
        private static AtomicInteger count = new AtomicInteger(1);
        //使⽤AtomicInteger之后，不需要对该⽅法加锁，也可以实现线程安全。
        public static void increment() {
            count.incrementAndGet();
        }
        public static int getCount() {
            return count.get();
        }
    }
}
