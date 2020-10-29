package ch2;

import java.util.Stack;

public class Palindrome {

    private static void printList(Node n) {
        while (n != null) {
            System.out.print(n.value + "->");
            n = n.next;
        }
    }

    public static void main(String[] args) {
        Node n = new Node(1, new Node(4, new Node(8, new Node(4, new Node(1)))));

        printList(n);
        System.out.println(is(n));
    }

    public static boolean is(Node n) {
        Node head1 = n;
        Stack<Integer> stack = new Stack<>();

        while (n != null) {
            stack.push(n.value);
            n = n.next;
        }

        Node node = new Node();
        Node head2 = node;
        while(!stack.isEmpty()) {
            node.value = stack.pop();

            if (!stack.isEmpty()) {
                node.next = new Node();
                node = node.next;
            }
        }

        while (head1 != null) {
            if (head1.value != head2.value) {
                return false;
            }

            head1 = head1.next;
            head2 = head2.next;
        }

        return true;
    }
}
