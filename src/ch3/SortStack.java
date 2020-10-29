package ch3;

import java.util.Stack;

public class SortStack {
    private static void printStack(Stack<Integer> stack) {
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            int item = stack.get(size - 1 - i);
            System.out.println("|" + item + "|");
        }
        System.out.println("\\_/");
    }

    public static void sort(Stack<Integer> stack) {
        printStack(stack);
        System.out.println("********");

        Stack<Integer> helper = new Stack<>();

        int s = stack.size();
        for (int j = 0; j < s; j++) {
            int max = findMax(stack, j);
            int temp = -1;
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                int item = stack.pop();
                if (item != max) {
                    helper.push(item);
                } else {
                    temp = item;
                    break;
                }
            }

            size = helper.size();
            for (int i = 0; i < size; i++) {
                int item = helper.pop();
                stack.push(item);
            }

            stack.push(temp);

            printStack(stack);
            System.out.println("********");
        }

    }

    private static int findMax(Stack<Integer> stack, int j) {
        int max = -1;

        int size = stack.size();
        for (int i = j; i < size; i++) {
            int item = stack.get(size - 1 - i);
            if (item > max) {
                max = item;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(9);
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(7);

        sort(stack);
    }
}
