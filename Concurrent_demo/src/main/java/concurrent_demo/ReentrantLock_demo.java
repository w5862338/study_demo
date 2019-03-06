package concurrent_demo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangxiang w00448499 2019/3/4 11:35
 * 《实战Java高并发程序设计》 3.1.1  重入锁的demo
 */
public class ReentrantLock_demo implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();
    public static int i=0;

    @Override
    public void run() {
       for (int j=0;j<10000;j++){
           lock.lock();
           try{
               i++;
               System.out.println(Thread.currentThread().getName()+"get lock");
           }finally {
               lock.unlock();
           }
       }
    }

    public static void main(String[] args) throws InterruptedException{
        ReentrantLock_demo t_lock=new ReentrantLock_demo();
        Thread t1=new Thread(t_lock);
        Thread t2=new Thread(t_lock);

        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(i);

    }





}
