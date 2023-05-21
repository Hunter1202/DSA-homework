package Bai1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LinkedBinaryTree<E,T> implements BinaryTreeInterface<T> {
    public static class Node<E> {
        private E element;
        public Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild){
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }
    }

    private Node<E> root;
    private int size;

    public LinkedBinaryTree(){
        root = null;
        size = 0;
    }

    public Node<E> validate(T p) throws IllegalArgumentException {
        if(!(p instanceof Node)){
            throw new IllegalArgumentException ("Vị trí không hợp lệ");
        }
        Node<E> node = (Node<E>) p;
        if (node.parent == node){
            throw new IllegalArgumentException ("p không có ở trong tree");
        }
        return node;
    }

    public T root(){
        return (T) root;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int numChildren(T p) throws IllegalArgumentException  {
        Node<E> node = validate(p);
        int count = 0;
        if (node.left != null){
            count++;
        }
        if (node.right != null){
            count++;
        }
        return count;
    }

    public T parent(T p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return (T) node.parent;
    }

    public T left(T p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return (T) node.left;
    }

    public T right(T p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return (T) node.right;
    }

    public T sibling(T p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> parent = node.parent;
        if(parent == null){
            return null;
        }
        if(node == parent.left){
            return (T) parent.right;
        } else {
            return (T) parent.left;
        }
    }

    public Node<E> addRoot(E element) throws IllegalStateException{
        // Add element to root of an empty tree
        if(!isEmpty()){
            throw new IllegalStateException("Tree is not empty");
        }
        root = new Node<>(element, null, null, null);
        size = 1;
        return root;
    }

    public Node<E> addLeft(T p, E element) throws IllegalArgumentException{
        // Add element to left child node of p if empty
        Node<E> parent = validate(p);
        if(parent.left != null){
            throw new IllegalArgumentException("p already has left child");
        }
        Node<E> child = new Node<>(element, parent, null, null);
        parent.left = child;
        size++;
        return child;
    }

    public Node<E> addRight(T p, E element) throws IllegalArgumentException{
        // Add element to right child node of p if empty
        Node<E> parent = validate(p);
        if(parent.right != null){
            throw new IllegalArgumentException("p already has right child");
        }
        Node<E> child = new Node<>(element, parent, null, null);
        parent.right = child;
        size++;
        return child;
    }

    public void set(T p, E element) throws IllegalArgumentException {
        // set element to node p
        Node<E> node = validate(p);
        node.element = element;
    }

    // use a recursive approach to traverse the tree and print each node
    // at its appropriate level with appropriate spacing.
    private void printTree(Node<E> node, int level) {
        if (node == null) {
            return;
        }

        //The printTree method is a simple wrapper that starts the recursive traversal at the root node.
        // The printSubtree method recursively visits the right subtree first,
        // then prints the current node with appropriate indentation based on the level of the node,
        // and finally visits the left subtree. The spacing between nodes is 4 spaces,
        // which can be adjusted as needed.

        printTree(node.right, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.getElement());
        printTree(node.left, level + 1);
    }

    public void printTree() {
        printTree(root, 0);
    }

    private void printHorizontalTreeToFile(Node<E> node, String prefix, PrintWriter writer) {
        if (node == null) {
            return;
        }
        printHorizontalTreeToFile(node.getRight(), prefix + "     ", writer);
        writer.println(prefix + "--" + node.getElement());
        printHorizontalTreeToFile(node.getLeft(), prefix + "     ", writer);
    }

    public void printHorizontalTreeToFile(String filename) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(filename));
        printHorizontalTreeToFile(root, "", writer);
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        LinkedBinaryTree<Integer, LinkedBinaryTree.Node<Integer>> tree = new LinkedBinaryTree<Integer, Node<Integer>>();
        LinkedBinaryTree.Node<Integer> root = tree.addRoot(1);
        LinkedBinaryTree.Node<Integer> node2 = tree.addLeft(root, 5);
        LinkedBinaryTree.Node<Integer> node3 = tree.addRight(root, 3);
        LinkedBinaryTree.Node<Integer> node4 = tree.addLeft(node2, 8);
        LinkedBinaryTree.Node<Integer> node5 = tree.addRight(node2, 6);
        LinkedBinaryTree.Node<Integer> node6 = tree.addLeft(node3, 2);
        LinkedBinaryTree.Node<Integer> node7 = tree.addRight(node3, 7);
        tree.printTree();

        tree.printHorizontalTreeToFile("C:\\Users\\Truc\\Desktop\\tree.txt");

    }
}
