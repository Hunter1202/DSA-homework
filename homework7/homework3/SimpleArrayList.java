package homework3;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    //Thêm phần tử vào danh sách
    public void add(T data) {
        if (n >= array.length) {
            resizeArray();
        }
        array[n++] = data;
    }

    //Lấy giá trị phần tử thứ i
    public T get(int i) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }
        return array[i];
    }

    //Đặt data vào vị trí i của danh sách
    public void set(int i, T data) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }
        array[i] = data;
    }

    //Loại phần tử data khỏi danh sách
    public void remove(T data) {
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < n - 1; i++) {
                array[i] = array[i + 1];
            }
            array[--n] = null;
        }
    }

    //Kiểm tra phần tử data có trong danh sách
    public void isContain(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                System.out.println("The list contains the element.");
                return;
            }
        }
        System.out.println("The list does not contain the element.");
    }

    //Kích thước danh sách
    public int size() {
        return n;
    }

    //Danh sách có rỗng hay không
    public boolean isEmpty() {
        return n == 0;
    }

    //helper method
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            public boolean hasNext() {
                return currentIndex < n;
            }

            public T next() {
                return array[currentIndex++];
            }
        };
    }

    private void resizeArray() {
        T[] newArray = (T[]) new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, n);
        array = newArray;
    }

    @Override
    public String toString() {
        return "SimpleArrayList{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
