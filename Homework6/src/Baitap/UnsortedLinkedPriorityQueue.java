package Baitap;

public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

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

        public NodeEntry<K, E> getNext() {return next;}

        public String toString() {
            return "(" + key + ", " + element + ")";
        }
    }

    private NodeEntry<K,E> head;
    private NodeEntry<K,E> tail;
    private int n;

    public UnsortedLinkedPriorityQueue() {
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

    public void insert(Entry<K, E> entry) {
        insert(entry.getKey(), entry.getValue());
    }


    public Entry<K,E> removeMin() {
        if (isEmpty()) {
            return null;
        }
        NodeEntry<K,E> minNode = head;
        NodeEntry<K,E> prevNode = null;
        NodeEntry<K,E> currentNode = head.next;
        NodeEntry<K,E> prevMinNode = null;
        while (currentNode != null) {
            if (currentNode.getKey().compareTo(minNode.getKey()) < 0) {
                prevMinNode = prevNode;
                minNode = currentNode;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        if (prevMinNode == null) {
            head = head.next;
        } else {
            prevMinNode.next = minNode.next;
        }
        if (minNode == tail) {
            tail = prevMinNode;
        }
        n--;
        return minNode;
    }

    public Entry<K,E> min() {
        if (isEmpty()) {
            return null;
        }
        NodeEntry<K,E> minNode = head;
        NodeEntry<K,E> currentNode = head.next;
        while (currentNode != null) {
            if (currentNode.getKey().compareTo(minNode.getKey()) < 0) {
                minNode = currentNode;
            }
            currentNode = currentNode.next;
        }
        return minNode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        NodeEntry<K,E> currentNode = head;
        while (currentNode != null) {
            sb.append(currentNode.toString());
            currentNode = currentNode.next;
            if (currentNode != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

