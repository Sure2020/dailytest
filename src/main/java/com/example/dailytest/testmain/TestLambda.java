package com.example.dailytest.testmain;

public class TestLambda {
    final  static String salutation = "Hello!";
    public static void main(String args[]){
        TestLambda tester = new TestLambda();
        final String salutation2 = "world!";

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;
        // 相当于
        MathOperation addition2 = new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return a + b;
            }
        };

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 + 5 = " + tester.operate(10, 5, addition2));

        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        // 相当于
        GreetingService greetService3 = new GreetingService() {
            @Override
            public void sayMessage(String message) {
                System.out.println("Hello " + message);
            }
        };

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");


        //lambda 表达式只能引用标记了 final 的外层局部变量
        GreetingService greetingService3 = message ->
                System.out.println(salutation + salutation2 + message);

        greetingService3.sayMessage("Sure");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
