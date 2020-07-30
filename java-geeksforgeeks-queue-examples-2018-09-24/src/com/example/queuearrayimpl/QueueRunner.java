package com.example.queuearrayimpl;

/*
reference: https://www.geeksforgeeks.org/queue-set-1introduction-and-array-implementation/
 */

// Java program for array implementation of queue

// A class to represent a queue
class Queue {

    private int front, rear, size;
    private int capacity;
    private int array[];

    public Queue(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }

    // Queue is full when size becomes equal to the capacity.
    public boolean isFull(Queue q) {
        return q.size == q.capacity;
    }

    public boolean isEmpty(Queue q) {
        return q.size == 0;
    }

    // Method to add an item to the queue.
    // It changes rear and size.
    public void enqueue(int item) {
        if (isFull(this)) return;
        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size = this.size + 1;
        System.out.println(item + " enqueued to queue.");
    }

    // Method to remove an item from the queue.
    // It changes front and size.
    public int dequeue() {
        if (isEmpty(this)) return Integer.MIN_VALUE;

        int item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size - 1;
        return item;
    }

    // Method to get the front of the queue.
    public int front() {
        if (isEmpty(this)) return Integer.MIN_VALUE;
        return this.array[this.front];
    }

    // Method to get the rear of the queue.
    public int rear() {
        if (isEmpty(this)) return Integer.MIN_VALUE;
        return this.array[this.rear];
    }
}


// Driver class
public class QueueRunner {
    public static void main(String[] args) {
        Queue queue = new Queue(1000);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue.dequeue() +
                " dequeued from queue\n");

        System.out.println("Front item is " +
                queue.front());

        System.out.println("Rear item is " +
                queue.rear());

//        System.out.println(5 % 7);
    }
}

// This code is contributed by Gaurav Miglani


