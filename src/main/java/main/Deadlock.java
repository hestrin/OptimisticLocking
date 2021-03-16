package main;

public class Deadlock {

    public static void main(String[] args) {
        Object res1 = new Object();
        Object res2 = new Object();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (res1) {
                    System.out.println("Resource 1 locked by " + getName());
                    synchronized (res2){
                        System.out.println("Resource 2 locked by " + getName());
                    }
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(101);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (res2) {
                    System.out.println("Resource 2 locked by " + getName());
                    synchronized (res1){
                        System.out.println("Resource 1 locked by " + getName());
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
