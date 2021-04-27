package cn.longq.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @description: 本测试类中实现的主要功能是 多线程环境下 模拟ReentrantLock加锁过程
 *      1、以下代码中使用阻塞队列替代ReentranLock中LCH队列；
 *      2、使用静态的Atomic类对象 作为多线程的竞争资源；
 *      3、线程的阻塞和唤醒使用LockSupport.park()和LockSupport.unpark();
 *      4、阻塞的线程对象加入到阻塞队列中，等待被唤醒；
 *      5、当正在执行的线程执行即将结束时，释放资源，并唤醒阻塞队列中的第一个阻塞的线程；
 *不足：
 *      1、该过程类似公平锁，但并非完全是；
 *      2、未能做到集中唤醒，争抢资源；
 *      3、逻辑不严谨；
 * @author: Liu Hualong
 * @created: 2021/04/20 12:24
 */
public class LockTest {

    private static volatile ArrayBlockingQueue<Thread> threads = new ArrayBlockingQueue<>(50);

    private static volatile AtomicInteger flag = new AtomicInteger(0);
    private static String[] names = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};


    public static void main(String[] args) {
       for (int i =5 ;i<24;i++){
           new Thread(() -> {
               waitThread();
           },names[i]).start();
       }
       for (int i =0;i<1000 ; i++){
           new Thread(() -> {
               waitThread();
           },names[i%26]).start();
           try { TimeUnit.MILLISECONDS.sleep(120); } catch (InterruptedException e) { e.printStackTrace(); }
       }
    }

    public static void performBusiness(){
        System.out.println(Thread.currentThread().getName()+"获取到令牌");
        System.out.println(Thread.currentThread().getName()+"开始进行业务数据计算，大概需要500mS");
        try { TimeUnit.MILLISECONDS.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println(Thread.currentThread().getName()+"执行结束");
    }

    public static void waitThread(){
        // 如果标识为0
        int i = flag.get();
        if (i == 0){
            if (!flag.compareAndSet(0,1)){
                System.out.println("-----------------------------------------------------");
                // 添加到队列
                addQueue();
            }
            if (threads.isEmpty()){
                performBusiness();
                flag.set(0);
                try {
                    Thread take = threads.take();
                    LockSupport.unpark(take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    performBusiness();
                    flag.set(0);
                    Thread take = threads.take();
                    System.out.println("线程 "+take.getName()+"被唤醒");
                    LockSupport.unpark(take);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else {
            // 添加到队列
            addQueue();
            waitThread();
        }
    }


    public static void addQueue(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"未获取到令牌添加到队列中");
        threads.add(thread);
        LockSupport.park(thread);
    }








}
