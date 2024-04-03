package com.leetcode.practice.queue;


import java.lang.reflect.Array;

class CircularQueue<T> {

    private final T[] queue;
    private final int length;
    private int front;
    private int rear;

    private int size;

    @SuppressWarnings("unchecked")
    public CircularQueue(Class<T> objectClass, int size) {
        this.length = size;
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.queue = (T[]) Array.newInstance(objectClass, size);
    }

    public void enQueue(T data) {
        if(size == 0) {
            queue[rear] = data;
            size++;
        } else if(size == length) {
            queue[++rear % length] = data;
            rear %= length;
            front = ++front % length;
        } else {
            queue[++rear % length] = data;
            rear %= length;
            size++;
        }
    }

    public T deQueue() {
        if(size == 0) return null;
        else {
            size--;
            T result = queue[front];
            front = ++front % length;
            return result;
        }
    }

    public T peek() {
        if(size == 0) return null;
        return queue[front];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("CircularQueue[");
        int pointer = front;
        while(pointer != rear) {
            result.append(queue[pointer].toString()).append(",");
            pointer = ++pointer % length;
        }
        result.append(queue[rear].toString()).append("]");
        return result.toString();
    }

}

public class SimpleCircularQueue {
    public static void main(String[] args) {
        CircularQueue<String> queue = new CircularQueue<>(String.class, 4);
        queue.enQueue("A");
        queue.enQueue("B");
        queue.enQueue("C");
        queue.enQueue("D");
        System.out.printf("Queue: %s\t\tSize: %s\t\tPeek: %s\t\t\n", queue, queue.size(), queue.peek());
        queue.enQueue("E");
        queue.enQueue("F");
        queue.enQueue("G");
        System.out.printf("Queue: %s\t\tSize: %s\t\tPeek: %s\t\t\n", queue, queue.size(), queue.peek());
        queue.enQueue("H");
        queue.enQueue("I");
        queue.enQueue("J");
        System.out.printf("Queue: %s\t\tSize: %s\t\tPeek: %s\t\t\n", queue, queue.size(), queue.peek());

        // De Queue
        String ele1 = queue.deQueue();
        System.out.printf("Queue: %s\t\tSize: %s\t\tPeek: %s\t\tElement: %s\n", queue, queue.size(), queue.peek(), ele1);
        String ele2 = queue.deQueue();
        System.out.printf("Queue: %s\t\tSize: %s\t\tPeek: %s\t\tElement: %s\n", queue, queue.size(), queue.peek(), ele2);
        String ele3 = queue.deQueue();
        System.out.printf("Queue: %s\t\tSize: %s\t\tPeek: %s\t\tElement: %s\n", queue, queue.size(), queue.peek(), ele3);
    }
}
