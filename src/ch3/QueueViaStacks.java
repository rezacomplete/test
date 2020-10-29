package ch3;

import java.util.Stack;

public class QueueViaStacks {

    private static Stack<Integer> stack = new Stack<>();
    private static Stack<Integer> helper = new Stack<>();

    public static void add(int item) {
        if (!helper.isEmpty()) {
            int size = helper.size();
            for (int i = 0; i < size; i++) {
                stack.push(helper.pop());
            }
        }

        stack.push(item);
    }

    public static int pop() {
        if (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                helper.push(stack.pop());
            }
        }

        return helper.pop();
    }

    public static void main(String[] args) {
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        add(6);

        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());

    }
}
