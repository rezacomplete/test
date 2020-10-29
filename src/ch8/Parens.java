package ch8;

import java.util.HashSet;
import java.util.Set;

public class Parens {

    public static void main(String[] args) {
        Set<String> parens = getParens(3);
        for (String p : parens) {
            System.out.println(p);
        }
    }

    private static Set<String> getParens(int count) {
        Set<String> result = new HashSet<>();
        if (count == 0) {
            result.add("");
            return result;
        }

        Set<String> parens = getParens(count - 1);
        for (String p : parens) {
            for (int i = 0; i <= p.length(); i++) {
                String paren = insertParens(p, i);
                result.add(paren);
            }
        }

        return result;
    }

    private static String insertParens(String word, int i) {
        String before = word.substring(0, i);
        String after = word.substring(i);
        return before + "()" + after;
    }
}
