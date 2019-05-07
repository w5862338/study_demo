package concurrent_demo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangxiang w00448499 2019/3/4 15:37
 * 《实战Java高并发程序设计》 公平锁
 */
public class FairLock implements Runnable {
    public static ReentrantLock fairLock =new ReentrantLock(true);

    @Override
    public void run() {
        while(true){
            try{
                fairLock.lock();
                System.out.println(Thread.currentThread().getName()+"获得锁");
            }finally {
                fairLock.unlock();
            }

        }
    }

    public static void main(String[] args) {
        FairLock t_lock =new FairLock();
        Thread t1=new Thread(t_lock,"Thread_1");
        Thread t2=new Thread(t_lock,"Thread_2");
        t1.start();t2.start();
    }
}
