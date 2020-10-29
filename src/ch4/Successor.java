package ch4;

import java.util.LinkedList;

public class Successor {

    public static void scanTree(TreeNode node, LinkedList<Integer> list) {
        if (node == null) return;

        scanTree(node.left, list);
        list.add(node.value);
        scanTree(node.right, list);
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        TreeNode node = GraphUtil.buildBST();
        scanTree(node, list);

        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

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

        System.out.println(find(n17).value);
    }

    public static TreeNode find(TreeNode node) {
        TreeNode parent = node.parent;

        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        if (node == parent.left) return parent;

        if (node == parent.right) {
            while (parent != parent.parent.left) {
                parent = parent.parent;
            }

        }
        return parent.parent;
    }
}
