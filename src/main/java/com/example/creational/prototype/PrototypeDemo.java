package com.example.creational.prototype;

public class PrototypeDemo {

    public static void main(String[] args) {

        shallowClone();
        System.out.println("========");
        deepClone();
    }

    /**
     * 浅拷贝
     */
    public static void shallowClone() {
        Diploma original = new Diploma();
        Diploma cloned = original.clone();
        System.out.println(cloned == original); // false

        Student student = new Student();
        student.setName("John");
        student.setAge(20);

        original.setStudent(student);
        original.setType("本科");

        Diploma cloned2 = original.clone();
        cloned2.setType("硕士");
        System.out.println(cloned2.getStudent() == original.getStudent()); // true 浅拷贝的引用对象拷贝的是引用地址
        System.out.println(original.getType()); // 本科 对于 String 等不可变类型（共享引用安全），使用浅拷贝足够
        System.out.println(cloned2.getType()); // 硕士

    }

    /**
     * 深拷贝
     */
    public static void deepClone() {
        Diploma2 original = new Diploma2();
        Diploma2 cloned = original.clone();
        System.out.println(cloned == original); // false

        Student2 student = new Student2();
        student.setName("John");
        student.setAge(20);

        original.setStudent(student);

        Diploma2 cloned2 = original.clone();
        System.out.println(cloned2.getStudent() == original.getStudent()); // false 深拷贝的引用对象拷贝的是对象
    }
}
