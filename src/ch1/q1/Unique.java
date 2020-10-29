package ch1.q1;

import java.util.HashSet;
import java.util.Set;

public class Unique {
    public static boolean isUnique1(String str) {
        if (str.length() > 128) return false;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isUnique2(String str) {
        if (str.length() > 128) return false;

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i))) {
                return false;
            }

            set.add(str.charAt(i));
        }

        return true;
    }

    public static boolean isUnique3(String str) {
        if (str.length() > 128) return false;

        char[] arr = new char[128];

        for (int i = 0; i < str.length(); i++) {
            if (arr[str.codePointAt(i)] == 1) {
                return false;
            }

            arr[str.codePointAt(i)]  = 1;
        }

        return true;
    }

    public static void main(String[] args) {
        String notUnique = "rezaahmadi";
        String unique = "poiuytrewqasdfghjklmnbvcxz";

        System.out.println(Unique.isUnique1(notUnique));
        System.out.println(Unique.isUnique1(unique));
        System.out.println();

        System.out.println(Unique.isUnique2(notUnique));
        System.out.println(Unique.isUnique2(unique));
        System.out.println();

        System.out.println(Unique.isUnique3(notUnique));
        System.out.println(Unique.isUnique3(unique));
        System.out.println();
    }
}
