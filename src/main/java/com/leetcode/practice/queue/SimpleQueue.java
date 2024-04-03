package com.leetcode.practice.queue;


class Queues<T> {

    private Node<T> front;
    private Node<T> rear;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.format("Node[%s]", this.data.toString());
        }
    }

    public Queues() {
        front = rear = null;
        size = 0;
    }

    public void enQueue(T data) {
        Node<T> object = new Node<>(data);
        if (size == 0) {
            front = object;
            rear = object;
        } else {
            rear.next = object;
            rear = object;
        }
        size++;
    }

    public T deQueue() {
        if(size == 0) {
            return null;
        }
        Node<T> result = front;
        front = front.next;
        size--;
        return result.data;
    }

    public T peek() {
        if(size == 0) return null;
        return front.data;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Queues[");
        if(size == 0) return "Queue is empty";
        Node<T> pointer = front;
        while(pointer != null) {
            result.append(pointer.toString());
            if(pointer.next == null) result.append("]");
            else result.append(",");
            pointer = pointer.next;
        }
        return result.toString();
    }

}

public class SimpleQueue {
    public static void main(String[] args) {
        Queues<String> queue = new Queues<>();
        queue.enQueue("A");
        queue.enQueue("B");
        queue.enQueue("C");
        queue.enQueue("D");
        System.out.println("Enqueued Queue: " + queue.toString());
        String ele1 = queue.deQueue();
        System.out.printf("Dequeued element: %s\t\tPeek Element:%s\t\tSize: %s\t\tQueue: %s%n", ele1, queue.peek(), queue.size(), queue.toString());
        String ele2 = queue.deQueue();
        System.out.printf("Dequeued element: %s\t\tPeek Element:%s\t\tSize: %s\t\tQueue: %s%n", ele2, queue.peek(), queue.size(), queue.toString());
        String ele3 = queue.deQueue();
        System.out.printf("Dequeued element: %s\t\tPeek Element:%s\t\tSize: %s\t\tQueue: %s%n", ele3, queue.peek(), queue.size(), queue.toString());
        String ele4 = queue.deQueue();
        System.out.printf("Dequeued element: %s\t\tPeek Element:%s\t\tSize: %s\t\tQueue: %s%n", ele4, queue.peek(), queue.size(), queue.toString());
    }
}
