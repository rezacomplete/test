package ch8;

public class RecursiveMultiply {
    public static void main(String[] args) {
        int result = multiply(100, 50);
        System.out.println(result);
    }

    private static int multiply(int a, int b) {
        int smaller = a < b ? a : b;
        int bigger = a > b ? a : b;

        int[] memo = new int[smaller + 1];
        return multiplyHelper(smaller, bigger, memo);
    }

    private static int multiplyHelper(int smaller, int bigger, int[] memo) {
        if (smaller == 0 || bigger == 0) return 0;

        if (smaller == 1) return bigger;

        if (memo[smaller] != 0) {
            return memo[smaller];
        }

        int halfSmaller = smaller >> 1;
        int result = multiplyHelper(halfSmaller, bigger, memo);

        if (smaller % 2 == 0) {
            result = result + result;
        } else {
            result = result + result + bigger;
        }

        memo[smaller] = result;

        return result;
    }
}
