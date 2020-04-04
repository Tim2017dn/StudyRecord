
参考文章[：https://liuzhengyang.github.io/2017/05/12/aqs](https://liuzhengyang.github.io/2017/05/12/aqs/)


==两个基本操作==
acquire 和 release
acquire 表示根据同步器状态获取请求，获取不成功需要等待排队
release 表示释放状态让给其他线程

## 初步设计
int类型的state字段表示同步状态

==exclusive模式==
同一时刻最多只有一个线程能够处于成功获取的状态

==shared模式==
多个线程一起获取成功

## 更具体设计

同步状态synchronization管理

阻塞、唤醒线程

#### 线程等待队列
AQS的核心是一个线程等待队列，采用的是一个先进先出的FIFO队列
实现一个非阻塞的同步队列有==两个==选择
- [ ] Mellor-Crummey and Scott (MCS) locks
- [ ] Craig, Landin, and Hagersten (CLH) locks

AQS采取CLH队列

#### ConditionObject
ConditionObject类表示监听器风格的等待通知操作

ConditionObject使用相同的内部队列节点，但是在维护一个单独的队列，当受到signal操作是将条件队列节点转移到等待队列



## 代码设计

#### node结构

``` java
class Node {
        volatile int waitStatus;
        volatile Node prev;
        volatile Node next;
        volatile Thread thread;
        Node nextWaiter;
        ...
}
```

waitStatus有如下几个值

```
static final int CANCELLED =  1;
/** waitStatus value to indicate successor's thread needs unparking */
static final int SIGNAL    = -1;
/** waitStatus value to indicate thread is waiting on condition */
static final int CONDITION = -2;
/**
 * waitStatus value to indicate the next acquireShared should
 * unconditionally propagate
 */
static final int PROPAGATE = -3;
```
CANCELED表示线程池等待已经取消
SIGNAL 表示需要唤醒next 节点
Condition 表示等待一个条件
Propagate 用于accquireShard 向后传播  ？？？？


