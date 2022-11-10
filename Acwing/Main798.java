package com.acwing.binary;

import java.util.Scanner;

public class Main798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next()), m = Integer.parseInt(sc.next()), q = Integer.parseInt(sc.next());
        int[][] a = new int[n + 1][m + 1];
        int[][] b = new int[n + 1][m + 1];
        /*
        * 构造矩阵{bmn}使得aij为bij左上角所有的数字的和
        *
        * */
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                a[i][j] = Integer.parseInt(sc.next());
                b[i][j] = a[i][j] - (a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1]);
            }
        }
        int x1, y1, x2, y2, c;
        while(q > 0) {
            x1 = Integer.parseInt(sc.next());
            y1 = Integer.parseInt(sc.next());
            x2 = Integer.parseInt(sc.next());
            y2 = Integer.parseInt(sc.next());
            c = Integer.parseInt(sc.next());

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
}
