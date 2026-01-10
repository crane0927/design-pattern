# 创建型模式（Creational Patterns）对比总结

> **创建型模式**关注对象的创建过程，将对象的创建与使用分离，提供更加灵活的对象创建机制。  
> 本目录包含四种常见的创建型模式：**单例模式**、**工厂模式**、**建造者模式**、**原型模式**。

---

## 1. 创建型模式概述

### 1.1 核心目标

创建型模式的主要目标是：
- **解耦对象的创建和使用**：将对象创建的复杂性封装起来
- **提高代码的灵活性**：通过不同的创建方式适应不同的需求
- **优化资源使用**：控制对象创建的数量和时机
- **简化对象创建**：提供简洁的接口来创建复杂对象

### 1.2 常见创建型模式

本项目中包含以下四种创建型模式的完整示例：

| 模式 | 目录 | 核心关注点 | 典型场景 |
|------|------|-----------|---------|
| **单例模式** | `../singleton/` | 保证只有一个实例 | 配置管理、线程池、连接池 |
| **工厂模式** | `../factory/` | 如何创建对象 | 需要创建多种类型对象 |
| **建造者模式** | `../builder/` | 如何构建复杂对象 | 多参数对象构造 |
| **原型模式** | `../prototype/` | 如何复制对象 | 对象创建成本高、需要大量相似对象 |

---

## 2. 四种模式详细对比

### 2.1 单例模式（Singleton Pattern）

#### 核心思想
> 保证一个类只有一个实例，并提供全局访问点。

#### 解决的问题
- ✅ 控制实例数量：确保全局只有一个实例
- ✅ 节省资源：避免重复创建对象
- ✅ 全局访问：提供统一的访问入口

#### 适用场景
- 配置管理类（全局配置）
- 线程池、连接池（资源管理）
- 日志记录器（统一日志）
- 缓存管理器（全局缓存）
- 注册表/工厂（全局注册）

#### 代码示例

```java
// 静态内部类实现（推荐）
public class Singleton {
    private Singleton() {}
    
    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }
    
    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
}
```

#### 优缺点

| 优点 | 缺点 |
|------|------|
| ✅ 保证唯一实例 | ❌ 难以测试（全局状态） |
| ✅ 节省内存 | ❌ 隐藏依赖关系 |
| ✅ 全局访问点 | ❌ 违反单一职责原则 |
| ✅ 延迟初始化（部分实现） | ❌ 可能影响并发性能 |

#### 与其他模式的区别
- **vs 工厂模式**：单例关注实例数量（1个），工厂关注创建方式（如何创建）
- **vs 建造者模式**：单例是限制创建，建造者是优化创建流程

---

### 2.2 工厂模式（Factory Pattern）

#### 核心思想
> 将对象的创建逻辑封装在工厂类中，客户端通过工厂来创建对象，而不是直接使用 `new`。

#### 解决的问题
- ✅ 解耦创建和使用：将对象创建逻辑与业务逻辑分离
- ✅ 集中管理：统一管理对象的创建过程
- ✅ 易于扩展：通过新增工厂类扩展功能（工厂方法模式）
- ✅ 隐藏创建细节：客户端不需要知道具体的创建过程

#### 模式变体

| 变体 | 特点 | 适用场景 |
|------|------|---------|
| **简单工厂** | 集中创建，if/else 判断 | 产品类型少，创建逻辑简单 |
| **静态工厂** | 静态方法创建，无状态 | 工具类场景 |
| **工厂方法** | 一个产品一个工厂 | 产品类型多，需要扩展 |
| **抽象工厂** | 创建产品族 | 需要保证产品族一致性 |

#### 代码示例

```java
// 工厂方法模式
public interface CoffeeFactory {
    Coffee createCoffee();
}

public class LatteFactory implements CoffeeFactory {
    public Coffee createCoffee() {
        return new Latte();
    }
}

// 使用
CoffeeFactory factory = new LatteFactory();
Coffee coffee = factory.createCoffee();
```

#### 优缺点

| 优点 | 缺点 |
|------|------|
| ✅ 解耦创建和使用 | ❌ 增加类的数量（工厂方法） |
| ✅ 符合开闭原则（工厂方法） | ❌ 简单工厂违反开闭原则 |
| ✅ 易于扩展和替换 | ❌ 抽象工厂接口会变得庞大 |
| ✅ 适合依赖注入 | ❌ 实现复杂度增加 |

#### 与其他模式的区别
- **vs 单例模式**：工厂关注如何创建，单例关注创建多少（1个）
- **vs 建造者模式**：工厂直接返回完整对象，建造者逐步构建
- **vs 原型模式**：工厂创建新对象，原型复制已有对象

---

### 2.3 建造者模式（Builder Pattern）

#### 核心思想
> 将一个复杂对象的构建与表示分离，使得同样的构建过程可以创建不同的表示。

#### 解决的问题
- ✅ 多参数构造问题：解决构造函数参数过多的问题
- ✅ 可选参数处理：灵活处理可选参数
- ✅ 构建过程优化：提供清晰的链式调用
- ✅ 对象完整性：确保对象构建完成才可使用

#### 适用场景
- 参数众多的对象构造（4+ 个参数）
- 需要灵活组合可选参数
- 需要保证对象构建完整性
- 需要创建不可变对象
- 配置对象构建（数据库配置、HTTP 客户端配置等）

#### 代码示例

```java
// 建造者模式
public class Computer {
    private String cpu;
    private String memory;
    // ... 其他字段
    
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.memory = builder.memory;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private String cpu;
        private String memory;
        
        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }
        
        public Builder memory(String memory) {
            this.memory = memory;
            return this;
        }
        
        public Computer build() {
            return new Computer(this);
        }
    }
}

// 使用
Computer computer = Computer.builder()
    .cpu("Intel i7")
    .memory("16GB")
    .build();
```

#### 优缺点

| 优点 | 缺点 |
|------|------|
| ✅ 提高可读性（链式调用） | ❌ 代码量增加 |
| ✅ 灵活的参数组合 | ❌ 需要额外的 Builder 对象 |
| ✅ 保证对象完整性 | ❌ 性能略低（可忽略） |
| ✅ 支持不可变对象 | ❌ 需要维护两套代码 |
| ✅ 易于扩展参数 | |

#### 与其他模式的区别
- **vs 工厂模式**：建造者关注如何构建，工厂关注创建什么
- **vs 原型模式**：建造者从零构建，原型复制已有对象
- **vs 单例模式**：建造者创建多个实例，单例只有一个实例

---

### 2.4 原型模式（Prototype Pattern）

#### 核心思想
> 通过复制已有对象来创建新对象，而不是通过构造函数创建，避免重复初始化的成本。

#### 解决的问题
- ✅ 对象创建成本高：避免重复的初始化过程
- ✅ 提高性能：克隆比重新创建更高效
- ✅ 简化创建：通过克隆简化对象创建流程
- ✅ 动态创建：在运行时动态创建对象副本

#### 深浅拷贝对比

| 类型 | 特点 | 适用场景 |
|------|------|---------|
| **浅拷贝** | 只复制对象本身，引用字段共享 | 只有基本类型和不可变类型字段 |
| **深拷贝** | 对象及其引用字段都被复制 | 有可变引用字段，需要完全独立 |

#### 代码示例

```java
// 深拷贝实现
public class Diploma2 implements Cloneable {
    private Student2 student;
    
    @Override
    public Diploma2 clone() {
        try {
            Diploma2 cloned = (Diploma2) super.clone();
            if (this.student != null) {
                cloned.setStudent(this.student.clone());
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

// 使用
Diploma2 original = new Diploma2();
Diploma2 cloned = original.clone();
```

#### 优缺点

| 优点 | 缺点 |
|------|------|
| ✅ 提高性能（避免重复初始化） | ❌ 深拷贝实现复杂 |
| ✅ 简化对象创建 | ❌ Cloneable 接口设计缺陷 |
| ✅ 灵活扩展 | ❌ 浅拷贝有风险 |
| ✅ 节省资源 | ❌ 继承关系复杂时实现困难 |

#### 与其他模式的区别
- **vs 工厂模式**：原型复制已有对象，工厂创建新对象
- **vs 建造者模式**：原型直接复制，建造者逐步构建
- **vs 单例模式**：原型创建多个实例，单例只有一个实例

---

## 3. 四种模式选择指南

### 3.1 根据需求选择模式

#### 场景 1：需要全局唯一对象
**选择：单例模式**

```
问题：需要一个全局唯一的配置管理器
解决：单例模式，保证只有一个实例
```

#### 场景 2：需要创建多种类型的对象
**选择：工厂模式**

```
问题：需要根据类型创建不同类型的咖啡（Latte、Americano）
解决：工厂模式，将创建逻辑封装在工厂中
```

#### 场景 3：对象构造参数很多
**选择：建造者模式**

```
问题：Computer 对象有 7+ 个参数，构造函数难以使用
解决：建造者模式，链式调用，清晰灵活
```

#### 场景 4：对象创建成本高
**选择：原型模式**

```
问题：对象初始化需要从数据库读取、网络请求等，成本高
解决：原型模式，复制已有对象，避免重复初始化
```

### 3.2 快速决策树

```
需要创建对象？
├─ 需要全局唯一？
│  └─ 是 → 单例模式
│  └─ 否
│     ├─ 参数很多（4+）？
│     │  └─ 是 → 建造者模式
│     │  └─ 否
│     │     ├─ 对象创建成本高？
│     │     │  └─ 是 → 原型模式
│     │     │  └─ 否 → 工厂模式
│     │     └─ 需要创建多种类型？
│     │        └─ 是 → 工厂模式
│     └─ 需要复制已有对象？
│        └─ 是 → 原型模式
```

### 3.3 模式对比表

| 维度 | 单例模式 | 工厂模式 | 建造者模式 | 原型模式 |
|------|---------|---------|-----------|---------|
| **实例数量** | 1个 | 多个 | 多个 | 多个 |
| **创建方式** | 直接获取 | 工厂创建 | 逐步构建 | 复制克隆 |
| **适用对象** | 全局资源 | 多种类型 | 复杂对象 | 相似对象 |
| **参数处理** | 无 | 通过类型 | 链式设置 | 无需参数 |
| **扩展性** | 低 | 高（工厂方法） | 高 | 中 |
| **性能** | 高 | 中 | 中 | 高（避免初始化） |
| **复杂度** | 低-中 | 低-高 | 中 | 中-高 |

---

## 4. 模式组合使用

### 4.1 工厂 + 单例
**场景**：工厂类本身可以是单例

```java
// 单例工厂
public class CoffeeFactory {
    private static final CoffeeFactory INSTANCE = new CoffeeFactory();
    
    private CoffeeFactory() {}
    
    public static CoffeeFactory getInstance() {
        return INSTANCE;
    }
    
    public Coffee create(String type) {
        // 创建逻辑
    }
}
```

### 4.2 工厂 + 建造者
**场景**：工厂方法返回建造者

```java
public interface ConfigBuilderFactory {
    ConfigBuilder createBuilder();
}

public class DatabaseConfigBuilderFactory implements ConfigBuilderFactory {
    public ConfigBuilder createBuilder() {
        return new DatabaseConfig.Builder();
    }
}
```

### 4.3 工厂 + 原型
**场景**：工厂方法返回克隆的原型对象

```java
public class PrototypeFactory {
    private static final Prototype prototype = new Prototype();
    
    public Prototype create() {
        return prototype.clone(); // 克隆原型
    }
}
```

### 4.4 建造者 + 原型
**场景**：先用建造者创建标准对象，再用原型复制

```java
// 创建标准配置
Computer standardConfig = Computer.builder()
    .cpu("Standard CPU")
    .memory("8GB")
    .build();

// 复制并修改
Computer customConfig = standardConfig.clone();
customConfig.setMemory("16GB");
```

---

## 5. 实际应用场景

### 5.1 Spring 框架中的应用

| 模式 | Spring 中的应用 |
|------|----------------|
| **单例模式** | Bean 的默认作用域（Singleton） |
| **工厂模式** | `BeanFactory`、`ApplicationContext` |
| **建造者模式** | `RestTemplateBuilder`、`HttpClientBuilder` |
| **原型模式** | Bean 的原型作用域（Prototype） |

### 5.2 JDK 中的应用

| 模式 | JDK 中的应用 |
|------|-------------|
| **单例模式** | `Runtime.getRuntime()` |
| **工厂模式** | `Calendar.getInstance()`、`NumberFormat.getInstance()` |
| **建造者模式** | `StringBuilder`、`StringBuffer` |
| **原型模式** | `Cloneable` 接口、`Object.clone()` |

### 5.3 常见框架中的应用

| 框架 | 使用的创建型模式 |
|------|----------------|
| **Spring** | 单例（Bean）、工厂（BeanFactory）、原型（Prototype Scope） |
| **MyBatis** | 建造者（SQL Builder）、工厂（SqlSessionFactory） |
| **Guava** | 建造者（`ImmutableList.Builder`）、工厂（`Lists.newArrayList()`） |
| **Apache Commons** | 原型（`SerializationUtils.clone()`）、工厂（各种 Factory） |

---

## 6. 面试要点总结

### 6.1 基础问题

**Q: 创建型模式都有哪些？它们的区别是什么？**

**A:** 
- **单例模式**：保证只有一个实例
- **工厂模式**：封装对象创建逻辑，解耦创建和使用
- **建造者模式**：逐步构建复杂对象，处理多参数构造
- **原型模式**：通过克隆复制对象，避免重复初始化

### 6.2 实践问题

**Q: 什么时候使用单例模式？什么时候使用工厂模式？**

**A:**
- **单例模式**：需要全局唯一对象时（配置管理、线程池、连接池）
- **工厂模式**：需要创建多种类型对象，且希望解耦创建和使用时

**Q: 建造者模式和工厂模式的区别？**

**A:**
- **工厂模式**：关注**创建什么对象**，直接返回完整对象
- **建造者模式**：关注**如何构建对象**，逐步构建复杂对象

**Q: 什么时候使用原型模式？**

**A:**
- 对象创建成本高（数据库查询、网络请求、复杂计算）
- 需要创建大量相似对象
- 需要保护原始对象，通过克隆创建副本

### 6.3 设计问题

**Q: 如何避免单例模式的缺点（全局状态、难以测试）？**

**A:**
- 使用依赖注入，将单例作为依赖传入
- 使用接口，便于 mock 和测试
- 避免在单例中维护可变状态
- 考虑使用枚举单例（线程安全且防反射）

**Q: 工厂模式如何保证开闭原则？**

**A:**
- **工厂方法模式**：通过新增工厂类扩展，不需要修改现有代码
- **简单工厂**：违反开闭原则，新增产品需要修改工厂
- **抽象工厂**：通过新增具体工厂扩展产品系列

---

## 7. 总结与建议

### 7.1 核心要点

1. **单例模式**：适合全局唯一资源，但要慎用（避免滥用）
2. **工厂模式**：适合需要创建多种类型对象的场景，推荐工厂方法模式
3. **建造者模式**：适合多参数对象构造，提高代码可读性
4. **原型模式**：适合对象创建成本高的场景，注意深浅拷贝的选择

### 7.2 最佳实践

- **优先使用工厂方法模式**：符合开闭原则，易于扩展
- **建造者模式配合 Lombok**：使用 `@Builder` 注解简化代码
- **单例模式配合依赖注入**：避免全局状态，提高可测试性
- **原型模式注意深浅拷贝**：根据需求选择合适的拷贝方式

### 7.3 选择建议

```
简单场景（1-2个参数）        → 直接使用构造函数
多参数场景（4+个参数）       → 建造者模式
需要创建多种类型对象         → 工厂模式
需要全局唯一对象             → 单例模式
对象创建成本高               → 原型模式
需要创建产品族               → 抽象工厂模式
```

### 7.4 一句话总结

> **单例**保证唯一，**工厂**封装创建，**建造者**优化构建，**原型**高效复制。根据实际需求选择合适的模式，不要过度设计，也不要过度简化。

---

## 8. 参考文档

- [单例模式详细文档](../singleton/README.md)
- [工厂模式详细文档](../factory/README.md)
- [建造者模式详细文档](../builder/README.md)
- [原型模式详细文档](../prototype/README.md)

---

## 9. 设计模式分类

根据 GoF（Gang of Four）的分类，设计模式分为三类：

- **创建型模式**（Creational Patterns）：关注对象的创建
  - 单例模式、工厂模式、建造者模式、原型模式、抽象工厂模式
  
- **结构型模式**（Structural Patterns）：关注对象的结构组合
  - 适配器模式、装饰器模式、代理模式、外观模式等
  
- **行为型模式**（Behavioral Patterns）：关注对象间的通信
  - 观察者模式、策略模式、模板方法模式、责任链模式等

本目录专注于**创建型模式**，其他类型的模式将在相应的目录中详细介绍。
