package ch1.q1;

import java.util.HashMap;
import java.util.Map;

public class Palindrome {
    public static boolean isPalindromePermutation(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, ++count);
            } else {
                map.put(c, 1);
            }

        }

        int odds = 0;

        for (char key : map.keySet()) {
            if (map.get(key) % 2 != 0) {
                odds++;
            }
        }

        return odds <= 1;
    }

    public static void main(String[] args) {
        String str = "tactcoapapa";
        System.out.println(Palindrome.isPalindromePermutation(str));
    }
}
