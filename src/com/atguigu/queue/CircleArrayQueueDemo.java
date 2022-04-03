package com.atguigu.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        // create a queue
        CircleArray queue = new CircleArray(4); // 设置为4，其队列有效数据最大为3
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


class CircleArray {
    private int maxSize; // max size of the array
    private int front; // 指向队列的第一个元素
    private int rear; // 指向队列的最后一个元素的后一个位置
    private int[] arr; // save the data


    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0; // pointer to one more position ahead of head of the queue (队列头的前一个位置）
        rear = 0; // pointer to tail of the queue (队列最后一个数据)
    }

    // check if the queue is full
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        arr[rear] = n;
        // move rear backward, considering mole
        rear = (rear + 1) % maxSize;
    }

    // get data from the queue
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty...");
        }
        // 1. save the front value to a temp var
        // 2. move backward front
        // 3. return temp var
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty...");
            return;
        }
        // go through from front
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // get the # of valid value in the queue
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty...");
        }
        return arr[front];
    }
}