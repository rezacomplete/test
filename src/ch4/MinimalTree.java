package ch4;

import java.util.*;

public class MinimalTree {

    public static Node createTree(int[] arr) {
        return createTree(arr, 0, arr.length - 1);
    }

    private static Node createTree(int[] arr, int start, int end) {
        if (end < start) return null;

        int min = (start + end)/2;
        Node root = new Node(arr[min]);
        Node left = createTree(arr, start, min - 1);
        Node right = createTree(arr, min + 1, end);
        root.setChildren(left, right);
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        GraphUtil.print(createTree(arr));

        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        GraphUtil.markLevel(createTree(arr), 0, map);

        Collection<LinkedList<Integer>> result = map.values();
    }
}
