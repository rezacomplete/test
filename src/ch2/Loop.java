package ch2;

import java.util.HashSet;
import java.util.Set;

public class Loop {

    public static void main(String[] args) {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = c;

        System.out.println((char) find(a).value);
    }

    public static Node find(Node n) {
        Set<Node> set = new HashSet<>();
        while (n != null) {
            if (!set.contains(n)) {
                set.add(n);
            } else {
                return n;
            }

            n = n.next;
        }

        return null;
    }
}
