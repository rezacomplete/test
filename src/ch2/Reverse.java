package ch2;

public class Reverse {

    private static void printList(Node n) {
        while (n != null) {
            System.out.print(n.value + "->");
            n = n.next;
        }
    }

    public static void main(String[] args) {
        Node a = new Node(5);

        Node a2 = new Node(9);
        a.next = a2;

        Node a3 = new Node(2);
        a2.next = a3;

        System.out.println();
        printList(a);
        Node result = reverse(a);
        System.out.println();
        printList(result);
    }

    private static Node reverse(Node node) {
        Node n = new Node();

        while (node != null) {
            n.value = node.value;
            Node temp = n;
            n = new Node();
            n.next = temp;
            node = node.next;
        }

        return n.next;
    }
}
