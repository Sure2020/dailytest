package com.example.dailytest.testmain;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestLambda {
    final  static String salutation = "Hello!";

    public static void main(String[] args) {

        List<Todo> list = new ArrayList<>();
        list.add(new Todo(1,1,"hh","ss",LocalDateTime.now()));
        list.add(new Todo(2,2,"hh","ss",LocalDateTime.now()));
        list.add(new Todo(3,3,"hh","ss",LocalDateTime.now()));

        List<TodoDto> todoDtos = new ArrayList<>();
        todoDtos = list.stream().map(
                todo ->new TodoDto(todo.getUserId(),todo.getTitle(),todo.getContent())
        ).collect(Collectors.toList());
        //  或者
        todoDtos = list.stream().map(
                todo->{
                    TodoDto to = new TodoDto();
                    BeanUtils.copyProperties(todo,to);
                    return to;
                }
        ).collect(Collectors.toList());

        list.stream().forEach(item-> System.out.println(item));
        todoDtos.stream().forEach(m-> System.out.println(m));

        System.out.println("end");

        //##############################   精简JSONObjectlist
        JSONObject obj1 = new JSONObject();
        obj1.put("id", "a");
        obj1.put("name", "a");
        JSONObject obj2 = new JSONObject();
        obj2.put("id", "b");
        obj2.put("name", "b");

        List<JSONObject> sourceList = new ArrayList<>();
        sourceList.add(obj1);
        sourceList.add(obj2);
        sourceList.stream().forEach(obj -> System.out.println(obj));

        List<Object> targetList = new ArrayList<>();
        //targetList =  sourceList.stream().map(objItem -> new JSONObject().put("id", objItem.getString("id"))).collect(Collectors.toList());
        targetList =  sourceList.stream().map(sourceObj -> {
            JSONObject targetObj = new JSONObject();
            targetObj.put("id", sourceObj.getString("id"));
            return targetObj;
        }).collect(Collectors.toList());
        targetList.stream().forEach(obj -> System.out.println(JSONObject.toJSON(obj)));
    }


    public static class TodoDto {
        private int userId;
        private String title;
        private String content;

        @Override
        public String toString() {
            return "TodoDto{" +
                    "userId=" + userId +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }

        public TodoDto() {
        }

        public TodoDto(int userId, String title, String content) {
            this.userId = userId;
            this.title = title;
            this.content = content;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public static class Todo {
        private int id;
        private int userId;
        private String title;
        private String content;
        private LocalDateTime createTime;

        @Override
        public String toString() {
            return "Todo{" +
                    "id=" + id +
                    ", userId=" + userId +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    ", createTime=" + createTime +
                    '}';
        }

        public Todo() {
        }

        public Todo(int id, int userId, String title, String content, LocalDateTime createTime) {
            this.id = id;
            this.userId = userId;
            this.title = title;
            this.content = content;
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public LocalDateTime getCreateTime() {
            return createTime;
        }

        public void setCreateTime(LocalDateTime createTime) {
            this.createTime = createTime;
        }
    }

    public static void main_backup(String args[]){
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

        // ############################ 创建多线程的传统风格和Lambda风格对比
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println('a');
            }
        };
        Runnable runnable1 = () -> {
            System.out.println('b');
        };
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(runnable1);
            thread.start();
        }
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
