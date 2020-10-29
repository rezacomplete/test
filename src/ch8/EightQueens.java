package ch8;

import java.util.ArrayList;

public class EightQueens {

    public static void main(String[] args) {
        ArrayList<Integer[]> results = placeQueen(0, new Integer[8]);

        for (Integer[] column : results) {
            for (int i = 0; i < column.length; i++) {
                System.out.print(column[i]);
            }
            System.out.println();
        }
    }

    private static ArrayList<Integer[]> placeQueen(int row, Integer[] columns) {
        ArrayList<Integer[]> results = new ArrayList<>();

        if (row == 8) {
            results.add(columns.clone());
            return results;
        }

        for (int col = 0; col < 8; col++) {
            if (checkValid(columns, row, col)) {
                columns[row] = col;
                results.addAll(placeQueen(row + 1, columns));
            }
        }

        return results;
    }

    private static boolean checkValid(Integer[] columns, int row1, int column1) {
        for (int row2 = 0; row2 < row1; row2++) {
            int column2 = columns[row2];

            if(column1 == column2) {
                return false;
            }

            int columnDistance = Math.abs(column2 - column1);
            int rowDistance = row1 - row2;
            if (columnDistance == rowDistance) {
                return false;
            }
        }

        return true;
    }
}
