package com.example.prototype;

public class Diploma implements Cloneable {

    private Student student;

    private String type;

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Diploma() {
        System.out.println("通过 new 方法创建对象");
    }

    /**
     * 实现的是 Object 中的 clone() 方法
     */
    @Override
    public Diploma clone() {
        try {
            System.out.println("通过 clone 方法复制原型");
            return (Diploma) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
