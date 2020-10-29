package ch1.q1;

public class Matrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4},
                       {5, 6, 7, 8},
                       {9, 0, 11, 12},
                       {13, 14, 15, 16}};

        printArray(arr);
        System.out.println();
        findZero(arr);
        printArray(arr);
    }

    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    private static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            for (int i = layer; i < n - 1 - layer; i++) {

                int top = matrix[layer][i]; //save top

                // left -> top
                matrix[layer][i] = matrix[n - 1 - i][layer];

                // bottom -> left
                matrix[n - 1 - i][layer] = matrix[n - 1 - layer][n - 1 - i];

                // right -> bottom
                matrix[n - 1 - layer][n - 1 - i] = matrix[i][n - 1 - layer];

                // top -> right
                matrix[i][n - 1 - layer] = top;
            }
        }
    }

    private static void findZero(int[][] arr) {
        int[] row = new int[arr.length];
        int[] col = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            if (row[i] == 1) {
                setRowToZero(arr, i);
            }

            if (col[i] == 1) {
                setColToZero(arr, i);
            }
        }
    }

    private static void setRowToZero(int[][] arr, int row) {
        for (int i = 0; i < arr[row].length; i++) {
            arr[row][i] = 0;
        }
    }

    private static void setColToZero(int[][] arr, int col) {
        for (int i = 0; i < arr[col].length; i++) {
            arr[i][col] = 0;
        }
    }
}
