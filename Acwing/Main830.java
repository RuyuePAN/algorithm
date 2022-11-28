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

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int top = 0;
//        int[] stack = new int[100010];
//        for (int i = 0; i < n; i++) {
//
//            int x = sc.nextInt();
//            while (top >= 0 && stack[top] >= x) top--;
//            if (top != 0) System.out.print(stack[top] + " ");
//            else System.out.print(-1 + " ");
//            stack[++top] = x;
//        }
//    }

    // try2
    // 第一个栈元素索引为1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stack = new int[n];   // 维护一个栈
        int top = 0;                // 栈顶指针
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            while (top >= 0 && x <= stack[top]) top--;
            if (top != 0) System.out.print(stack[top] + " ");
            else System.out.print(-1 + " ");
            stack[++top] = x;
        }
    }
}
