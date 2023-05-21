package homework7.Bai1;

import homework3.SimpleArrayList;
import homework3.SimpleLinkedList;

public class SortAlgorithm {
    //Linear Search
    public static <T> int linearSearchArray(T[] array, T key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(key)) {
                return i;
            }
        }
        return -1; // Not Found
    }

    public static <T> int linearSearchLinkedList(SimpleLinkedList<T> list, T key) {
        SimpleLinkedList.Node current = list.top;
        int index = 0;
        while (current != null) {
            if (current.data.equals(key)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1; // Not Found
    }

    //Binary Search

    public static <T extends Comparable<T>> int binarySearchArray(T[] array, T key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = array[mid].compareTo(key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // Tìm thấy
            }
        }
        return -1; // Not Found
    }

    public static <T extends Comparable<T>> int binarySearchLinkedList(SimpleLinkedList<T> list, T key) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            T midValue = list.get(mid);
            int cmp = midValue.compareTo(key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // Tìm thấy
            }
        }
        return -1; // Not Found
    }

    //Bubble Sort
    public static <T extends Comparable<T>> void bubbleSortArray(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void bubbleSortLinkedList(SimpleLinkedList<T> list) {
        int n = list.size();
        if (n <= 1) {
            return; // Không cần sắp xếp
        }

        boolean swapped;
        SimpleLinkedList.Node current;
        SimpleLinkedList.Node previous = null;

        do {
            swapped = false;
            current = list.top;

            while (current.next != previous) {
                T currentValue = (T) current.data;
                T nextValue = (T) current.next.data;

                if (currentValue.compareTo(nextValue) > 0) {
                    // Hoán đổi giá trị của hai phần tử
                    current.data = nextValue;
                    current.next.data = currentValue;
                    swapped = true;
                }

                current = current.next;
            }

            previous = current;
        } while (swapped);
    }

    public static void main(String[] args) {
        SimpleArrayList<Integer> arrayList = new SimpleArrayList<>();
        SimpleLinkedList<String> linkedList = new SimpleLinkedList<>();

        arrayList.add(10);
        linkedList.add("aaaa");

        Integer value1 = arrayList.get(0);
        String value2 = linkedList.get(0);

        arrayList.set(0, 20);
        linkedList.set(0, "bbbbb");

        arrayList.remove(20);
        linkedList.remove("ccccc");

        int size1 = arrayList.size();
        int size2 = linkedList.size();

        System.out.println(arrayList);
        System.out.println();
        System.out.println(linkedList);
    }
}
