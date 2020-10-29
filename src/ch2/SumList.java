package ch2;

public class SumList {
    private static void printList(Node n) {
        while (n != null) {
            System.out.print(n.value + "->");
            n = n.next;
        }
    }

    public static void main(String[] args) {
        Node n = new Node(7);

        Node n2 = new Node(1);
        n.next = n2;

        Node n3 = new Node(6);
        n2.next = n3;
        n3.next = null;

        printList(n);

        Node a = new Node(5);

        Node a2 = new Node(9);
        a.next = a2;

        Node a3 = new Node(2);
        a2.next = a3;

        Node a4 = new Node(5);
        a3.next = a4;
        a4.next = null;

        System.out.println();
        printList(a);

        System.out.println();
        System.out.println((617 + 5295));

        Node result = calculateSum(n, a);
        printList(result);
    }

    public static Node calculateSum(Node n1, Node n2) {
        int carry = 0;
        Node node = new Node();
        Node head = node;

        while(n1 != null || n2 != null) {
            int d1 = n1 != null ? n1.value : 0;
            int d2 = n2 != null ? n2.value : 0;

            int sum = d1 + d2 + carry;
            int resultDigit = 0;
            if (sum < 10) {
                resultDigit = sum;
                carry = 0;
            } else  {
                resultDigit = sum % 10;
                carry = 1;
            }

            n1 = n1 != null ? n1.next : null;
            n2 = n2 != null ? n2.next : null;

            node.value = resultDigit;

            if (n1 != null || n2 != null) {
                node.next = new Node();
                node = node.next;
            }

        }

        return head;
    }
}
