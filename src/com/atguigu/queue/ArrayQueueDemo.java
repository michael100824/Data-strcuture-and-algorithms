package com.atguigu.queue;

public class ArrayQueueDemo {
    public static void main(String[] args) {

    }
}

class ArrayQueue {
    private int maxSize; // max size of the array
    private int front; // head of the queue
    private int rear; // tail of the queue
    private int[] arr; // save the data

    // create queue
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }
}