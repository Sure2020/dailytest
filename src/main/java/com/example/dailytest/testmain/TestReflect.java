package com.example.dailytest.testmain;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*public class TestReflect {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> c = methodClass.class;
        Object object = c.newInstance();
        Method[] methods = c.getMethods();
        Method[] declaredMethods = c.getDeclaredMethods();
        //获取methodClass类的add方法
        Method method = c.getMethod("add", int.class, int.class);
        //getMethods()方法获取的所有方法
        System.out.println("getMethods获取的方法：");
        for(Method m:methods)
            System.out.println(m);
        //getDeclaredMethods()方法获取的所有方法
        System.out.println("getDeclaredMethods获取的方法：");
        for(Method m:declaredMethods)
            System.out.println(m);

        //methodClass methodClass = c.newInstance();

        System.out.println("###############");
        Class<?> klass = methodClass.class;
        //创建methodClass的实例
        Object obj = klass.newInstance();
        //获取methodClass类的add方法
        Method method2 = klass.getMethod("add",int.class,int.class);
        //调用method对应的方法 => add(1,4)
        Object result = method2.invoke(obj,1,4);
        System.out.println(result);


        System.out.println("#######");
        methodClass methodClass = new methodClass();
        Class s = methodClass.getClass();
    }
}
class methodClass {
    public final int fuck = 3;
    public int add(int a,int b) {
        return a+b;
    }
    public int sub(int a,int b) {
        return a+b;
    }
}*/

public class TestReflect {
    public static void main(String[] args) {
        try {

            Class c = Class.forName("com.example.dailytest.testmain.Sub");
            Base b = (Base) c.newInstance();
            b.f();

            /*Base base = new Base();
            base.f();*/

            Class base2 = Class.forName("com.example.dailytest.testmain.Base");
            System.out.println(base2.getSimpleName());
            Base b2 = (Base) base2.newInstance();
            b2.f();

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class Base {
    public void f() {
        System.out.println("Base");
    }
}

class Sub extends Base {
    public void f() {
        System.out.println("Sub");
    }
}