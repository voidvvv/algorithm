package cn.zkj.algorithm.matrix;

import java.security.SecureRandom;
import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;

public class MatrixDemo {
    public int[][] generateMatrix (int m, int n, int bound) {
        int[][] matrix = new int[m][n];
        Random random = new SecureRandom();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(bound);
            }
        }
        return matrix;
    }

    public int[][] demoMatrix (int m, int n) {
        int p = 1;
        int[][] matrix = new int[m][n];
        Random random = new SecureRandom();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (p++);
            }
        }
        return matrix;
    }

    public static void printMatrix (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] multiWithTranspose (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j ++) {
                int v = 0;
                for (int x = 0; x< n; x++) {
                    v += (matrix[i][x] * matrix[j][x]);
                }
                ans[i][j] = v;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MatrixDemo demo = new MatrixDemo();
//        int[][] matrix = demo.generateMatrix(7, 10, 500);
        printMatrix(demo.demoMatrix(3,3));
        printMatrix(multiWithTranspose(demo.demoMatrix(3,3)));


    }
}
