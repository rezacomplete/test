package ch1.q1;

import java.util.Arrays;

public class Permutation {

    public static boolean isPermute(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        return sort(str1).equals(sort(str2));
    }

    private static String sort(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static boolean isPermute2(String str1, String str2) {
        int[] arr = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            arr[str1.charAt(i)]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            arr[str2.charAt(i)]--;
            if (arr[str2.charAt(i)] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "reza";
        String s2 = "azer";
        System.out.println(Permutation.isPermute(s1, s2));
        System.out.println(Permutation.isPermute2(s1, s2));
    }
}

