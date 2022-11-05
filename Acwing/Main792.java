package com.acwing.Num;

import java.util.ArrayList;
import java.util.Scanner;

public class Main792 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        int[] A = new int[a.length()];
        int[] B = new int[b.length()];

        for (int i = 0; i < A.length; i++) {
            A[a.length() - i - 1] = Character.getNumericValue(a.charAt(i));
        }
        for (int i = 0; i < B.length; i++) {
            B[b.length() - i - 1] = Character.getNumericValue(b.charAt(i));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if (cmp(A,B)) {
            ans = sub(A, B);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(ans.size() - i - 1));
            }
        } else {
            ans = sub(B, A);
            System.out.print("-");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(ans.size() - i - 1));
            }
        }


    }

    // 判断是否有 A >= B
    public static boolean cmp(int[] A, int[] B) {
        if (A.length != B.length)   return A.length > B.length;
        // 从高位开始比较
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] != B[i]) {
                return A[i] > B[i];
            }
        }
        return true;
    }

    public static ArrayList<Integer> sub(int[] A, int[] B) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0, t = 0; i < A.length; i++) {
            t = A[i] - t;
            if (i < B.length) t -= B[i];
            ans.add((t + 10) % 10);
            if (t < 0)  t = 1;
            else t = 0;
        }
        // 消除可能出现的0
        while (ans.size() > 1 && ans.get(ans.size() - 1) == 0) ans.remove(ans.size() - 1);
        return ans;
    }
}
