package ch8;

import java.util.ArrayList;

public class Permutations2 {

    private static ArrayList<String> getPerms(String word) {
        int len = word.length();
        ArrayList<String> result = new ArrayList<>();

        if (len == 0) {
            result.add("");
            return result;
        }

        for (int i = 0; i < len; i++) {
            String before = word.substring(0, i);
            String after = word.substring(i + 1, len);

            ArrayList<String> partials = getPerms(before + after);

            for (String s : partials) {
                result.add(word.charAt(i) + s);
            }
        }

        return result;
    }
}
