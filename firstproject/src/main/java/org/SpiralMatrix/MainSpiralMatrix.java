package org.SpiralMatrix;

public class MainSpiralMatrix {

    public static void printSpiral(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;

        while (top <= bottom && left <= right) {
            // Print top row
            for (int j = top; j <= right; j++) {
                System.out.print(matrix[top][j] + " ");
            }
            top++;

            // Print right column
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;

            // Print bottom row
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    System.out.print(matrix[bottom][j] + " ");
                }
                bottom--;
            }

            // Print left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
    }
    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
      int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printSpiral(matrix);
    }
}
/*
1  2  3  4
5  6  7  8
9  10 11 12
13 14 15 16
*/