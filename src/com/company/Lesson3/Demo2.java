package com.company.Lesson3;

import java.time.LocalTime;
import java.util.concurrent.*;

public class Demo2 {

    private static class WorkedThread extends Thread {

        public WorkedThread() {
            super(WorkedThread.class.getSimpleName());
        }

        @Override
        public void run() {
            long sum = 0;
            System.out.println(getName() + " run at: " + LocalTime.now());
            for (int i = 0; i < 2_000_000_000; i++) {
                sum += i;
                // Проверить не прерван ли поток
                if (i % 100 == 0 && isInterrupted()) { // Thread.interrupted()
                    System.out.println("Loop interrupted at i = " + i);
                    break;
                }
            }
            System.out.println("End loop for " + getName() + " at: " + LocalTime.now());
        }
    }

    private static class SleeperThread extends Thread {

        public SleeperThread() {

            super(SleeperThread.class.getSimpleName());
        }

        @Override
        public void run() {
            System.out.println(getName() + " run at: " + LocalTime.now());
            // Усыпить на 1000 мс
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Sleep interrupted");
            }


            System.out.println("End " + getName() + " at: " + LocalTime.now());
        }
    }

    public static void main(String[] args) throws Exception {
        //Создать экземпляр класса WorkedThread
        Thread workedThread = new WorkedThread();

        //Создать экземпляр класса SleeperThread
        Thread sleeperThread = new SleeperThread();

        //Запустить потоки
        System.out.println("Starting threads at =" + LocalTime.now());
        workedThread.start();
        sleeperThread.start();
        Thread.sleep(100);


        //Присоединить потоки
        System.out.println("Join threads");
        //workedThread.join();//основной поток ждет выполнения этого потока
        //sleeperThread.join();//основной поток ждет выполнения этого потока
        System.out.println(Thread.currentThread().getName() + " done at =" + LocalTime.now());

        //демоны???
        //workedThread.setDaemon(true);

        //Прервать потоки
        //workedThread.interrupt();
        sleeperThread.interrupt();

    }
}
