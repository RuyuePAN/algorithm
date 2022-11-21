package com.acwing.binary;

import java.util.Scanner;

// 单调栈的用法
public class Main830 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int top = 0;
//        int[] stack = new int[100010];
//        for (int i = 0; i < n; i++) {
//            int x = sc.nextInt();
//            while (top > 0 && stack[top] >= x) top--;
//            if (top != 0) System.out.print(stack[top] + " ");
//            else System.out.print(-1 + " ");
//            stack[++top] = x;       // 插入单调栈中
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int top = 0;
        int[] stack = new int[100010];
        for (int i = 0; i < n; i++) {

            int x = sc.nextInt();
            while (top >= 0 && stack[top] >= x) top--;
            if (top >= 0) System.out.print(stack[top] + " ");
            else System.out.print(-1 + " ");
            stack[++top] = x;
        }
    }
}
