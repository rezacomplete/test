package ch4;

public class ValidateBST {

    public static boolean isValidBST(TreeNode node) {
        if (node == null) return true;

        if (node.left != null && (node.left.value > node.value) || node.right != null && (node.value > node.right.value)) return false;

        return isValidBST(node.left) && isValidBST(node.right);
    }

    public static void main(String[] args) {
        TreeNode node = GraphUtil.buildBST();
        System.out.println(isValidBST(node));

        node = GraphUtil.buildSmallBST();
        System.out.println(isValidBST(node));

        node = GraphUtil.buildSmallNonBST();
        System.out.println(isValidBST(node));
    }
}
