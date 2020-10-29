package ch8;

import java.util.Stack;

public class TowersOfHanoi {
    static Stack<Integer> tower1 = new Stack<>();
    static Stack<Integer> tower2 = new Stack<>();
    static Stack<Integer> tower3 = new Stack<>();

    public static void main(String[] args) {
        tower1.add(2);
        tower1.add(1);

        move(2, tower1, tower3, tower2);
    }

    private static void move(int n, Stack<Integer> source, Stack<Integer> destination, Stack<Integer> buffer) {
        if (n <= 0) return;

        move(n-1, source, buffer, destination);
        moveTop(source, destination);
        move(n-1, buffer, destination, source);
    }

    private static void moveTop(Stack<Integer> source, Stack<Integer> destination) {
        int item = source.pop();
        destination.push(item);
    }
}
