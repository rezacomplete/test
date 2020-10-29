package ch4;

public class CheckSubtree {

    public static void main(String[] args) {
        TreeNode t1 = GraphUtil.buildBST();
        TreeNode t2 = GraphUtil.buildSubTree();

        boolean result = checkSubTree(t1, t2);
        System.out.println(result);
    }

    private static boolean checkSubTree(TreeNode t1, TreeNode t2) {
        StringBuilder sb1 = new StringBuilder();
        preOrder(t1, sb1);

        System.out.println(sb1.toString());

        StringBuilder sb2 = new StringBuilder();
        preOrder(t2, sb2);

        System.out.println(sb2.toString());

        return sb1.toString().contains(sb2.toString());
    }

    private static void preOrder(TreeNode t, StringBuilder sb) {
        if (t == null) {
            sb.append('X');
            return;
        }

        sb.append(t.value);

        preOrder(t.left, sb);
        preOrder(t.right, sb);
    }
}
