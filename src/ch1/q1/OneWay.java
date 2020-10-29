package ch1.q1;

import java.util.HashSet;
import java.util.Set;

public class OneWay {

    public static boolean check(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str1.length(); i++) {
            set.add(str1.charAt(i));
        }

        for (int i = 0; i < str2.length(); i++) {
            set.remove(str2.charAt(i));
        }

        return set.size() <= 1;
    }

    public static void main(String[] args) {
        System.out.println(OneWay.check("pale", "ple"));
        System.out.println(OneWay.check("pales", "pale"));
        System.out.println(OneWay.check("pale", "bale"));
        System.out.println(OneWay.check("pale", "bake"));
    }
}
