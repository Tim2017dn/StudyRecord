# Redis



Key-value 数据库

内存存储、单线程、持久化（RDB,AOF）

## redis能做什么

-  效率高 高速缓存
- 发布订阅系统
- 地图信息分析
- 计时器、计数器



redis

是基于内存操作，cpu不是redis的性能瓶颈，redis的瓶颈是根据机器的内存和网络带宽



### 为什么单线程还这么快？

多线程会有cpu上下文的切换，比较耗时间

多线程还需要锁的考虑



## 一些命令

```
// 设置10s后失效
EXPIRE [KEY] 10

// 在设置过期后，可以查看还剩多少有效时间
## ttl [KEY]

//查看类型
type [key]

//查看所有的key
keys *

```





## 数据结构

 基本

```
string
hash
list
set
zset 
```



额外的

```
hyperlog
geospatial
bitmap
```



### String

```
set key1 v1

get key1

EXISTS key1

APPEND KEY "hello"

strlen key1

```



```
set views 0

get views

incr views

decr views

incrby view 10

decrby view 10


```



```

flushdb

set key1 "hello kuangshneg"

getrange key1 0 3

set key2 abcdefg
setrange key2 1 xx

```



```
setex (set with expire)

setnx (set if not exist)  不存在再设置 （）在分布式锁
```



```
mset

mget

getset key1 v1
```



### hash

 key field value

= key - map<key,value>





## 主从复制

读写分离 

```
master 以写为主 slave 以读为主
```

主要作用

```
1、数据冗余：主从复制实现数据的热备份
2、故障恢复：主节点出现问题，可以由slave节点提供服务
3、负载均衡
```



