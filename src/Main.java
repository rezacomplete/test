import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        new Main().permutation("ABC", "");
        System.out.println("======================");
        new Main().permute("ABC", 0);
    }

    void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    void permute(String s, int l) {
        if (l == s.length() - 1) System.out.println(s);

        for (int i = l; i < s.length(); i++) {
            s = swap(s, l, i);
            permute(s, l + 1);
        }
    }

    String swap(String s, int i, int j) {
        char temp;
        char[] arr = s.toCharArray();
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);

    }
}
