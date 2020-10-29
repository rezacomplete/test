package ch8;

public class PaintFill {

    public static void main(String[] args) {
        int[][] paint = {{1, 1, 1, 1, 1},
                         {1, 2, 2, 2, 1},
                         {1, 2, 2, 2, 1},
                         {1, 2, 2, 2, 1},
                         {1, 1, 1, 1, 1}};

        fillPaint(paint, 2, 2, 5);

        for (int row = 0; row < paint.length; row++) {
            for (int col = 0; col < paint.length; col++) {
                System.out.print(paint[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillPaint(int[][] paint, int row, int col, int newColour) {
        int currentColour = paint[row][col];
        fillPaint(paint, row, col, currentColour, newColour);
    }

    private static void fillPaint(int[][] paint, int row, int col, int currentColour, int newColour) {
        if (row < 0 || row > paint.length || col < 0 || col > paint.length) return;

        if (paint[row][col] == currentColour) {
            paint[row][col] = newColour;
            fillPaint(paint, row - 1, col, currentColour, newColour);
            fillPaint(paint, row + 1, col, currentColour, newColour);
            fillPaint(paint, row, col - 1, currentColour, newColour);
            fillPaint(paint, row, col + 1, currentColour, newColour);
        }

    }
}
