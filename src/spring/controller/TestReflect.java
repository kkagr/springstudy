package spring.controller;
import java.lang.reflect.Method;

public class TestReflect {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("spring.controller.TestReflect");
        // ����TestReflect���е�reflect1����
       Method method = clazz.getMethod("reflect1");
        method.invoke(clazz.newInstance());
        // Java ������� - ����ĳ����ķ���1.
        // ����TestReflect��reflect2����
        method = clazz.getMethod("reflect2", int.class, String.class);
        method.invoke(clazz.newInstance(), 20, "����");
        // Java ������� - ����ĳ����ķ���2.
        // age -> 20. name -> ����
    }
    public void reflect1() {
        System.out.println("Java ������� - ����ĳ����ķ���1.");
    }
    public void reflect2(int age, String name) {
        System.out.println("Java ������� - ����ĳ����ķ���2.");
        System.out.println("age -> " + age + ". name -> " + name);
    }
}