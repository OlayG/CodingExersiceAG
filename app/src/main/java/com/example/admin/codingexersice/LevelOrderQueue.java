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

    /**
     *
     * @return size of Queue
     */
    public int size() {
        return size;
    }

    /**
     * Adds data to Queue
     *
     * @param data
     */
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

    /**
     * Removes data from Queue
     *
     * @return new Queue or Null if empty
     */
    public T dequeue() {

        if(tail != null) {
            T temp = (T) head.data;
            head = head.next;

            size--;

            return temp;
        }

        return null;
    }

    /**
     * Checks if Queue is empty
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
