package com.example.admin.codingexersice;

public class LevelOrderQueue<T> {

    private static class Node<T> {

        T data;
        Node next;

        public Node(T data) {
            this(data, null);
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LevelOrderQueue() {
        this.head = null;
        this.tail = null;
    }

    public int size() {
        return size;
    }

    public void enqueue(T data) {
        if(data == null)
            return;

        if(head == null)
            head = tail = new Node(data);
        else {
            tail.next = new Node(data);
            tail = tail.next;
        }

        size++;
    }

    public T dequeue() {

        if(tail != null) {
            T temp = (T) head.data;
            head = head.next;

            size--;

            return temp;
        }

        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
