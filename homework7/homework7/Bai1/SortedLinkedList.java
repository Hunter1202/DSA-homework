package homework7.Bai1;

import homework3.SimpleLinkedList;

public class SortedLinkedList<T extends Comparable<T>> extends SimpleLinkedList<T> {
    @Override
    public void add(T data) {
        Node newNode = new Node();
        newNode.data = data;

        if (top == null) {
            top = newNode;
            bot = newNode;
        } else {
            if (data.compareTo(top.data) < 0) {
                newNode.next = top;
                top = newNode;
            } else {
                Node current = top;
                while (current.next != null && data.compareTo(current.next.data) >= 0) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
                if (current == bot) {
                    bot = newNode;
                }
            }
        }
        n++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = top;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

}
