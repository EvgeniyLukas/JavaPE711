package com.company.Lesson3;


public class Demo5 {
    static class Friend {
        private String name;


        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public synchronized void seyHi(Friend friend) {
            System.out.println("Hi " + this.name + " " + friend.getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hiBack(friend);
        }

        public synchronized void hiBack(Friend friend) {
            System.out.println("Back " + this.name + " " + friend.getName());
            seyHi(friend);
        }

        public static void main(String[] args) {
            Friend petr = new Friend("Петр");
            Friend ivan = new Friend("Иван");

            new Thread(() -> petr.seyHi(ivan)).start();
            new Thread(() -> ivan.seyHi(petr)).start();
        }
    }
}