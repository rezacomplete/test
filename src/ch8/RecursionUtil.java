package ch8;

public class RecursionUtil {

    public static boolean[][] buildMaze1() {

        return new boolean[][]{{true, true, true},
                               {true, true, true},
                               {true, true, true}};
    }

    public static boolean[][] buildMaze2() {

        return new boolean[][]{{true, true, true},
                               {true, true, true},
                               {false, true, true}};
    }

    public static int[] buildDistinctSortedArray() {
        return new int[]{-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
    }

    public static int[] buildSortedArray() {
        return new int[]{-10, 5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
    }

}
