//package com.moonral.work.concurrent;
//
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.objenesis.instantiator.sun.UnsafeFactoryInstantiator;
//import sun.misc.Unsafe;
//
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.CyclicBarrier;
//import java.util.concurrent.locks.LockSupport;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * 抽象队列同步器AQS应用lock详解
// *
// * synchronized的优化
// * 锁的膨胀升级
// * 锁粗化：多个同步代码块的内容放到同一个代码块
// * 锁消除：
// * 自旋锁：
// *
// * 对象逃逸分析，变量替换
// *
// * ReentrantLock 基于AQS实现
// *
// * LockSupport.park()  阻塞
// * LockSupport.unPark() 唤醒
// *
// * lock的3大核心原理
// *
// *
// *
// * @author 江梦原
// * @date 2022-07-13
// */
//@Slf4j
//public class J05_AQS {
//
//
//    /**
//     * LockSupport.park();
//     * LockSupport.unpark();
//     * @param args
//     */
//    private static int count = 0;
//    private static CountDownLatch countDownLatch = new CountDownLatch(1);
//    private static Object object = new Object();
//
//    private static ReentrantLock lock = new ReentrantLock();
//
//
////    @SneakyThrows
////    public static void main(String[] args) {
////
////        Thread t0 = new Thread(new Runnable() {
////            @Override
////            public void run() {
////                Thread current = Thread.currentThread();
////                log.info("start execute:{}",current.getName());
////                while(true){
////                    log.info("start park thread:{}",current.getName());
////                    LockSupport.park();
////                    log.info("当前线程{}已经被唤醒...",current.getName());
////                }
////            }
////        },"t0");
////
////        t0.start();
////
////        Thread.sleep(2000);
////        log.info("准备唤醒{}线程！",t0.getName());
////        LockSupport.unpark(t0);
////
////    }
//
//    /**
//     * CAS
//     *
//     * CyclicBarrier 和 countDownLunch
//     */
//    private volatile int state = 0;
//    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
//    private static J05_AQS cas = new J05_AQS();
//
//    public static void main(String[] args) {
//        new Thread(new Worker(),"t-0").start();
//        new Thread(new Worker(),"t-1").start();
//        new Thread(new Worker(),"t-2").start();
//        new Thread(new Worker(),"t-3").start();
//        new Thread(new Worker(),"t-4").start();
//    }
//
//    static class Worker implements Runnable{
//
//        @SneakyThrows
//        @Override
//        public void run() {
//            log.info("请求：{}到达预定点，准备开始抢state",Thread.currentThread().getName());
//            cyclicBarrier.await();
//            if(cas.compareAndSwapState(0,1)){
//                log.info("当前请求：{},抢到锁", Thread.currentThread().getName());
//            }else{
//                log.info("当前请求：{},抢锁失败", Thread.currentThread().getName());
//            }
//
//        }
//    }
//
//    public final boolean compareAndSwapState(int oldValue, int newValue){
//        return unsafe.compareAndSwapInt(this,stateOffSet,oldValue, newValue);
//    }
//
//    private static final Unsafe unsafe = UnsafeInstance.reflectGetUnsafe();
//
//    private static final long stateOffSet;
//
//    static{
//        try {
//            stateOffSet = unsafe.objectFieldOffset(J05_AQS.class.getDeclaredField("state"));
//        } catch (NoSuchFieldException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
