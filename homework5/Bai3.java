import Bai1.LinkedBinaryTree;

import java.util.Scanner;

class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        LinkedBinaryTree<String, String> expressionTree = buildExpressionTree(expression);
        double result = evaluateExpressionTree(expressionTree.addRoot("*"));

        System.out.println("Result: " + result);
    }

    public static LinkedBinaryTree<String, String> buildExpressionTree(String expression) {
        String[] tokens = expression.split("\\s+");
        LinkedBinaryTree<String, String> tree = new LinkedBinaryTree<>();

        LinkedBinaryTree.Node<String> currentNode = tree.addRoot(tokens[0]);

        for (int i = 1; i < tokens.length; i++) {
            String token = tokens[i];

            if (token.equals("(")) {
                currentNode = tree.addLeft(String.valueOf(currentNode), "");
            } else if (token.equals(")")) {
                currentNode = ((LinkedBinaryTree.Node<String>) currentNode).parent;
            } else if (isOperator(token)) {
                currentNode = tree.addRight(String.valueOf(currentNode), token);
            } else {
                tree.set(String.valueOf(currentNode), token);
                currentNode = currentNode.parent;
            }
        }

        return tree;
    }

    public static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public static double evaluateExpressionTree(LinkedBinaryTree.Node<String> node) {
        String element = node.getElement();

        if (isOperator(element)) {
            double leftResult = evaluateExpressionTree(node.getLeft());
            double rightResult = evaluateExpressionTree(node.getRight());

            switch (element) {
                case "+":
                    return leftResult + rightResult;
                case "-":
                    return leftResult - rightResult;
                case "*":
                    return leftResult * rightResult;
                case "/":
                    return leftResult / rightResult;
                default:
                    throw new IllegalArgumentException("Unknown operator: " + element);
            }
        } else {
            return Double.parseDouble(element);
        }
    }
}
