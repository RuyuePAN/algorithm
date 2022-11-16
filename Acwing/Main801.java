package com.acwing.binary;

import java.util.Scanner;

public class Main801 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int x;
        int res;
        for (int i = 0; i < n; i++) {
            res = 0;
            // ��������
            x = Integer.parseInt(sc.next());
            while (x > 0) {
                x -= lowBit(x);
                res++;
            }
            System.out.print(res + " ");
        }
    }

    /*
    * ԭ�� 101110
    * ���� 010001
    * ���� 010010
    * ������ĩβ��1��֮������֣�x & -x = x & (~x + 1) = x & (x�Ĳ���)
    * ���� 1001001100 & -1001001100 = 100
    * */
    public static int lowBit(int x) {
        return x & -x;
    }
}
