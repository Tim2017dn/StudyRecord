package learnMutiThread;

import java.util.concurrent.locks.ReentrantLock;

// 一个简单的死锁程序

public class T1 {


    public  ReentrantLock lockA = new ReentrantLock();
    public ReentrantLock lockB = new ReentrantLock();

    public static void main(String[] args) {

        T1 t =new T1();

        new Thread(()->{
            t.fun1();
        },"th1").start();

        new Thread(()->{
            t.fun2();
        },"th2").start();
    }


    public  void fun1(){

        lockA.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" get lockA");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" is waitting");
            lockB.lock();
            try{
                System.out.println(Thread.currentThread().getName()+" get lockB");
            }catch(Exception e){
                e.fillInStackTrace();
            }finally{
                lockB.unlock();
            }

        }catch(Exception e){
            e.fillInStackTrace();
        }finally{
            lockA.unlock();
        }
    }

    public void fun2(){

        lockB.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" get lockB");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" is waitting");
            lockA.lock();
            try{
                System.out.println(Thread.currentThread().getName()+" get lockA");
            }catch(Exception e){
                e.fillInStackTrace();
            }finally{
                lockA.unlock();
            }

        }catch(Exception e){
            e.fillInStackTrace();
        }finally{
            lockB.unlock();
        }
    }

}
