package com.zemo.easy.array;

/**
 * @ClassName: FlippingAnImage
 * @author: superzemo
 * @email: zemochen@gmail.com
 * @Date 2018/8/14 10:16 PM
 * @Description Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 *              To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 *              To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 * Example 1:
 *          Input: [[1,1,0],[1,0,1],[0,0,0]]
 *          Output: [[1,0,0],[0,1,0],[1,1,1]]
 *          Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 *          Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 * Example 2:
 *          Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 *          Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *          Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 *          Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 */
public class FlippingAnImage {

    public static void main(String[] args) {
        int[][] A = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        for (int[] ints : A) {
            System.out.print("[");
            for (int anInt : ints) {
                System.out.print(anInt+",");
            }
            System.out.print("]");
        }
        System.out.println();
        int[][] B = flipAndInvertImage(A);
        for (int[] ints : B) {
            System.out.print("[");
            for (int anInt : ints) {
                System.out.print(anInt+",");
            }
            System.out.print("]");
        }
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int l = 0, r = A[i].length - 1;
            while (l < r) {
                if ((A[i][l] ^ A[i][r]) == 0) {
                    A[i][l] = A[i][r] = 1 - A[i][r];
                }
                ++l;
                --r;

            }
            if (l == r) {
                A[i][l] = 1 - A[i][l];
            }
        }
        return A;
    }
}
