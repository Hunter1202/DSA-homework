package Bai2;

import java.util.Iterator;

public class LinkedQueue<E> implements QueueInterface<E>, Iterable<E> {
    private Node<E> top;
    private E[] queue;
    private int n = 0;
    private int count = 0;
    private int default_size = 100;

    private static class Node<E> {
        private E[] queue;
        private Node<E> next;

        public Node(E data) {
            this.queue = queue;
            this.next = null;
        }
    }

    public LinkedQueue() {
        n = default_size;
        queue = (E[]) new Object[default_size];
    }

    @Override
    public void enqueue(E e) {
        Node<E> newNode = new Node<>(e);
        if (isEmpty()) {
            top = newNode;
        } else {
            top.next = newNode;
        }
        top = newNode;
        default_size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E answer = (E) top.queue;
        top = top.next;
        default_size--;
        if (isEmpty()) {
            top = null;
        }
        return answer;
    }

    @Override
    public boolean isEmpty() {
        return default_size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedQueueIterator ();
    }

    class LinkedQueueIterator implements Iterator<E> {
        private Node<E> current = top;
        private int num = 0;

        @Override
        public boolean hasNext(){
            return num < count;
        }

        @Override
        public E next(){
            E data = (E) current.queue;
            num++;
            return data;
        }
    }
}
