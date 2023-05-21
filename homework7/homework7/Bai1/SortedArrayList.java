package homework7.Bai1;

import homework3.SimpleArrayList;

import java.util.Arrays;

public class SortedArrayList<T extends Comparable<T>> extends SimpleArrayList<T> {

    private T[] array;
    private int n = 0;

    public SortedArrayList() {
        super();
    }

    public SortedArrayList(int capacity) {
        super(capacity);
    }

    @Override
    public void add(T data) {
        if (isEmpty() || data.compareTo(array[n - 1]) >= 0) {
            super.add(data);
        } else {
            int i;
            for (i = 0; i < n; i++) {
                if (data.compareTo(array[i]) <= 0) {
                    break;
                }
            }
            for (int j = n; j > i; j--) {
                array[j] = array[j - 1];
            }
            array[i] = data;
            n++;
        }
    }

//    @Override
//    public void set(int i, T data) {
//        throw new UnsupportedOperationException("Cannot directly set elements in a SortedSimpleArrayList.");
//    }
//
//    @Override
//    public void remove(T data) {
//        throw new UnsupportedOperationException("Cannot directly remove elements from a SortedSimpleArrayList.");
//    }
//
//    @Override
//    public void isContain(T data) {
//        throw new UnsupportedOperationException("Cannot directly search for elements in a SortedSimpleArrayList.");
//    }
    @Override
    public String toString() {
        return "SimpleArrayList{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
