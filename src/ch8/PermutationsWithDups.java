package ch8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PermutationsWithDups {

    public static void main(String[] args) {
        ArrayList<String> perms = getPerms("abc");
        for (String perm : perms) {
            System.out.println(perm);
        }
    }

    private static ArrayList<String> getPerms(String word) {
        Map<Character, Integer> map = buildMap(word);
        return perms(map);
    }

    private static ArrayList<String> perms(Map<Character, Integer> map) {
        ArrayList<String> result = new ArrayList<>();

        int totalChar = 0;
        for (char key : map.keySet()) {
            totalChar = totalChar + map.get(key);
        }

        if (totalChar == 0) {
            result.add("");
            return result;
        }

        for (char c : map.keySet()) {
            int count = map.get(c);

            if (count > 0) {
                map.put(c, count - 1);
                ArrayList<String> perms = perms(map);
                map.put(c, count);

                for (String perm : perms) {
                    result.add(c + perm);
                }
            }
        }

        return result;
    }

    private static Map<Character, Integer> buildMap(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, count + 1);
            } else {
                map.put(c, 1);
            }
        }

        return map;
    }
}
