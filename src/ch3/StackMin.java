package ch3;

import java.util.Stack;

public class StackMin {

    private static Stack<Integer> stack = new Stack<>();
    private static Stack<Integer> minStack = new Stack<>();

    private static void push(int item) {
        stack.push(item);

        if (minStack.isEmpty() || item < minStack.peek()) {
            minStack.push(item);
        }
    }

    private static int min() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }

        throw new RuntimeException("No MIN");
    }

    private static int pop() {
        int popped = stack.pop();

        if (minStack.peek() == popped) {
            minStack.pop();
        }

        return popped;
    }

    public static void main(String[] args) {
        push(10);
        System.out.println(min());

        push(11);
        push(12);
        push(9);
        System.out.println(min());

        push(13);
        System.out.println(min());

        push(1);
        System.out.println(min());

        pop();
        System.out.println(min());

        pop();
        pop();
        pop();
        pop();
        pop();
        System.out.println(min());
    }
}
