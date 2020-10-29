package ch1.q1;

public class StringRotation {
    public static boolean isRotation(String s1, String s2) {
        String s = s1 + s1;
        return s.indexOf(s2) > 0;
    }

    public static void main(String[] args) {
        String s1 = "erbottlewat";
        String s2 = "waterbottle";

        System.out.println(StringRotation.isRotation(s1, s2));
    }
}
