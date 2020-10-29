package ch4;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BSTSequences {

    public static void main(String[] args) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        TreeNode node = GraphUtil.buildBST();
        markLevel(node, 0, map);

        Collection<LinkedList<Integer>> result = map.values();
    }

    public static void markLevel(TreeNode node, int level, Map<Integer, LinkedList<Integer>> map) {
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
        markLevel(node.left, level, map);
        markLevel(node.right, level, map);
    }

}
