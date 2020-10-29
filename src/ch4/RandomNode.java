package ch4;

import java.util.ArrayList;
import java.util.Random;

public class RandomNode {

    public static void main(String[] args) {
        TreeNode node = GraphUtil.buildBST();
        int random = getRandomNode(node);
        System.out.println(random);
    }

    private static int getRandomNode(TreeNode node) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(node, list);
        Random random = new Random();
        int r = random.nextInt(list.size());
        return list.get(r);
    }

    private static void inOrder(TreeNode node, ArrayList<Integer> list) {
        if (node == null) return;

        inOrder(node.left, list);
        list.add(node.value);
        inOrder(node.right, list);
    }


}
