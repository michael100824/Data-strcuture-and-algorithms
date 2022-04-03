package com.atguigu.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        // create a queue
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' '; // receive user's input
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // output a menu
        while (loop) {
            System.out.println("s(show): show the queue");
            System.out.println("e(exit): exit");
            System.out.println("a(add): add data");
            System.out.println("g(get): get data");
            System.out.println("h(head): show the head of the queue");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("Give a number");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("The number get is  %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("The head of the queue is: %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("Exit...");

    }
}

class ArrayQueue {
    private int maxSize; // max size of the array
    private int front; // 指向队列的第一个元素的前一个位置
    private int rear; // 指向队列的最后一个元素
    private int[] arr; // save the data

    // create queue
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; // pointer to one more position ahead of head of the queue (队列头的前一个位置）
        rear = -1; // pointer to tail of the queue (队列最后一个数据)
    }

    // check if the queue is full
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // check if the queue is empty
    public boolean isEmpty() {
        return rear == front;
    }

    // add data to the queue
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("The queue is full...");
            return;
        }
        rear++; // move rear backward
        arr[rear] = n;
    }

    // get data from the queue
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty...");
        }
        front++;// move front backward
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty...");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty...");
        }
        return arr[front + 1];
    }

}