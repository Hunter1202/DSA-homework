package homework7.Bai2;

import homework5.LinkedBinaryTree;


public class BinarySearchTree<E extends Comparable<E>> {
    private LinkedBinaryTree<E, LinkedBinaryTree.Node<E>> tree;

    public BinarySearchTree() {
        tree = new LinkedBinaryTree<>();
    }

    public LinkedBinaryTree.Node<E> getRoot(){
        return tree.root;
    }
    protected void setRoot(LinkedBinaryTree.Node<E> node) {
        tree.root = node;
    }

    public E findMin() {
        if (tree.isEmpty()) {
            return null; // Tree is empty
        }

        LinkedBinaryTree.Node<E> current = tree.root;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current.getElement();
    }

    public boolean search(E x) {
        return search(x, tree.root);
    }

    private boolean search(E x, LinkedBinaryTree.Node<E> current) {
        if (current == null) {
            return false; // Element not found
        }

        int compareResult = x.compareTo(current.getElement());
        if (compareResult < 0) {
            return search(x, current.getLeft()); // Search in the left subtree
        } else if (compareResult > 0) {
            return search(x, current.getRight()); // Search in the right subtree
        } else {
            return true; // Element found
        }
    }

    public void insert(E x) {
        tree.root = insert(x, tree.root, null);
    }

    private LinkedBinaryTree.Node<E> insert(E x, LinkedBinaryTree.Node<E> current, LinkedBinaryTree.Node<E> parent) {
        if (current == null) {
            LinkedBinaryTree.Node<E> newNode = new LinkedBinaryTree.Node<>(x, parent, null, null);
            tree.size++;
            return newNode;
        }

        int compareResult = x.compareTo(current.getElement());
        if (compareResult < 0) {
            current.left = insert(x, current.getLeft(), current); // Insert in the left subtree
        } else if (compareResult > 0) {
            current.right = insert(x, current.getRight(), current); // Insert in the right subtree
        }
        return current;
    }

    public void delete(E x) {
        tree.root = delete(x, tree.root);
    }

    private LinkedBinaryTree.Node<E> delete(E x, LinkedBinaryTree.Node<E> current) {
        if (current == null) {
            return null; // Element not found
        }

        int compareResult = x.compareTo(current.getElement());
        if (compareResult < 0) {
            current.left = delete(x, current.getLeft()); // Delete from the left subtree
        } else if (compareResult > 0) {
            current.right = delete(x, current.getRight()); // Delete from the right subtree
        } else {
            // Element found, perform deletion
            if (current.getLeft() == null && current.getRight() == null) {
                // Case 1: No children
                tree.size--;
                return null;
            } else if (current.getLeft() == null) {
                // Case 2: Only right child
                tree.size--;
                return current.getRight();
            } else if (current.getRight() == null) {
                // Case 3: Only left child
                tree.size--;
                return current.getLeft();
            } else {
                // Case 4: Two children
                LinkedBinaryTree.Node<E> successor = findMinNode(current.getRight());
                current.element = successor.getElement();
                current.right = delete(successor.getElement(), current.getRight());
            }
        }
        return current;
    }

    private LinkedBinaryTree.Node<E> findMinNode(LinkedBinaryTree.Node<E> current) {
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    private LinkedBinaryTree.Node<E> insert(E x, LinkedBinaryTree.Node<E> current) {
        if (current == null) {
            LinkedBinaryTree.Node<E> newNode = new LinkedBinaryTree.Node<>(x, null, null, null);
            tree.size++;
            return newNode;
        }

        int compareResult = x.compareTo(current.getElement());
        if (compareResult < 0) {
            current.left = insert(x, current.left); // Recursively insert in the left subtree
        } else if (compareResult > 0) {
            current.right = insert(x, current.right); // Recursively insert in the right subtree
        }
        return current;
    }
}

class main{
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(4);

        System.out.println("Minimum value: " + bst.findMin()); // Output: 1

        System.out.println("Search 4: " + bst.search(4)); // Output: true
        System.out.println("Search 99: " + bst.search(99)); // Output: false

        bst.delete(3);
        System.out.println("Search 3 after delete: " + bst.search(3)); // Output: false

    }
}