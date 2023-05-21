package homework3;

public class SimpleLinkedList<T> {
    public class Node {
        public T data;
        public Node next;
    }

    public Node top = null;
    public Node bot = null;
    public int n = 0;

    public void add(T data) {
        Node newNode = new Node();
        newNode.data = data;

        if (top == null) {
            top = newNode;
            bot = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }

        n++;
    }

    public void addBot(T data) {
        Node newNode = new Node();
        newNode.data = data;

        if (bot == null) {
            top = newNode;
            bot = newNode;
        } else {
            bot.next = newNode;
            bot = newNode;
        }

        n++;
    }

    public T get(int i) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }

        Node current = top;
        for (int j = 0; j < i; j++) {
            current = current.next;
        }

        return current.data;
    }

    public void set(int i, T data) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }

        Node current = top;
        for (int j = 0; j < i; j++) {
            current = current.next;
        }

        current.data = data;
    }

    public boolean isContain(T data) {
        Node current = top;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public T removeTop() {
        if (top == null) {
            throw new IllegalStateException("The list is empty.");
        }

        T removedData = top.data;
        top = top.next;
        if (top == null) {
            bot = null;
        }
        n--;

        return removedData;
    }

    public T removeBot() {
        if (bot == null) {
            throw new IllegalStateException("The list is empty.");
        }

        T removedData = bot.data;
        if (top == bot) {
            top = null;
            bot = null;
        } else {
            Node current = top;
            while (current.next != bot) {
                current = current.next;
            }
            current.next = null;
            bot = current;
        }
        n--;

        return removedData;
    }

    public void remove(T data) {
        Node current = top;
        Node prev = null;

        while (current != null) {
            if (current.data.equals(data)) {
                if (prev == null) {
                    top = current.next;
                } else {
                    prev.next = current.next;
                }
                if (current == bot) {
                    bot = prev;
                }
                n--;
            } else {
                prev = current;
            }
            current = current.next;
        }
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
