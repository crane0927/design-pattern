# 状态模式（改进版）—— 使用状态转换管理器

> 本目录包含状态模式的改进实现，使用状态转换管理器集中管理状态转换逻辑，符合开闭原则。

## 目录结构

```
state2/
├── OrderState.java              # 状态接口
├── OrderContext.java            # 上下文类
├── StateTransitionManager.java  # 状态转换管理器（核心改进）
├── PendingPayState.java         # 待支付状态
├── PaidState.java               # 已支付状态
├── ProcessingState.java         # 处理中状态（演示插入新状态）
├── ShippedState.java            # 已发货状态
├── Client.java                  # 客户端示例
└── README.md                    # 本文件
```

## 核心改进

### 1. 状态转换管理器

使用 `StateTransitionManager` 集中管理状态转换逻辑：

```java
// 状态转换表：当前状态 -> 下一个状态
private static final Map<Class<? extends OrderState>, Class<? extends OrderState>> TRANSITION_MAP;
```

### 2. 符合开闭原则

**插入新状态时，无需修改现有代码：**

```java
// 只需要修改状态转换管理器
StateTransitionManager.addTransition(PaidState.class, ProcessingState.class);
StateTransitionManager.addTransition(ProcessingState.class, ShippedState.class);
```

**无需修改 `PaidState.java`！**

## 运行示例

```bash
mvn compile exec:java -Dexec.mainClass="com.example.behavioral.state2.Client"
```

**输出：**
```
=== 原始状态链 ===
待支付状态
已支付状态
已发货状态

=== 插入新状态后的状态链 ===
待支付状态
已支付状态
处理中状态
已发货状态
```

## 优势

- ✅ **符合开闭原则**：添加新状态无需修改现有代码
- ✅ **解耦**：状态类之间不直接依赖
- ✅ **集中管理**：状态转换逻辑集中在管理器中
- ✅ **易于扩展**：添加新状态只需修改转换表

## 对比原版

详见 `../state/开闭原则对比.md`
