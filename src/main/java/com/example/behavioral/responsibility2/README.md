# 责任链模式（改进版）—— 使用责任链管理器

> 本目录包含责任链模式的改进实现，使用责任链管理器集中管理责任链配置，符合开闭原则。

## 目录结构

```
responsibility2/
├── Approver.java              # 抽象处理者
├── ChainManager.java          # 责任链管理器（核心改进）
├── Leader.java                # 具体处理者（组长）
├── Manager.java               # 具体处理者（经理）
├── Director.java              # 具体处理者（总监）
├── Supervisor.java            # 具体处理者（主管，演示插入新处理者）
├── Client.java                # 客户端示例
└── README.md                  # 本文件
```

## 核心改进

### 1. 责任链管理器

使用 `ChainManager` 集中管理责任链配置：

```java
// 责任链配置：处理者的顺序列表
private static final List<Class<? extends Approver>> CHAIN_CONFIG;
```

### 2. 符合开闭原则

**插入新处理者时，无需修改现有代码：**

```java
// 只需要修改责任链管理器
ChainManager.clearChain();
ChainManager.addApprover(Manager.class);
ChainManager.addApprover(Supervisor.class); // 插入 Supervisor
ChainManager.addApprover(Leader.class);
ChainManager.addApprover(Director.class);
```

**无需修改 `Manager.java`、`Leader.java` 等现有处理者类！**

## 运行示例

```bash
mvn compile exec:java -Dexec.mainClass="com.example.behavioral.responsibility2.Client"
```

**输出：**
```
=== 原始责任链 ===
Leader 批准了 1 天的请假请求
Leader 批准了 3 天的请假请求
Manager 批准了 7 天的请假请求
Director 批准了 10 天的请假请求
Director 拒绝了 20 天的请假请求

=== 插入新处理者后的责任链 ===
Supervisor 批准了 1 天的请假请求
Supervisor 批准了 3 天的请假请求
Supervisor 批准了 5 天的请假请求
Manager 批准了 7 天的请假请求
Director 批准了 10 天的请假请求
Director 拒绝了 20 天的请假请求
```

## 优势

- ✅ **符合开闭原则**：添加新处理者无需修改现有代码
- ✅ **解耦**：处理者类之间不直接依赖
- ✅ **集中管理**：责任链配置集中在管理器中
- ✅ **易于扩展**：添加新处理者只需修改配置
- ✅ **动态调整**：可以动态调整责任链的顺序

## 对比原版

### 原版实现（responsibility 目录）

**插入新处理者需要修改客户端代码：**

```java
// 需要手动设置责任链
Manager manager = new Manager();
Leader leader = new Leader();
Supervisor supervisor = new Supervisor(); // 新增
Director director = new Director();

manager.setNext(supervisor);    // 需要修改
supervisor.setNext(leader);     // 需要修改
leader.setNext(director);
```

**问题：**
- ❌ 违反开闭原则：需要修改客户端代码
- ❌ 耦合度高：客户端需要了解责任链的结构

### 改进实现（responsibility2 目录）

**插入新处理者只需修改配置：**

```java
// 只需要修改责任链管理器
ChainManager.clearChain();
ChainManager.addApprover(Manager.class);
ChainManager.addApprover(Supervisor.class); // 插入 Supervisor
ChainManager.addApprover(Leader.class);
ChainManager.addApprover(Director.class);

Approver chain = ChainManager.buildChain();
```

**优势：**
- ✅ 符合开闭原则：无需修改现有处理者类
- ✅ 解耦：客户端不需要了解责任链的结构
- ✅ 集中管理：责任链配置集中在管理器中

## 使用场景

### 使用原版实现的场景：
- 责任链结构简单
- 处理者数量少
- 责任链结构稳定，不会频繁变化
- 对性能要求高

### 使用改进实现的场景：
- 责任链结构复杂
- 处理者数量多
- 责任链结构可能频繁变化
- 需要动态调整责任链
- 需要严格遵循开闭原则

## API 说明

### ChainManager 主要方法

```java
// 构建责任链
Approver chain = ChainManager.buildChain();

// 添加处理者到末尾
ChainManager.addApprover(Supervisor.class);

// 添加处理者到指定位置
ChainManager.addApprover(Supervisor.class, 1);

// 移除处理者
ChainManager.removeApprover(Supervisor.class);

// 清空责任链配置
ChainManager.clearChain();

// 获取责任链配置
List<Class<? extends Approver>> config = ChainManager.getChainConfig();
```
