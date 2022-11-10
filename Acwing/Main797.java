package com.acwing.binary;

import java.util.Scanner;

public class Main797 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next()), m = Integer.parseInt(sc.next());
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        /*
        * 构造差分序列{bn}使得ai = b1+b2+...+bi
        * b1 = a1
        * b2 = a2 - a1
        * b3 = a3 - a2
        * ...
        * bn = an - an-1
        * */
        for (int i = 1; i < n + 1; i++) {
            a[i] = Integer.parseInt(sc.next());
            b[i] = a[i] - a[i - 1];
        }
        int l, r, c;
        while (m > 0) {
            l = Integer.parseInt(sc.next());
            r = Integer.parseInt(sc.next());
            c = Integer.parseInt(sc.next());
            // b[l] + c
            b[l] += c;
            // 补偿(别越界)
            if (r < n){
                b[r + 1] -= c;
            }
            m--;
        }
        // 遍历{bn}输出数组
        for (int i = 1; i < n + 1; i++) {
            b[i] += b[i - 1];
            System.out.print(b[i] + " ");
        }
    }
}
