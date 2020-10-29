package ch4;

public class CheckBalanced {

    public static void main(String[] args) {
        Node node = GraphUtil.buildGraph();
        System.out.println(GraphUtil.getHeight(node));
        System.out.println(check(node));
    }

    public static boolean check(Node node) {
        if (node == null) return true;

        if (Math.abs(GraphUtil.getHeight(node.getChildren().length > 0 ? node.getChildren()[0] : null) -
                GraphUtil.getHeight(node.getChildren().length > 1 ? node.getChildren()[1] : null)) > 1) {
            return false;
        }

        return check(node.getChildren().length > 0 ? node.getChildren()[0] : null) && check(node.getChildren().length > 1 ? node.getChildren()[1] : null);
    }

    public static int checkHeight(Node node) {
        if (node == null) return -1;

        int leftHeight = checkHeight(node.getChildren()[0]);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(node.getChildren()[1]);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int diffHeight = Math.abs(leftHeight - rightHeight);
        if (diffHeight > 1) return Integer.MIN_VALUE;
        return Math.max(checkHeight(node.getChildren()[0]), checkHeight(node.getChildren()[1])) + 1;

    }
}
