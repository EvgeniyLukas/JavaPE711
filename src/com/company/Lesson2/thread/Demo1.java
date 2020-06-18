package com.company.Lesson2.thread;

import java.util.Comparator;

public class Demo1 {

    static class HelloRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("Hello from Runnable " +
                    Thread.currentThread().getName() + " " +
                    Thread.currentThread().getId());
        }
    }

    static class HelloThread extends Thread {

        public HelloThread() {
        }

        public HelloThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("Hello from Thread " +
                    getName() + " " + getId());
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Runnable hello = new HelloRunnable();

            Thread t1 = new Thread(hello);
            t1.start();

            Thread t2 = new HelloThread();
            t2.start();

            new Thread(()->  System.out.println("Hello from LAMBDA " +
                            Thread.currentThread().getName() + " " +
                            Thread.currentThread().getId())
            ).start();



        }
    }

}
