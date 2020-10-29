package ch8;

import java.util.ArrayList;

public class RobotInGrid {

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static ArrayList<Point> getPath (boolean[][] maze) {
        if(maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
            return path;
        }
        return null;
    }

    private static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
        System.out.println("Checking path to (" + row + "," + col + ")");
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }

        boolean isAtOrigin = (row == 0) && (col == 0);

        if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) {
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
//        printPath(getPath(RecursionUtil.buildMaze1()));
        printPath(getPath(RecursionUtil.buildMaze2()));

    }

    private static void printPath(ArrayList<Point> path) {
        for (Point point : path) {
            System.out.print("(" + point.row + "," + point.col + ") ");
        }
    }
}
