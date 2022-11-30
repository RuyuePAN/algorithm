package com.acwing.binary;

import java.util.Scanner;

public class Main800 {
    // 暴力算法时间复杂度为O(nm),双指针算法时间复杂度为O(n + m)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), x = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 0, j = m - 1; i < n; i++) {
            while (a[i] + b[j] > x) j--;
            if (a[i] + b[j] == x)   {
                System.out.println(i + " " + j);
                break;
            }
        }
    }
}
