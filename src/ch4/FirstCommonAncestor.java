package ch4;

public class FirstCommonAncestor {

    public static void main(String[] args) {
        TreeNode node = GraphUtil.buildBST();
        System.out.println(node.left.left.left.value + " " + node.right.value);
        boolean result = checkCommonAncestor(node.left.left.left, node.right);
        System.out.println(result);

    }

    private static boolean checkCommonAncestor(TreeNode n1, TreeNode n2) {
        TreeNode temp1 = n1;
        TreeNode temp2 = n2;
        while (temp1 != null) {
            while (temp2 != null) {
                if (temp1.parent == temp2.parent) {
                    System.out.println(temp1.parent.value);
                    return true;
                }

                temp2 = temp2.parent;
            }

            temp1 = temp1.parent;
            temp2 = n2;
        }

        return false;
    }

}
