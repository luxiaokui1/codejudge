package com.codejudge.sandbox.unsafe;

/**
 * 鏃犻檺鐫＄湢锛堥樆濉炵▼搴忔墽琛岋級
 */
public class SleepError {

    public static void main(String[] args) throws InterruptedException {
        long ONE_HOUR = 60 * 60 * 1000L;
        Thread.sleep(ONE_HOUR);
        System.out.println("鐫″畬浜?);
    }
}

