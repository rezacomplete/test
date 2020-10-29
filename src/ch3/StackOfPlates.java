package ch3;

import java.util.ArrayList;
import java.util.Stack;

public class StackOfPlates {

    private static ArrayList<Stack<Integer>> stacks = new ArrayList<>();
    private static int capacity = 3;

    public static void push(int item) {
        if (stacks.isEmpty()) {
            System.out.println("Creating the first stack...");
            Stack<Integer> stack = new Stack<>();
            stacks.add(stack);
        }

        Stack<Integer> lastStack = stacks.get(stacks.size() - 1);
        if (lastStack.size() == capacity) {
            System.out.println("Creating a new stack...");
            Stack<Integer> stack = new Stack<>();
            stacks.add(stack);
            lastStack = stack;
        }

        lastStack.push(item);
    }

    public static int pop() {
        if (stacks.isEmpty()) {
            throw new RuntimeException("Empty stacks");
        }

        Stack<Integer> lasStack = stacks.get(stacks.size() - 1);
        int popped = lasStack.pop();
        if (lasStack.isEmpty()) {
            System.out.println("Removing a stack...");
            stacks.remove(lasStack);
        }

        return popped;
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        push(4);
        push(5);
        push(6);
        push(7);
        push(8);
        push(9);
        push(10);

        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }
}
