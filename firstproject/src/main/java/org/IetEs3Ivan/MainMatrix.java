/*
Data una matrice quadrata ed un numero k, shiftare (traslare) a destra i primi k elementi di ogni
riga.
Esempi:
Input : mat[N][N] = {{1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}}
 k = 2
Output :mat[N][N] = {{3, 1, 2}
                    {6, 4, 5}
                    {9, 7, 8}}
Input : mat[N][N] = {{1, 2, 3, 4}
                    {5, 6, 7, 8}
                    {9, 10, 11, 12}
                    {13, 14, 15, 16}}
 k = 2
Output :mat[N][N] = {{3, 4, 1, 2}
                    {7, 8, 5, 6}
                    {11, 12, 9, 10}
                    {15, 16, 13, 14}}
 */
package org.IetEs3Ivan;

public class MainMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                          {4, 5, 6},
                          {7, 8, 9}};
        int k = 1;
        /*
        int[][] matrix = {{1, 2, 3, 4},
                         {5, 6, 7, 8},
                         {9, 10, 11, 12},
                         {13, 14, 15, 16}};
        int k = 2;
        */

        //STAMPA MATRICE PRIMA DI ESSERE TRASLATA
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < k; j++) {
                int last = matrix[i][matrix[0].length - 1];
                for (int m = matrix[0].length - 1; m > 0; m--) {
                    matrix[i][m] = matrix[i][m - 1];
                }
                matrix[i][0] = last;
            }
        }

        System.out.println();
        //STAMPA MATRICE SHIFTATA
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}