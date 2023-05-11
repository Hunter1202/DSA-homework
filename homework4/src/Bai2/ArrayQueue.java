package Bai2;


import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E>, Iterable<E> {
    private E[] queue;
    private int n = 0;
    private int top = 0; //the first element of the queue (assuming the queue is not empty)
    private int count = 0;
    private int default_size = 100;


    public ArrayQueue(int capacity){
        n = capacity;
        queue = (E[]) new Object[capacity];
    }

    public ArrayQueue(){
        n = default_size;
        queue = (E[]) new Object[default_size];
    }

    public int size() {return default_size;}

    @Override
    public void enqueue(E e) throws IllegalStateException {
        if (default_size == queue.length) throw new IllegalStateException("Queue is full");
        int avail = (top + default_size)  % queue.length;       //Adding elements with enqueue method
        queue[avail] = e;
        default_size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            return null;
        E answer = queue[top];
        queue[top] = null;
        top = (top + 1) % queue.length;                         //Removing element with dequeu method
        default_size--;
        return answer;
    }

    @Override
    public boolean isEmpty() {
        return (default_size == 0);
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }

    class ArrayQueueIterator implements Iterator<E> {
        private int current = top;
        private int num = 0;

        @Override
        public boolean hasNext(){
            return num < count;
        }

        @Override
        public E next(){
            E data = queue[(current + num) % n];
            num++;
            return data;
        }
    }
}
