package com.moonral.work.concurrent;

/**
 * 1.volatile为什么能保证及时可见性？
 *
 * MESI缓存一致性协议
 * M: 已修改
 * E：独占
 * S：共享
 * I: 已失效
 * 缓存一致性协议需要用到总线裁决，总线裁决是根据电路的高低来判断的
 *
 * volatile 会加lock前缀。lock前缀触发硬件缓存锁机制（总线锁，缓存一致性协议）
 *
 *
 * 2.happens-before：八大规则
 *
 *
 * @author 江梦原
 * @date 2022-07-13
 */
public class J03_MESI {
    int add(int i, int j){
        return i + j;
    }
    public static void main(String[] args) {
        System.out.println(Math.ceil(-4.7));
    }


}

