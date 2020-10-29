package ch4;

import java.util.LinkedList;

public class RouteBetweenNodes {

    public static boolean route(Node start, Node end) {
        if (start == end) {
            return true;
        }

        LinkedList<Node> queue = new LinkedList<>();

        queue.addLast(start);

        while(!queue.isEmpty()) {
            Node curr = queue.removeFirst();
            if (curr != null) {
                System.out.print(curr.getValue() + " ");
                if (!curr.visited) {
                    curr.visited = true;
                    if (curr == end) return true;
                    for (Node child : curr.getChildren()) {
                        queue.addLast(child);
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);
        Node n13 = new Node(13);
        Node n14 = new Node(14);
        Node n15 = new Node(15);

        n15.setChildren(n14, n13);
        n14.setChildren(n12, n11);
        n13.setChildren(n10, n9);
        n12.setChildren(n8, n7);
        n11.setChildren(n6, n5);
        n10.setChildren(n4, n3);
        n9.setChildren(n2, n1);

        System.out.println(route(n15, n1));
    }
}
