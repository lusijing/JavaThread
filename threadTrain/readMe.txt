
1.1 并发编程

1.2 多个线程多个锁
一个对象一把锁 （对象锁）
如果在synchronlzed加static 表示(类级别锁)

1.3 对象锁的同步异步
原子性（同步）
可见性

1.4 脏读（Dirty Read）A C I D
例：客户端1：select 客户端2：update ，条件：oracle undo概念
客户1查出来的值？不变，一致性读，或者抛出异常（snapshot）,条件：客户端1查询时间长，多个客户端同时访问

1.5 synchronized其他概念
锁重入
锁异常
（storm 分布式计算）
存储过程

1.6 synchronized 代码块

1.7 volatile关键字（不支持原子性）
实现变量在线程中可见（可见性）
AtomicInteger (支持原子性，但是多个方法一起不支持)

2.1 线程之间的通信
使用wait/notify
1 wait 和 notify 必须配合synchronlzed关键字使用
2 wait方法释放锁 ，notify反之。

3.1 同步类容器
同步类容器：Vetor , hashTable,每次只能有一个线程访问容器的状态，性能不高

3.2 并发类容器
ConcurrentHashMap  代替散列的传统的HashTable
CopyOnWriteArrayList 代替Voctor ,并发的CopyOnWriteArraySet
以及并发的Queue ,ConcurrentLinkQueue和LinkedBlockingQueue,前者是高性能的队列，后者是以阻塞形式的队列

4.1 ConcurrentMap
ConcurrentHashMap  segment 段，减小锁的粒度，每个段可以理解为一个hashTable(最多16段，16个线程同时访问不同的段)
ConcurrentSkipHashMap

4.2 Copy_On_Write
读写分离（读多写少的情况下）（读的时候不必加锁，写的时候需要）
当你执行写操作的时候，会copy一份副本，执行完之后，指针转移，并把副本内容回收

4.3 ThreadLocal
线程的变量副本

5.1 并发Queue

5.2 ConcurrentLinkQueue（无阻塞队列，代表不加锁）
通过无锁的方式，性能浩宇BlockingQueue
元素遵循先进先出的原则
元素加入： add() offer()
取头元素：poll() and peek() ,区别在于前者会删除元素，后者不会

5.3 BlockingQueue接口
Array 有界
Link  无界
SynchronousQueue 没有缓存的队列（add的方法不能直接使用，
而且add，并不是往这个SynchronousQueue加元素，它相当于一个临时，中间人的作用，
只有SynchronousQueue使用了take()方法之后才能使用
））

PriorityBlockingQueue(排序，并非在你添加元素的时候，而是在你take()真正取值的时候)
DelayQueue
{有界，无界（指的是初始值，也就是初始长度需不需要定义)}

6.1 多线程的设计模式
Future  类似于异步请求

6.2 Future模式

6.3 Master-Worker模式
并行计算模式
Master负责接收和分配任务
Worker负责处理子任务
