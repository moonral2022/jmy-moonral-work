package com.moonral.work.concurrent.j02;

import lombok.SneakyThrows;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author 江梦原
 * @date 2022-08-17
 */
public class J2_Future implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "J2_Future success...";
    }

    @SneakyThrows
    public static void main(String[] args) {
        FutureTask task = new FutureTask(new J2_Future());
        Thread thread = new Thread(task);
        thread.start();
        System.out.println(task.get());
    }
}
