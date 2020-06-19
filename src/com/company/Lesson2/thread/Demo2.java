package com.company.Lesson2.thread;

import java.time.LocalTime;
import java.util.concurrent.Future;

public class Demo2 {
    public static class WorkedThread extends Thread {

        public WorkedThread() {
            super(WorkedThread.class.getSimpleName());
        }

        @Override
        public void run() {
            System.out.println("Loop start = " + getName() + "run at " + LocalTime.now());
            long sum = 0;
            for (int i = 0; i < 2_000_000_000; i++) {
                sum += i;
                //проверяем не прерван ли поток
                if (i % 100 == 0 && isInterrupted()) {
                    System.out.println("Loop is interrupted " + i);
                    break;
                }
            }
            System.out.println("End loop for = " + getName() + " at " + LocalTime.now());
        }
    }


    public static class SleepThread extends Thread {

        public SleepThread() {
            super(SleepThread.class.getSimpleName());
        }

        @Override
        public void run() {
            System.out.println("Start sleep = " + getName() + "run at " + LocalTime.now());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println("End sleep = " + getName() + " at " + LocalTime.now());
        }
    }
}
