# 写一写 CountDownLatch、CyclicBarrier、semaphore

------

# 实际例子使用



## CountDownLatch

```java
package hemia_Thread;

import java.util.concurrent.CountDownLatch;

public class CoachRacerDemo {
	
	private CountDownLatch latch=new CountDownLatch(3);
	
	//教练
	public void coach() {
		
		System.out.println("教练等待运动员集合");
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			System.out.println("全部到场，开始训练");
		}	
	}
	
	//运动员
	public void racer() {
		
		String name = Thread.currentThread().getName();
		System.out.println(name+" 正在准备");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+" 准备完成");
		latch.countDown();
		
	}
	
	public static void main(String[] args) {
		
		CoachRacerDemo demo=new CoachRacerDemo();
		
		Thread th0=new Thread(()->{
			demo.coach();
		},"教练Thread");
		

		Thread th1=new Thread(()->{
			demo.racer();
		},"运动员1Thread");
		

		Thread th2=new Thread(()->{
			demo.racer();
		},"运动员2Thread");
		

		Thread th3=new Thread(()->{
			demo.racer();
		},"运动员3Thread");
		
		th0.start();	
        th1.start();
		th2.start();
		th3.start();		
	}

}

```

效果

![4](C:\Users\dolly\Pictures\markdown笔记需要的截图\4.JPG)



## CyclicBarrier

```java
package hemia_Thread;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	
	CyclicBarrier barrier=new CyclicBarrier(3);
	
	public void test() {
		
		String name=Thread.currentThread().getName();
		System.out.println(name+" 准备执行");
		try {
			barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+" 正在执行"+new Date().getTime());
	}
	
	public static void main(String[] args) {
		
		CyclicBarrierTest demo=new CyclicBarrierTest();
		Thread th1=new Thread(()->{
			demo.test();
		},"th1");
		Thread th2=new Thread(()->{
			demo.test();
		},"th2") ;
		Thread th3=new Thread(()->{
			demo.test();
		},"th3") ;
		
		th1.start();
		th2.start();
		th3.start();
		
	}

}

```

效果

![5](C:\Users\dolly\Pictures\markdown笔记需要的截图\5.JPG)

## Semaphore

```java
package hemia_Thread;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	
	static class Work{
		
		private int workNum;
		private Semaphore machine;
		
		public Work(int workNum,Semaphore machine) {
			this.workNum=workNum;
			this.machine=machine;
		}
		
		public void excuteWork() {
			String name = Thread.currentThread().getName();
			try {
				machine.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name+"正在工作");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(name+" 完成工作");
			machine.release();
			
		}
		
	}
	
	
	public static void main(String[] args) {
		Work w=new Work(8,new Semaphore(3));
		
		for(int i=0;i<8;i++) {
			new Thread(()->{
				w.excuteWork();
			},"th"+i).start(); ;
		}
		
	}

}

```

效果

![6](C:\Users\dolly\Pictures\markdown笔记需要的截图\6.JPG)



# 使用分析













