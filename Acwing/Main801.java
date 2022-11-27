package com.acwing.binary;

import java.util.Scanner;

public class Main801 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.next());
//        int x;
//        int res;
//        for (int i = 0; i < n; i++) {
//            res = 0;
//            // 读入数据
//            x = Integer.parseInt(sc.next());
//            while (x > 0) {
//                x -= lowBit(x);
//                res++;
//            }
//            System.out.print(res + " ");
//        }
//    }
//
//    /*
//    * 原码 101110
//    * 反码 010001
//    * 补码 010010
//    * 计算最末尾的1及之后的数字：x & -x = x & (~x + 1) = x & (x的补码)
//    * 比如 1001001100 & -1001001100 = 100
//    * */
//    public static int lowBit(int x) {
//        return x & -x;
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res, x;
        for (int i = 0; i < n; i++) {
            res = 0;
            x = sc.nextInt();
            while (x > 0){
                x -= lowBit(x);
                res++;
            }
            System.out.print(res + " ");
        }
    }

    // 计算出num最末的1开头的数字
    public static int lowBit(int num) {
        return -num & num;
    }
}
