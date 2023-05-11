package Bai1;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E>, Iterable<E>{
    class Node {
        E element;
        Node next;

        public Node(E element, Node next){
            this.element = element;
            this.next = next;
        }
    }

    private Node stack;
    private int size;

    public LinkedListStack(){
        stack = null;
        size = 0;
    }

    @Override
    public void push(E element) {
        Node node = new Node(element, stack);
        stack = node;
        size++;
    }

    @Override
    public E pop() {
        if(isEmpty()) return null;
        E answer = stack.element;
        stack = stack.next;
        size--;
        return answer;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E top() {
        if(isEmpty()) return null;
        return stack.element;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }
    class StackIterator implements Iterator<E>{
        private Node currentNode = stack;

        @Override
        public boolean hasNext(){
            return currentNode != null;
        }

        @Override
        public E next(){
            E data = currentNode.element;
            currentNode = currentNode.next;
            return data;
        }
    }
}
