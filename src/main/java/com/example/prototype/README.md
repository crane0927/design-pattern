# 原型模式（Prototype Pattern）—— 浅拷贝与深拷贝示例

原型模式通过“复制已有对象”来创建新对象，避免重复初始化带来的成本。本目录用 `Diploma`/`Student` 演示浅拷贝，用 `Diploma2`/`Student2` 演示深拷贝，并补充了不可变类型字段的示例。

---

## 1. 核心思想

- 用原型实例复制出新对象
- 通过 `clone()` 完成对象复制
- 适合创建成本高、初始化复杂、需要大量相似对象的场景

---

## 2. 代码结构（对应本目录实现）

- `Diploma` / `Student`：浅拷贝示例（引用字段共享）
- `Diploma2` / `Student2`：深拷贝示例（引用字段复制）
- `PrototypeDemo`：运行入口，分别演示浅拷贝与深拷贝

---

## 3. 浅拷贝示例（Diploma + Student）

`Diploma` 实现 `Cloneable`，直接调用 `super.clone()`：

```java
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
```

浅拷贝效果：对象本身是新对象，但引用字段仍指向同一个 `Student`；`String` 等不可变类型共享引用是安全的。

---

## 4. 深拷贝示例（Diploma2 + Student2）

`Diploma2` 在克隆时对引用对象再调用 `clone()`：

```java
public class Diploma2 implements Cloneable {

    private Student2 student;

    public void setStudent(Student2 student) {
        this.student = student;
    }

    public Student2 getStudent() {
        return student;
    }

    @Override
    public Diploma2 clone() {
        try {
            System.out.println("通过 clone 方法复制原型");
            Diploma2 cloned = (Diploma2) super.clone();
            if (this.getStudent() != null) {
                cloned.setStudent(this.getStudent().clone());
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
```

`Student2` 也需要实现 `Cloneable`：

```java
public class Student2 implements Cloneable {

    private String name;
    private int age;

    @Override
    public Student2 clone() {
        try {
            return (Student2) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
```

深拷贝效果：对象及其引用字段都会被复制，互不影响。

---

## 5. 运行示例（PrototypeDemo）

```java
public class PrototypeDemo {

    public static void main(String[] args) {
        shallowClone();
        System.out.println("========");
        deepClone();
    }

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
        System.out.println(cloned2.getStudent() == original.getStudent()); // true
        System.out.println(original.getType()); // String 共享引用安全
        System.out.println(cloned2.getType());
    }

    public static void deepClone() {
        Diploma2 original = new Diploma2();
        Diploma2 cloned = original.clone();
        System.out.println(cloned == original); // false

        Student2 student = new Student2();
        student.setName("John");
        student.setAge(20);

        original.setStudent(student);

        Diploma2 cloned2 = original.clone();
        System.out.println(cloned2.getStudent() == original.getStudent()); // false
    }
}
```

---

## 6. 使用要点

- 实现 `Cloneable` 并重写 `clone`
- 引用字段决定是否需要深拷贝
- 深拷贝时，被引用对象也要支持 `clone`
- 不可变类型字段可共享引用

---

## 7. 不可变类型说明

不可变类型指对象创建后状态不可再改变，所有“修改”都会产生新对象，因此多实例共享同一引用是安全的。

常见不可变类型：

- `String`
- 数值包装类：`Integer`、`Long`、`Short`、`Byte`、`Character`、`Boolean`、`Float`、`Double`
- `BigInteger`、`BigDecimal`
- `LocalDate`、`LocalTime`、`LocalDateTime`、`Instant` 等 `java.time` 类型
