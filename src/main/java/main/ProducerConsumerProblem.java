package main;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerProblem {
    public static void main(String[] args) {
        BlockingQueue<String> messageQueue = new ArrayBlockingQueue(10);
        ProducerThread p1 = new ProducerThread(messageQueue);
        ProducerThread p2 = new ProducerThread(messageQueue);
        ConsumerThread c1 = new ConsumerThread(messageQueue);

        p1.start();
        p2.start();
        c1.start();
    }


    private static class ProducerThread extends Thread {
        private final BlockingQueue<String> messageQueue;

        public ProducerThread(BlockingQueue<String> messageQueue) {
            System.out.println("PRODUCER CREATED");
            this.messageQueue = messageQueue;
        }

        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(getName() + " produced " + i);
                    messageQueue.put("Info" + i);
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ConsumerThread extends Thread {
        private final BlockingQueue<String> messageQueue;

        public ConsumerThread(BlockingQueue<String> messageQueue) {
            System.out.println("CONSUMER CREATED");
            this.messageQueue = messageQueue;
        }

        public void run() {
            try {
                Thread.sleep(300);
                while (!messageQueue.isEmpty()) {
                    Thread.sleep(300);
                    System.out.print(String.format("%s consumed %s%n", getName(), messageQueue.take()));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
