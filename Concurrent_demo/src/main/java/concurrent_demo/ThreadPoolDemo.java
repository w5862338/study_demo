package concurrent_demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangxiang w00448499 2019/3/6 16:42
 * 《实战Java高并发程序设计》 p98
 */
public class ThreadPoolDemo {
    ///SDFGFD
    public static class Mytask implements Runnable{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis()+":Thread ID:"+Thread.currentThread());

            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
        }
    }


    public static void main(String[] args) {
        Mytask mytask =new Mytask();

        ExecutorService es = Executors.newFixedThreadPool(5);
        for(int i=0;i<100;i++){
            es.submit(mytask);
        }
    }

}
