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

    public int headQueue(){
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty...");
        }
        return  arr[front+1];
    }

}