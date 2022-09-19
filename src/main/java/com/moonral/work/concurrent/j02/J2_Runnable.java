package com.moonral.work.concurrent.j02;

/**
 * @author 江梦原
 * @date 2022-08-17
 */
public class J2_Runnable implements Runnable{
    @Override
    public void run() {
        System.out.println("J2_Runnable");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new J2_Runnable());
        thread1.start();
    }
}
