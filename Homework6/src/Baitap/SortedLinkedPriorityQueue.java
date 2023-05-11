package Baitap;

public class SortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

    protected class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        private NodeEntry<K, E> next;

        public NodeEntry(K k, E e) {
            key = k;
            element = e;
            next = null;
        }

        public K getKey() {
            return key;
        }
        public E getValue() {
            return element;
        }

        public void setNext(NodeEntry<K, E> node) {
            next = node;
        }

        public NodeEntry<K, E> getNext() {
            return next;
        }

        public String toString() {
            return "(" + key + ", " + element + ")";
        }
    }

    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;
    private int n;

    public SortedLinkedPriorityQueue() {
        head = null;
        tail = null;
        n = 0;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(Entry<K, E> entry) {
        K k = entry.getKey();
        E e = entry.getValue();
        NodeEntry<K, E> newEntry = new NodeEntry<>(k, e);
        if (isEmpty()) {
            head = newEntry;
            n++;
            return;
        }
        NodeEntry<K, E> current = head;
        NodeEntry<K, E> previous = null;
        while (current != null && k.compareTo(current.getKey()) > 0) {
            previous = current;
            current = current.getNext();
        }
        if (previous == null) {
            newEntry.setNext(head);
            head = newEntry;
        } else {
            newEntry.setNext(current);
            previous.setNext(newEntry);
        }
        n++;
    }

    @Override
    public void insert(K k, E e) {
        NodeEntry<K, E> entry = new NodeEntry<>(k, e);
        if (isEmpty()) {
            head = tail = entry;
        } else if (k.compareTo(head.getKey()) < 0) {
            entry.next = head;
            head = entry;
        } else {
            NodeEntry<K, E> curr = head;
            while (curr.next != null && k.compareTo(curr.next.getKey()) > 0) {
                curr = curr.next;
            }
            entry.next = curr.next;
            curr.next = entry;
            if (entry.next == null) {
                tail = entry;
            }
        }
        n++;
    }

    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }
        Entry<K, E> minEntry = new NodeEntry<>(head.getKey(), head.getValue());
        head = head.getNext();
        n--;
        return minEntry;
    }

    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }
        Entry<K, E> minEntry = new NodeEntry<>(head.getKey(), head.getValue());
        return minEntry;
    }
}
