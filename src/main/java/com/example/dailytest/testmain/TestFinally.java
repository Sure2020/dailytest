package com.example.dailytest.testmain;

public class TestFinally {
    public static void main(String[] args) {
        System.out.println("return result: " + testFinally());
    }

    public static String testFinally () {
        //try 和 finally 都有return，以finally的return为准
        try{
            System.out.println("try");
            return "try";
        }finally {
            System.out.println("finally");
            return "finally";
        }
    }
}
