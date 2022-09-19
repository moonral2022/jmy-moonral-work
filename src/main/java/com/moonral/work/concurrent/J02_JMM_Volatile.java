package com.moonral.work.concurrent;

import lombok.extern.slf4j.Slf4j;

/**
 * 并发编程之JMM & volatile详解
 *
 * @author 江梦原
 * @date 2022-07-12
 */
@Slf4j
public class J02_JMM_Volatile {
    /**
     * JMM不同于JVM的内存模型
     *
     * 原子性 - volatile，
     * 有序性 - synchronized，
     * 可见性，
     */

    /**
     * JMM内存模型
     *
     * JIT
     *
     * 数据同步8大原子操作
     * lock
     * unlock
     * read
     * load
     * user
     * assign
     * store
     * write
     *
     *
     *
     * @param args
     */


    /**
     * volatile 可以解决可见性问题（及时性）
     *
     * 不加volatile
     * count 定义为Integer 可以看到
     * count 定义为 int 不可以看到
     * 不加count，while循环中加一行日志，可以看到
     * 总结：变量在不同的线程中可见，但是无法及时看见，volatile能保证及时性
     *
     */
    public static boolean initFlag = false;
    public static int count = 0;

    public static void main(String[] args) {
        Thread threadA = new Thread(() ->{
            while (!initFlag){
                count++;
//                log.info("========{}",count);
            }
            log.info("当前线程：" + Thread.currentThread().getName() +"感知到initialFlag发生了变化,initflag:" + initFlag);
        }, "threadA");
        threadA.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
           log.error("error");
        }

        Thread threadB = new Thread(()->{
            refresh();
        }, "threadB");
        threadB.start();

    }

    public static void refresh(){
        log.info("refresh data......");
        initFlag = true;
        log.info("refresh data success......");
    }
}
