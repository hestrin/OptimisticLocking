package main;

import collections.Node;
import collections.SinglyLinkedList;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> System.out.println("Something to print 1"));
        executorService.submit(()-> 5);
        executorService.execute(() -> System.out.println("Something to print 2"));
        executorService.execute(() -> System.out.println("Something to print 3"));
        executorService.shutdown();
        System.out.println("Hello world!!");
//
//        SinglyLinkedList list = new SinglyLinkedList(4);
//
//        Node currentNode = list.getFirst();
//        Node middleNode = list.getFirst();
//        int i = 0;
//        while (currentNode != null) {
//            System.out.println(currentNode.getName());
//            currentNode = currentNode.getNext();
//            if(i%2 == 0)
//                middleNode = middleNode.getNext();
//            i++;
//        }
//        System.out.println(String.format("Middle node is %s", middleNode.getName()));
    }

    public static int fibonacci(int n){
        if(n < 0)
            throw new IllegalArgumentException();

        if(n < 2)
            return 1;

        int[] memory = new int[n+1];
        memory[0] = 1;
        memory[1] = 1;

        for(int i=2; i<n+1; i++)
            memory[i] = memory[i-1] + memory[i-2];
//        return fibonacci(n-1) +  fibonacci(n-2);
        return memory[n];
    }
}
