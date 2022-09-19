package com.moonral.work.concurrent.j02;

import lombok.SneakyThrows;

/**
 * @author 江梦原
 * @date 2022-08-17
 */

public class J2_Thread {


    @SneakyThrows
    public static void main(String[] args) {
        Thread thread1 = new Thread(){
            @Override
            public void run(){
                System.out.println("J2_Thread_1");
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run(){
                System.out.println("J2_Thread_2");
            }
        };
        Thread thread3 = new Thread(){
            @Override
            public void run(){
                System.out.println("J2_Thread_3");
            }
        };
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
    }



}
