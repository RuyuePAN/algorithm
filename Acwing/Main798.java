package com.acwing.binary;

import java.util.Scanner;

public class Main798 {
    // 解法一
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.next()), m = Integer.parseInt(sc.next()), q = Integer.parseInt(sc.next());
//        int[][] a = new int[n + 1][m + 1];
//        int[][] b = new int[n + 1][m + 1];
//        /*
//        * 构造矩阵{bmn}使得aij为bij左上角所有的数字的和
//        *
//        * */
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < m + 1; j++) {
//                a[i][j] = Integer.parseInt(sc.next());
//                b[i][j] = a[i][j] - (a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1]);
//            }
//        }
//        int x1, y1, x2, y2, c;
//        while(q > 0) {
//            x1 = Integer.parseInt(sc.next());
//            y1 = Integer.parseInt(sc.next());
//            x2 = Integer.parseInt(sc.next());
//            y2 = Integer.parseInt(sc.next());
//            c = Integer.parseInt(sc.next());
//
//            b[x1][y1] += c;
//            // 补偿并注意边界
//            if (y2 < m) {
//                b[x1][y2 + 1] -= c;
//            }
//            if (x2 < n) {
//                b[x2 + 1][y1] -= c;
//            }
//            if (x2 < n && y2 < m) {
//                b[x2 + 1][y2 + 1] +=c;
//            }
//            q--;
//        }
//        for (int i = 1; i < n + 1; i++) {
//            if (i != 1) {
//                System.out.print("\n");
//            }
//            for (int j = 1; j < m + 1; j++) {
//                a[i][j] = a[i - 1][j] + a[i][j - 1] + b[i][j] - a[i - 1][j - 1];
//                System.out.print(a[i][j] + " ");
//            }
//        }
//
//    }
    static int[][] a;
    static int[][] b;
    static int m, n, q;
    // 解法二：推荐！！！！
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.next());
        m = Integer.parseInt(sc.next());
        q = Integer.parseInt(sc.next());
        a = new int[n + 1][m + 1];
        b = new int[n + 1][m + 1];
        /*
         * 构造矩阵{bmn}使得aij为bij左上角所有的数字的和
         * */
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                a[i][j] = Integer.parseInt(sc.next());
                /*
                * 因为 b矩阵本来就是全0矩阵
                * 相当于往 b 矩阵（全零矩阵）的b[i][j] + a[i][j]
                * 原因：
                * 1. insert()函数就是设计的让插入操作之后的矩阵b能保证b[i][j]右上角的和等于a[i][j]
                * 2. insert()函数在插入操作之后，不会影响a[i][j]左边和下边的数字
                * */
                insert(i, j, i, j, a[i][j]);
            }
        }
        int x1, y1, x2, y2, c;
        while(q > 0) {
            x1 = Integer.parseInt(sc.next());
            y1 = Integer.parseInt(sc.next());
            x2 = Integer.parseInt(sc.next());
            y2 = Integer.parseInt(sc.next());
            c = Integer.parseInt(sc.next());
            insert(x1, y1, x2, y2, c);
            q--;
        }
        for (int i = 1; i < n + 1; i++) {
            if (i != 1) {
                System.out.print("\n");
            }
            for (int j = 1; j < m + 1; j++) {
                a[i][j] = a[i - 1][j] + a[i][j - 1] + b[i][j] - a[i - 1][j - 1];
                System.out.print(a[i][j] + " ");
            }
        }

    }

    static void insert(int x1, int y1, int x2, int y2, int c) {
        b[x1][y1] += c;
        // 补偿并注意边界
        if (y2 < m) {
            b[x1][y2 + 1] -= c;
        }
        if (x2 < n) {
            b[x2 + 1][y1] -= c;
        }
        if (x2 < n && y2 < m) {
            b[x2 + 1][y2 + 1] +=c;
        }
    }
}
