package com.example.prototype;

public class Diploma2 implements Cloneable {

    private Student2 student;

    public void setStudent(Student2 student) {
        this.student = student;
    }

    public Student2 getStudent() {
        return student;
    }

    public Diploma2() {
        System.out.println("通过 new 方法创建对象");
    }

    /**
     * 实现的是 Object 中的 clone() 方法
     */
    @Override
    public Diploma2 clone() {
        try {
            System.out.println("通过 clone 方法复制原型");
            Diploma2 cloned = (Diploma2) super.clone();
            // 引用对象如果不为 null，通过 引用对象的 clone() 方法进行深拷贝
            if (this.getStudent() != null) {
                cloned.setStudent(this.getStudent().clone());
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
