package leetcode;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
//        new Main().myPow(1, -2147483648);
        System.out.println(-10%2);
        Queue<String> sth = new LinkedList<>();
        int[] s = new int[10];
        s = Arrays.copyOf(s, 9);
//        Arrays.copyOfRange();
//        Arrays.toString();
//        Integer.parseInt();
        int[][] m = new int[5][10];
        System.out.println(m.length);
        System.out.println(m[0].length);
    }

    public double myPow(double x, int n) {
        System.out.println("x:" + x + ", n:" + n);
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        double result;
        if (n > 0) {
            if (n % 2 == 0) {
                result = myPow(x, n/2);
                result = result * result;
            } else {
                result = myPow(x, n/2);
                result = result * result * x;
            }

        } else {
            result = 1/myPow(x, -n);
        }

        return result;
    }
}
