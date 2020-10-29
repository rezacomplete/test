package ch2;

import java.util.HashSet;
import java.util.Set;

public class Duplicates {

    public static void remove(Node n) {
        Set<Integer> set = new HashSet<>();

        Node prev = n;
        Node curr = n.next;
        set.add(prev.value);

        while(curr != null) {
            if (!set.contains(curr.value)) {
                set.add(curr.value);
            } else {
                prev.next = curr.next;
            }

            prev = curr;
            curr = curr.next;
        }
    }

    private static void printList(Node n) {
        while (n != null) {
            System.out.println(n.value);
            n = n.next;
        }
    }

    public static void main(String[] args) {
        Node r = new Node();
        r.value = 'R';

        Node e = new Node();
        e.value = 'E';
        r.next = e;

        Node z = new Node();
        z.value = 'Z';
        e.next = z;

        Node a = new Node();
        a.value = 'R';
        z.next = a;

        printList(r);
        System.out.println();
        remove(r);
        printList(r);
    }
}
