package homework7.Bai4;

import homework5.LinkedBinaryTree;
import homework7.Bai2.BinarySearchTree;

public class BalancedScale<E extends Comparable<E>> extends BinarySearchTree<E> {
    // Rotate left at node x
    protected void rotateLeft(LinkedBinaryTree.Node<E> x) {
        LinkedBinaryTree.Node<E> y = x.getRight();
        x.right = y.getLeft();
        if (y.getLeft() != null) {
            y.getLeft().parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            setRoot(y);
        } else if (x == x.parent.getLeft()) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // Rotate right at node x
    protected void rotateRight(LinkedBinaryTree.Node<E> x) {
        LinkedBinaryTree.Node<E> y = x.getLeft();
        x.left = y.getRight();
        if (y.getRight() != null) {
            y.getRight().parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            setRoot(y);
        } else if (x == x.parent.getRight()) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    public static void main(String[] args) {
        BalancedScale<Integer> balancedTree = new BalancedScale<>();

        balancedTree.insert(10);
        balancedTree.insert(5);
        balancedTree.insert(15);


        boolean found = balancedTree.search(5);
        balancedTree.delete(15);
        Integer minValue = balancedTree.findMin();


        LinkedBinaryTree.Node<Integer> rootNode = balancedTree.getRoot();
        balancedTree.rotateLeft(rootNode);
        balancedTree.rotateRight(rootNode);

        System.out.println(rootNode);
    }
}
