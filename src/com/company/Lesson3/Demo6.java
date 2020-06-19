package com.company.Lesson3;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Demo6 {

    static class Player extends Thread {
        //Semaphore semaphore;
        CountDownLatch countDownLatch;

        public Player(String name, /*Semaphore semaphore*/ CountDownLatch countDownLatch) {
            super(name);
            // this.semaphore = semaphore;
            this.countDownLatch = countDownLatch;
            start();
        }

        @Override
        public void run() {


            System.out.println("Player " + getName() + "isReady");


            try {
                //semaphore.acquire();
                countDownLatch.await(3, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            countDownLatch.countDown();

            System.out.println(getName() + "isStarting");


//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            //semaphore.release();

        }
    }


    // Synchronization demo
    public static void main(String[] args) {
        //Semaphore semaphore = new Semaphore(3);
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Player("one", countDownLatch);
        new Player("two", countDownLatch);
        new Player("three", countDownLatch);
        new Player("four", countDownLatch);
        new Player("five", countDownLatch);
        new Player("six", countDownLatch);
    }
}
