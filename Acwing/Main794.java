package com.acwing.Num;

import java.util.ArrayList;
import java.util.Scanner;

public class Main794 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int b = Integer.parseInt(sc.next());
        int[] A = new int[a.length()];
        for (int i = 0; i < a.length(); i++) {
            A[i] = a.charAt(a.length() - i - 1) - '0';
        }
        int r = 0;
        ArrayList<Integer> ans = div(A, b, r);
        // 去除前导0
        while (ans.size() > 2 && ans.get(0) == 0) {
            ans.remove(0);
        }
        // 第一行输出商
        for (int i = 0; i < ans.size() - 1; i++) {
            System.out.print(ans.get(i));
        }
        // 第二行输出余数
        System.out.println("\n" + ans.get(ans.size() - 1));

    }

    // A / b = ans ... r
    public static ArrayList<Integer> div(int[] A, int b, int r) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            r = A[i] + 10 * r;
            ans.add(r / b);
            r %= b;
        }
        ans.add(r);
        return ans;
    }
}
