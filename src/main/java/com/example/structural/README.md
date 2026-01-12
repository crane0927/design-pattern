# 结构型设计模式（Structural Design Patterns）—— 对比与总结

> **核心理念：结构型设计模式 = 重思想、轻代码**  
> **核心洞察：代码长得像，是因为"形式不重要，关系才重要"**

---

## 1. 为什么结构型设计模式的代码长得像？

### 1.1 代码结构的相似性

让我们先看看几个模式的代码结构：

**适配器模式（对象适配器）：**
```java
public class SDAdapterTF implements SDCard {
    private TFCard tfCard;  // 持有被适配对象
    
    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }
    
    @Override
    public void read() {
        tfCard.read();  // 转发调用
    }
}
```

**装饰器模式：**
```java
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;  // 持有被装饰对象
    
    protected CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
    
    @Override
    public double cost() {
        return coffee.cost();  // 转发调用
    }
}
```

**代理模式（静态代理）：**
```java
public class ProxyPoint implements SellTickets {
    private Station station;  // 持有被代理对象
    
    public ProxyPoint(Station station) {
        this.station = station;
    }
    
    @Override
    public void sell() {
        System.out.println("代理点收取服务费");  // 增强功能
        station.sell();  // 转发调用
    }
}
```

**桥接模式：**
```java
public abstract class Message {
    protected MessageSender messageSender;  // 持有实现对象
    
    protected Message(MessageSender messageSender) {
        this.messageSender = messageSender;
    }
    
    public abstract void send(String message);
}
```

**组合模式：**
```java
public abstract class Component {
    protected String name;
    
    protected Component(String name) {
        this.name = name;
    }
    
    public abstract void add(Component composite);
    public abstract void display(String prefix, boolean isLast);
}
```

**外观模式：**
```java
public class Computer {
    private Cpu cpu;  // 持有子系统对象
    private Memory memory;
    private Motherboard motherboard;
    
    public Computer() {
        this.cpu = new Cpu();
        this.memory = new Memory();
        this.motherboard = new Motherboard();
    }
    
    public void start() {
        cpu.start();  // 统一调用
        memory.start();
        motherboard.start();
    }
}
```

**享元模式：**
```java
public class BoxFactory {
    private static HashMap<String, AbstractBox> map = new HashMap<>();  // 持有享元对象
    
    public static AbstractBox getBox(String key) {
        return map.get(key);  // 返回共享对象
    }
}
```

### 1.2 相似性的本质

**共同特征：**
- ✅ 都持有其他对象的引用（组合关系）
- ✅ 都实现或继承某个接口/抽象类
- ✅ 都通过"转发调用"或"统一管理"来实现功能
- ✅ 代码结构高度相似：`private X x;` + `构造函数` + `方法转发`

**为什么长得像？**

因为它们的**代码形式**都是：
```
持有引用 + 实现接口 + 转发调用
```

但它们的**关系本质**完全不同！

---

## 2. 形式不重要，关系才重要

### 2.1 关系对比表

| 模式 | 核心关系 | 关系本质 | 代码形式 |
|------|---------|---------|---------|
| **适配器** | `适配器 → 被适配者` | **转换关系**：将不兼容接口转换为兼容接口 | `implements Target { private Adaptee adaptee; }` |
| **装饰器** | `装饰器 → 被装饰者` | **增强关系**：动态添加功能，可叠加 | `implements Component { protected Component component; }` |
| **代理** | `代理 → 被代理者` | **控制关系**：控制访问，增强功能 | `implements Subject { private Subject subject; }` |
| **桥接** | `抽象 → 实现` | **分离关系**：抽象与实现分离，独立变化 | `abstract class Message { protected MessageSender messageSender; }` |
| **组合** | `容器 → 组件` | **层次关系**：部分-整体，树形结构 | `abstract class Component { add/remove/display }` |
| **外观** | `外观 → 子系统` | **简化关系**：统一接口，隐藏复杂性 | `class Facade { private Subsystem1 s1; ... }` |
| **享元** | `工厂 → 享元` | **共享关系**：共享内部状态，减少内存 | `Factory { Map<String, Flyweight> cache; }` |

### 2.2 关系本质详解

#### 🔄 适配器模式：**转换关系**

```
客户端 → [适配器] → 被适配者
         (转换接口)
```

**关系本质：** 让不兼容的接口能够协同工作  
**关键点：** 适配器"转换"接口，让客户端可以像使用目标接口一样使用被适配者

**示例：**
- `SDAdapterTF` 将 `TFCard` 接口转换为 `SDCard` 接口
- 客户端调用 `SDCard.read()`，适配器内部调用 `TFCard.read()`

---

#### ✨ 装饰器模式：**增强关系**

```
客户端 → [装饰器1] → [装饰器2] → 被装饰者
         (增强功能)  (增强功能)
```

**关系本质：** 动态添加功能，可以叠加多个装饰器  
**关键点：** 装饰器"增强"功能，可以叠加，形成功能链

**示例：**
- `MilkDecorator` 装饰 `Coffee`，添加牛奶功能
- `SugarDecorator` 装饰 `MilkDecorator`，添加糖功能
- 可以无限叠加：`new SugarDecorator(new MilkDecorator(new SimpleCoffee()))`

---

#### 🛡️ 代理模式：**控制关系**

```
客户端 → [代理] → 被代理者
         (控制访问)
```

**关系本质：** 控制对对象的访问，可以增强功能  
**关键点：** 代理"控制"访问，可以在调用前后添加逻辑（日志、权限、缓存等）

**示例：**
- `ProxyPoint` 代理 `Station`，在卖票前收取服务费
- 客户端调用 `ProxyPoint.sell()`，代理先执行额外逻辑，再调用 `Station.sell()`

---

#### 🌉 桥接模式：**分离关系**

```
抽象化 → [桥接] → 实现化
(变化维度1)      (变化维度2)
```

**关系本质：** 将抽象与实现分离，使它们可以独立变化  
**关键点：** 通过"桥接"（组合）连接抽象和实现，避免类爆炸

**示例：**
- `Message`（抽象）持有 `MessageSender`（实现）的引用
- `NormalMessage` 和 `UrgentMessage`（抽象维度）可以搭配 `EmailMessageSender` 和 `SmsMessageSender`（实现维度）
- 避免了 2×2=4 个子类的爆炸

---

#### 🌳 组合模式：**层次关系**

```
容器节点
  ├─ 叶子节点1
  ├─ 叶子节点2
  └─ 容器节点
      ├─ 叶子节点3
      └─ 叶子节点4
```

**关系本质：** 表示部分-整体的层次结构，统一处理单个对象和组合对象  
**关键点：** 通过"组合"形成树形结构，客户端可以一致地处理叶子节点和容器节点

**示例：**
- `Component` 定义统一接口
- `Leaf` 是叶子节点（没有子节点）
- `Composite` 是容器节点（包含子节点）
- 客户端调用 `display()` 可以递归显示整个树

---

#### 🏛️ 外观模式：**简化关系**

```
客户端 → [外观] → 子系统1
                 子系统2
                 子系统3
```

**关系本质：** 为复杂子系统提供统一接口，简化客户端使用  
**关键点：** 外观"简化"接口，隐藏子系统的复杂性

**示例：**
- `Computer` 外观类封装了 `Cpu`、`Memory`、`Motherboard` 的启动逻辑
- 客户端只需调用 `Computer.start()`，无需了解各个子系统的细节

---

#### 🎯 享元模式：**共享关系**

```
客户端1 ─┐
客户端2 ─┼→ [享元工厂] → 享元对象（共享）
客户端3 ─┘
```

**关系本质：** 共享相同的内在状态，减少内存占用  
**关键点：** 通过"共享"减少对象数量，相同 key 返回同一个对象

**示例：**
- `BoxFactory` 缓存 `IBox`、`JBox`、`LBox` 实例
- 多个客户端调用 `getBox("I")` 都返回同一个 `IBox` 对象
- 外部状态（颜色）由客户端传入，不存储在享元对象中

---

## 3. 七种模式的核心区别

### 3.1 目的对比

| 模式 | 解决的核心问题 | 关键动词 |
|------|--------------|---------|
| **适配器** | 接口不兼容 | **转换** |
| **装饰器** | 功能扩展 | **增强** |
| **代理** | 访问控制 | **控制** |
| **桥接** | 类爆炸 | **分离** |
| **组合** | 树形结构 | **组合** |
| **外观** | 接口复杂 | **简化** |
| **享元** | 内存浪费 | **共享** |

### 3.2 关系方向对比

| 模式 | 关系方向 | 关系数量 | 关系特点 |
|------|---------|---------|---------|
| **适配器** | 单向：适配器 → 被适配者 | 1对1 | 转换接口 |
| **装饰器** | 单向：装饰器 → 被装饰者 | 1对1，可叠加 | 增强功能 |
| **代理** | 单向：代理 → 被代理者 | 1对1 | 控制访问 |
| **桥接** | 双向：抽象 ↔ 实现 | 1对多 | 独立变化 |
| **组合** | 递归：容器 → 组件 | 1对多，可嵌套 | 树形结构 |
| **外观** | 一对多：外观 → 多个子系统 | 1对多 | 统一接口 |
| **享元** | 多对一：多个客户端 → 享元 | 多对1 | 共享对象 |

### 3.3 使用场景对比

| 模式 | 典型场景 | 判断标准 |
|------|---------|---------|
| **适配器** | 集成第三方库、接口不兼容 | "我需要让 A 接口适配 B 接口" |
| **装饰器** | 动态添加功能、功能组合 | "我需要在不修改类的情况下添加功能，且可以叠加" |
| **代理** | 访问控制、功能增强、延迟加载 | "我需要控制对对象的访问，或在调用前后添加逻辑" |
| **桥接** | 多维度变化、避免类爆炸 | "我有两个变化维度，不想用继承产生大量子类" |
| **组合** | 树形结构、递归处理 | "我需要表示部分-整体的层次结构" |
| **外观** | 简化复杂子系统 | "子系统太复杂，我需要一个简单接口" |
| **享元** | 大量相似对象、内存优化 | "我需要创建大量相似对象，想减少内存占用" |

---

## 4. 代码相似但关系不同

### 4.1 适配器 vs 装饰器 vs 代理

这三个模式的代码结构最相似，但关系完全不同：

**代码结构（几乎一样）：**
```java
// 适配器
public class SDAdapterTF implements SDCard {
    private TFCard tfCard;  // 持有被适配者
    public void read() { tfCard.read(); }  // 转换调用
}

// 装饰器
public class MilkDecorator implements Coffee {
    protected Coffee coffee;  // 持有被装饰者
    public double cost() { return coffee.cost() + 2.0; }  // 增强功能
}

// 代理
public class ProxyPoint implements SellTickets {
    private Station station;  // 持有被代理者
    public void sell() { 
        System.out.println("收费");  // 增强功能
        station.sell();  // 转发调用
    }
}
```

**关系本质（完全不同）：**

| 模式 | 关系本质 | 关键区别 |
|------|---------|---------|
| **适配器** | **转换**：让不兼容接口协同工作 | 适配器实现目标接口，调用被适配者方法 |
| **装饰器** | **增强**：动态添加功能，可叠加 | 装饰器实现相同接口，可以叠加多个 |
| **代理** | **控制**：控制访问，增强功能 | 代理实现相同接口，控制对被代理者的访问 |

**判断标准：**
- **适配器**：接口不兼容，需要转换
- **装饰器**：需要动态添加功能，且可以叠加
- **代理**：需要控制访问，或在调用前后添加逻辑

---

### 4.2 桥接 vs 组合

这两个模式都涉及"组合"，但关系不同：

**桥接模式：**
```java
// 抽象持有实现的引用
public abstract class Message {
    protected MessageSender messageSender;  // 实现化
    public abstract void send(String message);
}
```

**组合模式：**
```java
// 容器持有组件的引用
public class Composite extends Component {
    private List<Component> children;  // 组件列表
    public void add(Component component) { children.add(component); }
}
```

**关系本质：**
- **桥接**：抽象与实现的**分离关系**，两个变化维度独立
- **组合**：部分与整体的**层次关系**，树形结构

---

### 4.3 外观 vs 享元

这两个模式都涉及"管理多个对象"，但关系不同：

**外观模式：**
```java
// 外观持有多个子系统对象
public class Computer {
    private Cpu cpu;
    private Memory memory;
    private Motherboard motherboard;
    public void start() { cpu.start(); memory.start(); motherboard.start(); }
}
```

**享元模式：**
```java
// 工厂持有多个享元对象（共享）
public class BoxFactory {
    private static Map<String, AbstractBox> map;
    public static AbstractBox getBox(String key) { return map.get(key); }
}
```

**关系本质：**
- **外观**：**简化关系**，为多个子系统提供统一接口
- **享元**：**共享关系**，多个客户端共享同一个享元对象

---

## 5. 结构型设计模式的核心思想

### 5.1 重思想、轻代码

结构型设计模式的核心不在于代码的复杂程度，而在于**关系的设计**：

```
代码形式（相似）：
  持有引用 + 实现接口 + 转发调用

关系本质（不同）：
  转换关系 vs 增强关系 vs 控制关系 vs 分离关系 vs 层次关系 vs 简化关系 vs 共享关系
```

**关键洞察：**
- ✅ **形式不重要**：代码结构相似是正常的，因为它们都遵循相同的设计原则（组合优于继承）
- ✅ **关系才重要**：真正区分模式的是它们表达的**关系本质**和**设计意图**
- ✅ **重思想**：理解模式要理解它的**关系本质**和**解决的问题**
- ✅ **轻代码**：代码只是实现关系的手段，不是模式的核心

### 5.2 如何区分结构型设计模式？

**第一步：看关系**
- 适配器：转换关系（接口转换）
- 装饰器：增强关系（功能叠加）
- 代理：控制关系（访问控制）
- 桥接：分离关系（抽象与实现分离）
- 组合：层次关系（部分-整体）
- 外观：简化关系（统一接口）
- 享元：共享关系（对象共享）

**第二步：看目的**
- 适配器：解决接口不兼容
- 装饰器：解决功能扩展
- 代理：解决访问控制
- 桥接：解决类爆炸
- 组合：解决树形结构
- 外观：解决接口复杂
- 享元：解决内存浪费

**第三步：看代码**
- 代码结构相似是正常的
- 关键看代码表达的**关系**和**目的**

---

## 6. 模式选择决策树

```
需要解决的问题是什么？
│
├─ 接口不兼容？
│  └─ → 适配器模式
│
├─ 需要动态添加功能，且可以叠加？
│  └─ → 装饰器模式
│
├─ 需要控制访问，或在调用前后添加逻辑？
│  └─ → 代理模式
│
├─ 有两个变化维度，不想用继承？
│  └─ → 桥接模式
│
├─ 需要表示部分-整体的层次结构？
│  └─ → 组合模式
│
├─ 子系统太复杂，需要简化接口？
│  └─ → 外观模式
│
└─ 需要创建大量相似对象，想减少内存？
   └─ → 享元模式
```

---

## 7. 总结

### 7.1 核心观点

1. **结构型设计模式 = 重思想、轻代码**
   - 代码结构相似是正常的
   - 关键在于理解**关系本质**和**设计意图**

2. **形式不重要，关系才重要**
   - 代码形式：`持有引用 + 实现接口 + 转发调用`
   - 关系本质：转换、增强、控制、分离、层次、简化、共享

3. **如何区分模式？**
   - 看关系：模式表达的关系是什么？
   - 看目的：模式解决什么问题？
   - 看代码：代码如何表达关系和目的？

### 7.2 七种模式的关系总结

| 模式 | 关系 | 目的 | 代码特征 |
|------|------|------|---------|
| **适配器** | 转换关系 | 接口转换 | `implements Target { private Adaptee; }` |
| **装饰器** | 增强关系 | 功能叠加 | `implements Component { protected Component; }` |
| **代理** | 控制关系 | 访问控制 | `implements Subject { private Subject; }` |
| **桥接** | 分离关系 | 独立变化 | `abstract class { protected Implementor; }` |
| **组合** | 层次关系 | 树形结构 | `abstract class Component { List<Component>; }` |
| **外观** | 简化关系 | 统一接口 | `class Facade { private Subsystem1...; }` |
| **享元** | 共享关系 | 减少内存 | `Factory { Map<String, Flyweight>; }` |

### 7.3 一句话总结

> **结构型设计模式通过组合关系组织对象，代码形式相似但关系本质不同。理解模式要理解它的关系本质和设计意图，而不是仅仅看代码结构。**

---

## 8. 参考资源

- [适配器模式](./adapter/README.md)
- [装饰器模式](./decorator/README.md)
- [代理模式](./proxy/README.md)
- [桥接模式](./bridge/README.md)
- [组合模式](./composite/README.md)
- [外观模式](./facade/README.md)
- [享元模式](./flyweight/README.md)
