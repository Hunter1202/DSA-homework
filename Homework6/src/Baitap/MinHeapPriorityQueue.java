package Baitap;

public class MinHeapPriorityQueue<K extends Comparable<K>, E> extends SortedArrayPriorityQueue<K, E> {
    private ArrEntry<K, E>[] heapPQ;

    public MinHeapPriorityQueue() {
        super();
        heapPQ = new ArrEntry[defaultSize + 1];
    }

    public MinHeapPriorityQueue(int capacity) {
        super(capacity);
        heapPQ = new ArrEntry[capacity + 1];
    }

    // additional methods
    protected void upHeap(int i) {
        if (i > 1 && compare(heapPQ[i].key, heapPQ[parent(i)].key) < 0) {
            swap(i, parent(i));
            upHeap(parent(i));
        }
    }

    protected void downHeap(int i) {
        int child = left(i);
        if (child <= size()) {
            if (child < size() && compare(heapPQ[child + 1].key, heapPQ[child].key) < 0)
                child++;
            if (compare(heapPQ[child].key, heapPQ[i].key) < 0) {
                swap(i, child);
                downHeap(child);
            }
        }
    }

    private int parent(int i) {
        return i / 2;
    }

    private int left(int i) {
        return 2 * i;
    }

    private int right(int i) {
        return 2 * i + 1;
    }

    private void swap(int i, int j) {
        ArrEntry<K, E> temp = heapPQ[i];
        heapPQ[i] = heapPQ[j];
        heapPQ[j] = temp;
    }

    private int compare(K k1, K k2) {
        return k1.compareTo(k2);
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(Entry<K, E> entry) {
        if (n == heapPQ.length - 1) {
            System.out.println("Priority queue is full.");
            return;
        }
        n++;
        heapPQ[n] = (ArrEntry<K, E>) entry;
        upHeap(n);
    }

    public void insert(K key, E element) {
        insert(new ArrEntry<K, E>(key, element));
    }

    public Entry<K, E> min() {
        if (isEmpty())
            return null;
        return heapPQ[1];
    }

    public Entry<K, E> removeMin() {
        if (isEmpty())
            return null;
        Entry<K, E> min = heapPQ[1];
        heapPQ[1] = heapPQ[n];
        heapPQ[n] = null;
        n--;
        downHeap(1);
        return min;
    }
}
