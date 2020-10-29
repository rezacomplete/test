package ch4;

import apple.laf.JRSUIUtils;

import java.util.*;

public class GraphUtil {
    public static void print(Node node) {
        LinkedList<Node> queue = new LinkedList<>();

        queue.addLast(node);

        while(!queue.isEmpty()) {
            Node curr = queue.removeFirst();
            if (curr != null) {
                System.out.print(curr.getValue() + " ");
                if (!curr.visited) {
                    curr.visited = true;
                    for (Node child : curr.getChildren()) {
                        queue.addLast(child);
                    }
                }
            }
        }
    }

    public static void markLevel(Node node, int level, Map<Integer, LinkedList<Integer>> map) {
        if (node == null) return;
        node.level = level;

        if (map.containsKey(node.level)) {
            map.get(node.level).add(node.value);
        } else {
            map.put(node.level, new LinkedList<Integer>() {{
                add(node.value);
            }});
        }

        level++;
        markLevel(node.children[0], level, map);
        markLevel(node.children[1], level, map);
    }

    public static Node buildGraph() {
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

        return n15;
    }

    public static int getHeight(Node node) {
        if (node == null) return -1;
        return Math.max(getHeight(node.getChildren().length > 0 ? node.getChildren()[0] : null), getHeight(node.getChildren().length > 1 ? node.getChildren()[1] : null)) + 1;
    }

    public static TreeNode buildBST() {
        TreeNode n20 = new TreeNode(20);
        TreeNode n10 = new TreeNode(10);
        TreeNode n30 = new TreeNode(30);

        n20.left = n10;
        n20.right = n30;
        n10.parent = n20;
        n30.parent = n20;

        TreeNode n5 = new TreeNode(5);
        TreeNode n15 = new TreeNode(15);

        n10.left = n5;
        n10.right = n15;
        n5.parent = n10;
        n15.parent = n10;

        TreeNode n3 = new TreeNode(3);
        TreeNode n7 = new TreeNode(7);

        n5.left = n3;
        n5.right = n7;
        n3.parent = n5;
        n7.parent = n5;

        TreeNode n17 = new TreeNode(17);

        n15.right = n17;
        n17.parent = n15;

        return n20;
    }

    public static TreeNode buildSmallBST() {
        TreeNode n20 = new TreeNode(20);
        TreeNode n10 = new TreeNode(10);
        TreeNode n30 = new TreeNode(30);

        n20.left = n10;
        n20.right = n30;

        return  n20;
    }

    public static TreeNode buildSmallNonBST() {
        TreeNode n20 = new TreeNode(20);
        TreeNode n10 = new TreeNode(10);
        TreeNode n15 = new TreeNode(15);

        n20.left = n10;
        n20.right = n15;

        return  n20;
    }

    public static TreeNode buildSubTree() {
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n7 = new TreeNode(7);

        n5.left = n3;
        n5.right = n7;
        n3.parent = n5;
        n7.parent = n5;

        return n5;
    }
 }
