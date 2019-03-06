package concurrent_demo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author wangxiang w00448499 2019/3/4 16:25
 * 《实战Java高并发程序设计》 p84
 * 允许多个线程同时访问 信号量 Semaphore
 */
public class SemapDemo implements Runnable{
    final Semaphore semp =new Semaphore(5);

    @Override
    public void run() {
        try{
            semp.acquire();
            //模拟耗时操作
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getId()+":done");
            semp.release();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        final SemapDemo demo =new SemapDemo();
        for (int i=0;i<50;i++){
            exec.submit(demo);
        }
    }
}
