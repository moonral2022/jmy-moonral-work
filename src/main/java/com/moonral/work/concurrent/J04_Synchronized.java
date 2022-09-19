package com.moonral.work.concurrent;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1.synchronized:jvm内置锁
 * 用法：1.加在静态方法上 public static synchronized：当前类
 *      2.加在非静态方法上public synchronized： this，当前类实例
 *      3.加在代码块上
 * 2.ReentrantLock：显示锁
 *      可重入，公平性
 * 3.锁升级的过程
 *    偏向锁：同一时间只有一个线程
 *    ->轻量级锁：同一时间只有两个线程，且竞争不激烈
 *    ->重量级锁
 *
 * system.out.println()
 * out是单例的
 * println()方法是同步的，非常影响性能
 * 互斥锁
 *
 * @author 江梦原
 * @date 2022-07-13
 */
@Slf4j
public class J04_Synchronized {
    private static int count = 0;
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static Object object = new Object();

    private static ReentrantLock lock = new ReentrantLock();

    @SneakyThrows
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    for (int j = 0; j < 1000; j++) {
//                        synchronized (object) {
                        try {
                            lock.lock();
                            count++;

                        }finally {
                            lock.unlock();
                        }
//                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
        Thread.sleep(500);
        countDownLatch.countDown();
        Thread.sleep(2000);
        log.info("count = {}", count);
    }


}
