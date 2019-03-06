package concurrent_demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangxiang w00448499 2019/3/4 14:42
 * 《实战Java高并发程序设计》p75  限时等待锁的使用
 */
public class TimeLock implements Runnable{
    public static ReentrantLock lock= new ReentrantLock();

    @Override
    public void run() {
       try{
           if(lock.tryLock(5, TimeUnit.SECONDS)){
               Thread.sleep(4000);
               System.out.println(Thread.currentThread().getName()+"get lock");

           }else {
               System.out.println(Thread.currentThread().getName()+"get lock failed");
           }
       }catch (InterruptedException e){
           e.printStackTrace();
       }finally {
           if(lock.isHeldByCurrentThread()) {
               lock.unlock();
           }
       }
    }

    public static void main(String[] args) {
        TimeLock t_lock=new TimeLock();
        Thread t1=new Thread(t_lock);
        Thread t2=new Thread(t_lock);
        t1.start();t2.start();
    }

}
