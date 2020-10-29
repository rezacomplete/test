package ch4;

public class PathsWithSum {
    public static void main(String[] args) {
        TreeNode node = GraphUtil.buildBST();
        calculatePath(node, 0, 0);
    }

    private static void calculatePath(TreeNode node, int sum, int total) {
        if (node == null) return;

        sum += node.value;
        System.out.println("sum = " + sum);
        if(sum == 45) total++;
        System.out.println("total = " + total);
        calculatePath(node.left, sum, total);
        calculatePath(node.right, sum, total);
    }
}
