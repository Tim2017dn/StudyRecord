# ReentrantReadWriteLock

------

## 组成



## 实例

> 参考博客：https://www.cnblogs.com/qlqwjy/p/10158409.html


### 1 读读共享
```java
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class Demo1 {
	 private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();// 读写锁
//	    private static final Logger log = LoggerFactory.getLogger(Demo1.class);
	    private int i;
	    public String readI() {
	        try {
	            lock.readLock().lock();// 占用读锁
//	            log.info("threadName -> {} 占用读锁,i->{}", Thread.currentThread().getName(), i);
	            System.out.println(Thread.currentThread().getName()+" 占用读锁,"+i);
	            Thread.sleep(2 * 1000);
	        } catch (InterruptedException e) {

	        } finally {
//	            log.info("threadName -> {} 释放读锁,i->{}", Thread.currentThread().getName(), i);
	        	System.out.println(Thread.currentThread().getName()+" 释放读锁,"+i);
	            lock.readLock().unlock();// 释放读锁
	        }
	        return i + "";
	    }

	    public static void main(String[] args) {
	        final Demo1 demo1 = new Demo1();
	        Runnable runnable = new Runnable() {
	            @Override
	            public void run() {
	                demo1.readI();
	            }
	        };

	        new Thread(runnable, "t1").start();
	        new Thread(runnable, "t2").start();
	        new Thread(runnable, "t3").start();

	    }

}

```

### 2 读写互斥

```java
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo2 {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();// 读写锁


    private int i;

    public void addI() {
        try {
            lock.writeLock().lock();// 占用写锁
//            log.info("threadName -> {} 占用写锁,i->{}", Thread.currentThread().getName(), i);
            System.out.println(Thread.currentThread().getName()+" 占用写锁,"+i);
            Thread.sleep(2 * 1000);
            i++;
        } catch (InterruptedException e) {

        } finally {
//            log.info("threadName -> {} 释放写锁,i->{}", Thread.currentThread().getName(), i);
        	System.out.println(Thread.currentThread().getName()+" 释放写锁,"+i);
            lock.writeLock().unlock();// 释放写锁
        }
    }

    public static void main(String[] args) {
        final Demo2 demo1 = new Demo2();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                demo1.addI();
            }
        };

        new Thread(runnable, "t1").start();
        new Thread(runnable, "t2").start();
        new Thread(runnable, "t3").start();

    }

}

```

### 3 读写互斥

```java
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo3 {
	  private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();// 读写锁


	    private int i;

	    public String readI() {
	        try {
	        	
	            lock.readLock().lock();// 占用读锁
//	            log.info("threadName -> {} 占用读锁,i->{}", Thread.currentThread().getName(), i);
	            System.out.println(Thread.currentThread().getName()+" 占用读锁,"+i);
	            Thread.sleep(2 * 1000);
	        } catch (InterruptedException e) {

	        } finally {
//	            log.info("threadName -> {} 释放读锁,i->{}", Thread.currentThread().getName(), i);
	        	System.out.println(Thread.currentThread().getName()+" 释放读锁,"+i);
	            lock.readLock().unlock();// 释放读锁
	        }
	        return i + "";
	    }

	    public void addI() {
	        try {
	            lock.writeLock().lock();// 占用写锁
//	            log.info("threadName -> {} 占用写锁,i->{}", Thread.currentThread().getName(), i);
	            System.out.println(Thread.currentThread().getName()+" 占用写锁,"+i);
	            Thread.sleep(2 * 1000);
	            i++;
	        } catch (InterruptedException e) {

	        } finally {
//	            log.info("threadName -> {} 释放写锁,i->{}", Thread.currentThread().getName(), i);
	        	System.out.println(Thread.currentThread().getName()+" 释放写锁,"+i);
	            lock.writeLock().unlock();// 释放写锁
	        }
	    }

	    public static void main(String[] args) throws InterruptedException {
	        final Demo3 demo1 = new Demo3();

	        new Thread(new Runnable() {
	            @Override
	            public void run() {
	                demo1.readI();
	            }
	        }, "t1").start();

	        Thread.sleep(1 * 1000);

	        new Thread(new Runnable() {
	            @Override
	            public void run() {
	                demo1.addI();
	            }
	        }, "t2").start();

	    }
}

```



