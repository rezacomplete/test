package ch1.q1;

public class URLify {

    public static String toURL(String str, int n) {
        char[] arr = str.toCharArray();

        int nn = n;
        for (int i = 0; i < n; i++) {
            if (arr[i] == ' ') {
                push(arr, i, nn);
                insert(arr, i);
                nn = nn + 2;
            }
        }

        return new String(arr);
    }

    private static void push(char[] arr, int index, int n) {
        for (int i = n - 1; i > index; i--) {
            arr[i+2] = arr[i];
        }
    }

    private static void insert(char[] arr, int index) {
        String s = "20%";
        for (int i = 0; i < s.length(); i++) {
            arr[index + i] = s.charAt(i);
        }
    }

    public static String toURL2(String str, int trueLength) {
        char[] arr = str.toCharArray();
        int count = 0;

        for (int i = 0; i < trueLength; i++) {
            if (arr[i] == ' ') {
                count++;
            }
        }

        int index = trueLength + 2 * count;

        for (int i = trueLength - 1; i >= 0; i--) {
            if (arr[i] != ' ') {
                arr[index - 1] = arr[i];
                index--;
            }
            else {
                arr[index - 1] = '0';
                arr[index-2] = '2';
                arr[index-3] = '%';
                index = index - 3;
            }
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(URLify.toURL("mr john smith          ", 13));
        System.out.println(URLify.toURL2("mr john smith          ", 13));
    }
}
