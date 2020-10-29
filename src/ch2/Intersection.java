package ch2;

import java.util.HashSet;
import java.util.Set;

public class Intersection {
    private static void printList(Node n) {
        while (n != null) {
            System.out.print(n.value + "->");
            n = n.next;
        }
    }

    public static void main(String[] args) {
        Node n3 = new Node(3);
        Node n1 = new Node(1);
        Node n5 = new Node(5);
        Node n9 = new Node(9);
        Node n7 = new Node(7);
        Node n2 = new Node(2);
        Node n11 = new Node(1);
        Node n4 = new Node(4);
        Node n6 = new Node(6);

        n3.next = n1;
        n1.next = n5;
        n5.next = n9;
        n9.next = n7;
        n7.next = n2;
        n2.next = n11;

        printList(n3);
        System.out.println();

        n4.next = n6;
        n6.next = n7;
        n7.next = n2;
        n2.next = n11;

        printList(n4);
        System.out.println();

        Node intersection = findIntersection(n3, n4);
        System.out.println(intersection.value);
        System.out.println("///////////////////////");
        intersection = findIntersection2(n3, n4);
        System.out.println(intersection.value);

    }

    public static Node findIntersection(Node n1, Node n2) {
        Set<Integer> set = new HashSet<>();
        while (n1 != null) {
            set.add(n1.value);
            n1 = n1.next;
        }

        while (n2 != null) {
            if (set.contains(n2.value)) {
                return n2;
            }

            n2 = n2.next;
        }

        return null;
    }

    public static Node findIntersection2(Node n1, Node n2) {
        Node lastN1 = n1;
        int sizeN1 = 1;
        while (lastN1.next != null) {
            lastN1 = lastN1.next;
            sizeN1++;
        }

        System.out.println("sizeN1 = " + sizeN1);
        System.out.println("lastN1 = " + lastN1.value);

        Node lastN2 = n2;
        int sizeN2 = 1;
        while (lastN2.next != null) {
            sizeN2++;
            lastN2 = lastN2.next;
        }

        System.out.println("sizeN2 = " + sizeN2);
        System.out.println("lastN2 = " + lastN2.value);

        if (lastN1 != lastN2) {
            return null; // no intersection
        }

        if (sizeN1 > sizeN2) {
            n1 = ignore(n1, sizeN1 - sizeN2);
        } else {
            n2 = ignore(n2, sizeN2 - sizeN1);
        }

        while (n1 != null) {
            if (n1 == n2) {
                return n1;
            }

            n1 = n1.next;
            n2 = n2.next;
        }

        return null;
    }

    private static Node ignore(Node n, int s) {
        for (int i = 0; i < s; i++) {
            n = n.next;
        }

        return n;
    }
}
