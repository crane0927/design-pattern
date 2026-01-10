# 工厂模式（Factory Pattern）——Coffee 示例完整整理

本文通过 Coffee（咖啡） 示例，按“问题驱动”的方式，递进讲解以下模式：

不使用工厂 → 简单工厂 → 静态工厂 → 工厂方法 → 抽象工厂

重点回答两个问题：

1. 为什么要引入下一种模式
2. 它解决了什么问题，又引入了什么代价

---

## 1 不使用工厂：直接 new（最原始方式）

### 1.1 示例代码

```java
public interface Coffee {
    String name();
}

public class Latte implements Coffee {
    public String name() { return "Latte"; }
}

public class Americano implements Coffee {
    public String name() { return "Americano"; }
}

public class OrderService {

    public Coffee order(String type) {
        if ("latte".equalsIgnoreCase(type)) {
            return new Latte();
        } else if ("americano".equalsIgnoreCase(type)) {
            return new Americano();
        }
        throw new IllegalArgumentException("unknown coffee type");
    }
}
```

### 1.2 问题分析

- ❌ 违反开闭原则：新增一种 Coffee 必须修改业务代码
- ❌ 创建逻辑与业务逻辑耦合
- ❌ if / else 会在多个地方重复出现
- ❌ 业务代码强依赖具体实现类

👉 结论：

当对象创建逻辑开始变化时，new 就不该再散落在业务代码中。

---

## 2 简单工厂（Simple Factory / 普通工厂）

核心思想：
👉 把“对象创建”集中到一个工厂类中

---

### 2.1 示例代码

```java
public class CoffeeFactory {

    public Coffee create(String type) {
        if ("latte".equalsIgnoreCase(type)) {
            return new Latte();
        } else if ("americano".equalsIgnoreCase(type)) {
            return new Americano();
        }
        throw new IllegalArgumentException("unknown coffee type");
    }
}

public class OrderService {

    private final CoffeeFactory factory = new CoffeeFactory();

    public Coffee order(String type) {
        return factory.create(type);
    }
}
```

### 2.2 为什么要这样做

- ✅ 创建逻辑集中管理
- ✅ 业务类职责更单一
- ✅ 减少重复 new

### 2.3 仍然存在的问题

- ❌ 工厂类会越来越大
- ❌ 新增产品仍然需要修改工厂（if / else）
- ❌ 违反开闭原则（只是“集中修改”）

👉 结论：

简单工厂解决了“散乱创建”，但没有解决“变化扩展”。

---

## 3 静态工厂（Static Factory）

核心思想：
👉 如果工厂无状态，就不必实例化

---

### 3.1 示例代码

```java
public class CoffeeStaticFactory {

    private CoffeeStaticFactory() {}

    public static Coffee create(String type) {
        if ("latte".equalsIgnoreCase(type)) {
            return new Latte();
        } else if ("americano".equalsIgnoreCase(type)) {
            return new Americano();
        }
        throw new IllegalArgumentException("unknown coffee type");
    }
}

public class OrderService {

    public Coffee order(String type) {
        return CoffeeStaticFactory.create(type);
    }
}
```

### 3.2 为什么要这样做

- ✅ 使用简单、语义清晰
- ✅ 不需要维护工厂实例
- ✅ 适合作为“创建工具类”

### 3.3 静态工厂的代价

- ❌ 不利于扩展与替换
- ❌ 不方便测试（难 mock）
- ❌ 不适合 IoC / Spring 注入体系

👉 结论：

静态工厂适合工具化场景，不适合复杂系统。

---

## 4 工厂方法模式（Factory Method）

核心思想一句话：
👉 一个产品，对应一个工厂

---

### 4.1 为什么引入工厂方法

简单工厂的问题本质是：

所有变化集中在一个工厂类中

工厂方法通过 多态 把变化“分散”出去。

---

### 4.2 角色结构

角色 说明
Product 抽象产品（Coffee）
ConcreteProduct 具体产品（Latte / Americano）
Creator 抽象工厂
ConcreteCreator 具体工厂

| 角色            | 说明                          |
| --------------- | ----------------------------- |
| Product         | 抽象产品（Coffee）            |
| ConcreteProduct | 具体产品（Latte / Americano） |
| Creator         | 抽象工厂                      |
| ConcreteCreator | 具体工厂                      |

---

### 4.3 示例代码

抽象工厂

```java
public interface CoffeeFactory {
    Coffee createCoffee();
}

具体工厂

public class LatteFactory implements CoffeeFactory {
    public Coffee createCoffee() {
        return new Latte();
    }
}

public class AmericanoFactory implements CoffeeFactory {
    public Coffee createCoffee() {
        return new Americano();
    }
}
```

业务使用

```java
public class OrderService {

    private final CoffeeFactory factory;

    public OrderService(CoffeeFactory factory) {
        this.factory = factory;
    }

    public Coffee order() {
        return factory.createCoffee();
    }
}
```

---

### 4.4 为什么这样做

- ✅ 符合开闭原则
- ✅ 消灭 if / else
- ✅ 通过“新增类”完成扩展
- ✅ 非常适合 Spring / IoC

👉 代价：

- 类数量增加
- 结构更复杂

---

## 5 抽象工厂模式（Abstract Factory）

核心思想：
👉 创建“一整套产品族”

---

### 5.1 需求升级

不只卖 Coffee，还要配套：

- Cup
- Sugar

并且不同品牌需要风格一致。

---

### 5.2 抽象工厂定义

```java
public interface CafeFactory {

    Coffee createCoffee();
    Cup createCup();
    Sugar createSugar();
}
```

### 5.3 具体工厂

```java
public class StarbucksFactory implements CafeFactory {

    public Coffee createCoffee() { return new Latte(); }
    public Cup createCup() { return new PaperCup(); }
    public Sugar createSugar() { return new WhiteSugar(); }
}

public class LuckinFactory implements CafeFactory {

    public Coffee createCoffee() { return new Americano(); }
    public Cup createCup() { return new CeramicCup(); }
    public Sugar createSugar() { return new BrownSugar(); }
}
```

---

### 5.4 为什么要用抽象工厂

- ✅ 保证产品族一致性
- ✅ 一次切换整套风格
- ✅ 业务层完全解耦具体实现

### 5.5 抽象工厂的代价

- ❌ 新增“产品维度”成本高
- ❌ 所有工厂都要修改接口

👉 适用前提：

产品族稳定，系列可扩展

---

## 6 整体对比总结（面试高频）

| 模式     | 解决的问题 | 扩展方式 | 适用场景 |
| -------- | ---------- | -------- | -------- |
| 不用工厂 | 简单直接   | 改代码   | Demo     |
| 简单工厂 | 集中创建   | 改工厂   | 产品少   |
| 静态工厂 | 轻量工具   | 改代码   | 工具类   |
| 工厂方法 | 消灭分支   | 新增工厂 | 产品多   |
| 抽象工厂 | 产品族一致 | 新增系列 | 多维产品 |

---

## 7 一句话设计动机总结

```text
new 太散 → 简单工厂
工厂太胖 → 工厂方法
出现成套对象 → 抽象工厂
```
