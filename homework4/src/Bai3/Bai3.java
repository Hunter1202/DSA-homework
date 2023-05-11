package Bai3;

import java.util.*;

public class Bai3 {
    public static boolean isParenthesisMatching(String str) {
        // Tạo một stack để lưu trữ các dấu ngoặc mở
        Stack<Character> stackNgoac = new Stack<Character>();

        // Duyệt qua từng ký tự của biểu thức
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Nếu ký tự là dấu ngoặc mở, thêm nó vào stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stackNgoac.push(ch);
            }
            // Nếu ký tự là dấu ngoặc đóng, kiểm tra xem nó có phù hợp với dấu ngoặc mở gần nhất trong stack hay không
            else if (ch == ')' || ch == '}' || ch == ']') {
                // Nếu stack rỗng, tức là không có dấu ngoặc mở phù hợp
                if (stackNgoac.isEmpty()) {
                    return false;
                }

                // Lấy ra dấu ngoặc mở gần nhất trong stack
                char last = stackNgoac.peek();

                // Kiểm tra tính hợp lệ của cặp dấu ngoặc mở và đóng
                if ((ch == ')' && last == '(') || (ch == '}' && last == '{') || (ch == ']' && last == '[')) {
                    stackNgoac.pop();
                }
                else {
                    return false;
                }
            }
        }

        // Nếu stack rỗng, tức là tính hợp lệ về dấu ngoặc của biểu thức
        return stackNgoac.isEmpty();
    }

    // Tính toán biểu thức
    public static int evaluateExpression(String expression) {
        //sử dụng hai stack: operandStack để lưu các số hạng, và operatorStack để lưu các phép tính
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        //duyệt qua các phần tử trong biểu thức
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            //Nếu ký tự đó là một toán hạng, đưa nó vào operatorStack.

            //Nếu ký tự đó là một toán tử, lấy hai toán hạng trên đỉnh stack ra để tính toán
            // và đưa kết quả vào operandStack.
            if (ch == '(') {
                operatorStack.push(ch);
            } else if (ch == ')') {
                while (operatorStack.peek() != '(') {
                    int result = applyOperation(operatorStack.pop(), operandStack.pop(), operandStack.pop());
                    operandStack.push(result);
                }
                operatorStack.pop();
            } else if (isOperator(ch)) {
                while (!operatorStack.empty() && hasPrecedence(ch, operatorStack.peek())) {
                    int result = applyOperation(operatorStack.pop(), operandStack.pop(), operandStack.pop());
                    operandStack.push(result);
                }
                operatorStack.push(ch);
            } else if (Character.isDigit(ch)) {
                int operand = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    operand = (operand * 10) + Character.getNumericValue(expression.charAt(i));
                    i++;
                }
                i--;
                operandStack.push(operand);
            }
        }

        //result cuối dc đặt ở top của stack
        while (!operatorStack.empty()) {
            int result = applyOperation(operatorStack.pop(), operandStack.pop(), operandStack.pop());
            operandStack.push(result);
        }

        return operandStack.pop();
    }

    //thực thi phép toán của 2 số hạng
    public static int applyOperation(char operator, int operand2, int operand1) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new UnsupportedOperationException("Không thể chia cho 0");
                }
                return operand1 / operand2;
        }
        return 0;
    }

    //check các kí tự có là toán tử
    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bieuThuc = sc.nextLine();
        if (isParenthesisMatching(bieuThuc)) {
            System.out.println("Biểu thức hợp lệ về dấu ngoặc");
            int result = evaluateExpression(bieuThuc);
            System.out.println("Kết quả biểu thức là: " + result);
        }
        else {
            System.out.println("Biểu thức không hợp lệ về dấu ngoặc");
        }
    }
}

