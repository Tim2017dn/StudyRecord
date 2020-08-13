# ReentrantLock



## 目的 

对资源的一种互斥与共享

1、互斥

2、可重复加锁

## 设计的思想

## 核心问题

- 资源被谁持有
- 持有多少次

## 重要问题

- 如何排队 先来先得 还是 谁响应谁得（公平与非公平）
- 当获取锁失败，是排队等待还是跳过
- 如何告知锁释放，提醒下一个等待者



## 实现

#### 数据模型

AQS AbstractOwnableSynchronizer

```
Thread exclusiveOwnerThread //当前进程 谁持有资源
```

AQS AbstractQueuedSynchronizer extends AbstractOwnableSynchronizer

```
private volatile int state; //可重入次数 持有多少次 

// 用链表来实现排队
private transient volatile Node head;
private transient volatile Node tail;


class node{}
```





