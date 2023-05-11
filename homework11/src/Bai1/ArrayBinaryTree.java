package Bai1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ArrayBinaryTree<E,T> implements BinaryTreeInterface<T> {
    private E[] array;
    private int n = 0;
    private int defaultsize = 100;
    private E element;

    public ArrayBinaryTree(){
        array = (E[]) new Object[defaultsize];
    }

    // get the index of parent, left, and right child nodes
    private int parent(int p) {
        return p/2;
    }

    private int left(int p) {
        return 2*p;
    }

    private int right(int p) {
        return 2*p + 1;
    }

    // Update methods
    public void setRoot(E element) {
        if(isEmpty()) {
            n = 1;
            array[1] = element;
        } else {
            array[1] = element;
        }
    }

    public void setLeft(int p, E element) {
        int index = p;
        if(left(index) >= array.length) {
            resize();
        }
        if(array[index] == null) {
            throw new IllegalArgumentException("Cannot set the left child of a null node.");
        }
        array[left(index)] = element;
        n++;
    }

    public void setRight(int p, E element) {
        int index = p;
        if(right(index) >= array.length) {
            resize();
        }
        if(array[index] == null) {
            throw new IllegalArgumentException("Cannot set the right child of a null node.");
        }
        array[right(index)] = element;
        n++;
    }

    // resizing the array when it's full
    private void resize() {
        E[] newArray = (E[]) new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    // Interface methods
    @Override
    public T root() {
        if(isEmpty()) {
            return null;
        } else {
            return (T) Integer.valueOf(1);
        }
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int numChildren(T p) {
        int count = 0;
        int index = (int) p;
        if(left(index) < array.length && array[left(index)] != null) {
            count++;
        }
        if(right(index) < array.length && array[right(index)] != null) {
            count++;
        }
        return count;
    }

    @Override
    public T parent(T p) {
        int index = (int) p;
        if(index == 1) {
            return null;
        } else {
            return (T) Integer.valueOf(parent(index));
        }
    }

    @Override
    public T left(T p) {
        int index = (int) p;
        if(left(index) >= array.length || array[left(index)] == null) {
            return null;
        } else {
            return (T) Integer.valueOf(left(index));
        }
    }

    @Override
    public T right(T p) {
        int index = (int) p;
        if(right(index) >= array.length || array[right(index)] == null) {
            return null;
        } else {
            return (T) Integer.valueOf(right(index));
        }
    }

    @Override
    public T sibling(T p) {
        int index = (int) p;
        if(index == 1 || numChildren(parent(p)) < 2) {
            return null;
        } else if(index % 2 == 0) {
            // p is the left child
            return (T) Integer.valueOf(right(index));
        } else {
            // p is the right child
            return (T) Integer.valueOf(left(index));
        }
    }

    //get value of index
    public E getElement(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= defaultsize) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return array[index];
    }

    public void printTree(T node, int level) {
        if (node == null) {
            return;
        }
        printTree(right(node), level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        System.out.println(getElement((Integer) node));
        printTree(left(node), level + 1);
    }

    public void printTreeToFile(T node, int level, BufferedWriter writer) throws IOException {
        if (node == null) {
            return;
        }
        printTreeToFile(right(node), level + 1, writer);
        for (int i = 0; i < level; i++) {
            writer.write("   ");
        }
        writer.write(node.toString() + "\n");
        printTreeToFile(left(node), level + 1, writer);
    }


    public static void main(String[] args) throws IOException {
        ArrayBinaryTree<Integer, Integer> tree = new ArrayBinaryTree<>();
        tree.setRoot(1);
        tree.setLeft(1, 5);
        tree.setRight(1, 3);
        tree.setLeft(2, 8);
        tree.setRight(2, 6);
        tree.setLeft(3, 2);
        tree.setRight(3, 7);
        tree.printTree(tree.root(), 0);

        String fileName = "C:\\Users\\Truc\\Desktop\\tree.txt";
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        tree.printTreeToFile(tree.root(), 0, writer);
        writer.close();
    }
}

