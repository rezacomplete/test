package ch8;

import java.util.ArrayList;

public class Permutations {

    public static void main(String[] args) {
        ArrayList<String> perms = perms("abc");

        for (String word : perms) {
            System.out.println(word);
        }
    }

    private static ArrayList<String> perms(String word) {
        if (word == null) {
            return null;
        }

        if (word.isEmpty()) {
            ArrayList<String> perms = new ArrayList<>();
            perms.add("");
            return perms;
        }

        char first = word.charAt(0);
        String remainder = word.substring(1);
        ArrayList<String> perms = perms(remainder);
        ArrayList<String> result = new ArrayList<>();
        for (String perm : perms) {
            for (int i = 0; i <= perm.length(); i++) {
                String s = insert(first, perm, i);
                result.add(s);
            }
        }

        return result;
    }

    private static String insert(char first, String word, int i) {
        String left = word.substring(0, i);
        String right = word.substring(i);
        return left + first + right;
    }

}
