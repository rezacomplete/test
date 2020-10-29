package ch1.q1;

import java.util.HashMap;
import java.util.Map;

public class Compression {

    public static String compress(String str) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        map.put(str.charAt(0), 1);

        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, ++count);
            } else {
                for (char key : map.keySet()) {
                    int count = map.get(key);
                    sb.append(key);
                    sb.append(count);
                    map.remove(key);
                    map.put(c, 1);
                }
            }
        }

        for (char key : map.keySet()) {
            int count = map.get(key);
            sb.append(key);
            sb.append(count);
            map.remove(key);
        }

        String result = sb.toString();

        if (str.length() > result.length()) {
            return result;
        }

        return str;
    }


    public static String compress2(String str) {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            count++;

            if (i + 1 >= str.length() || current != str.charAt(i + 1)) {
                sb.append(current);
                sb.append(count);
                count = 0;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(Compression.compress("aabcccccaaa"));
        System.out.println(Compression.compress2("aabcccccaaa"));
    }
}
