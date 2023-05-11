package Bai2;

import Bai1.LinkedBinaryTree;

import java.util.Scanner;
import java.util.Stack;

public class ExpressionTree<E> extends LinkedBinaryTree {
    public void preorderPrint(Node<E> p) {
        if (p != null) {
            System.out.print(p.getElement() + " ");
            preorderPrint(p.getLeft());
            preorderPrint(p.getRight());
        }
    }

    public void postorderPrint(Node<E> p) {
        if (p != null) {
            postorderPrint(p.getLeft());
            postorderPrint(p.getRight());
            System.out.print(p.getElement() + " ");
        }
    }

    public void inorderPrint(Node<E> p) {
        if (p != null) {
            inorderPrint(p.getLeft());
            System.out.print(p.getElement() + " ");
            inorderPrint(p.getRight());
        }
    }

    public int computeValue(Node<String> p) {
        if (p == null) {
            return 0;
        }
        if (p.getLeft() == null && p.getRight() == null) {
            return Integer.parseInt(p.getElement());
        }
        int leftValue = computeValue(p.getLeft());
        int rightValue = computeValue(p.getRight());
        switch (p.getElement()) {
            case "+":
                return leftValue + rightValue;
            case "-":
                return leftValue - rightValue;
            case "*":
                return leftValue * rightValue;
            case "/":
                return leftValue / rightValue;
            default:
                throw new IllegalArgumentException("Invalid operator: " + p.getElement());
        }
    }

    public static void main(String[] args) {
        ExpressionTree<String> tree = new ExpressionTree<>();
        ExpressionTree.Node<String> root = tree.addRoot("*");
        ExpressionTree.Node<String> node1 = tree.addLeft(root, "+");
        ExpressionTree.Node<String> node2 = tree.addRight(root, "-");
        ExpressionTree.Node<String> node3 = tree.addLeft(node1, "6");
        ExpressionTree.Node<String> node4 = tree.addRight(node1, "2");
        ExpressionTree.Node<String> node5 = tree.addLeft(node2, "3");
        ExpressionTree.Node<String> node6 = tree.addRight(node2, "7");
        ExpressionTree.Node<String> node7 = tree.addRight(node3, "4");

        System.out.print("Biểu thức tiền tố: ");
        tree.preorderPrint(root);
        System.out.println();

        System.out.print("Biểu thức trung tố: ");
        tree.inorderPrint(root);
        System.out.println();

        System.out.print("Biểu thức hậu tố: ");
        tree.postorderPrint(root);
        System.out.println();

        ExpressionTree<String> expression = new ExpressionTree<>();
        Node<String> root1 = expression.addRoot("*");
        Node<String> left = expression.addLeft(root1, "+");
        Node<String> right = expression.addRight(root1, "/");
        expression.addLeft(left, "3");
        expression.addRight(left, "4");
        expression.addLeft(right, "6");
        expression.addRight(right, "2");
        int value = expression.computeValue(root1); // evaluates to 21

        System.out.println("Kết quả của biểu thức: " + value);

    }
}
