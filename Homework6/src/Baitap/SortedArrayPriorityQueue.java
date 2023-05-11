package Baitap;

public class SortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

    protected class ArrEntry<K, E> implements Entry<K, E>{
        K key;
        E element;
        public ArrEntry (K k, E e){
            key = k;
            element = e;
        }
        public K getKey(){
            return key;
        }
        public E getValue(){
            return element;
        }
        public String toString() {
            return "(" + key + ", " + element + ")";
        }
    }

    ArrEntry<K, E> [] array;
    int n = 0;
    int defaultSize = 100000;

    public SortedArrayPriorityQueue() {
        array = new ArrEntry[defaultSize];
    }

    public SortedArrayPriorityQueue(int capacity) {
        array = new ArrEntry[capacity];
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        if(n >= array.length){
            throw new IllegalStateException("Queue is full");
        }

        K key = entry.getKey();
        E value = entry.getValue();
        int i = n - 1;
        while (i >= 0 && key.compareTo(array[i].getKey()) < 0) {
            array[i+1] = array[i];
            i--;
        }
        array[i+1] = new ArrEntry<>(key, value);
        n++;
    }

    @Override
    public void insert(K k, E e) {
        if(n >= array.length){
            throw new IllegalStateException("Queue is full");
        }
        ArrEntry<K, E> entry = new ArrEntry<>(k, e);
        int i;
        for(i = n; i > 0 && entry.getKey().compareTo(array[i-1].getKey()) < 0; i--){
            array[i] = array[i-1];
        }
        array[i] = entry;
        n++;
    }

    public Entry<K, E> removeMin() {
        if(isEmpty()){
            return null;
        }
        Entry<K, E> minEntry = array[0];
        for(int i = 1; i < n; i++){
            array[i-1] = array[i];
        }
        array[n-1] = null;
        n--;
        return minEntry;
    }

    public Entry<K, E> min() {
        if(isEmpty()){
            return null;
        }
        return array[0];
    }
}
