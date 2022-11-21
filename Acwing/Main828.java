package com.acwing.binary;

import java.util.Scanner;

public class Main828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] stack = new int[100001];
        int top = 0;        // Õ»¶¥Ë÷Òý
        while (m-- > 0) {
            String op = sc.next();
            if (op.equals("push")) {
                int x = sc.nextInt();
                stack[top++] = x;
            } else if (op.equals("pop")) {
                top--;
            } else if (op.equals("empty")) {
                if (top == 0) System.out.println("YES");
                else System.out.println("NO");
            } else {
                System.out.println(stack[top - 1]);
            }
        }
    }
}
