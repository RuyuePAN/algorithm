package com.acwing.Num;

import com.sun.jdi.VoidValue;

import java.util.ArrayList;
import java.util.Scanner;

public class Main791 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int[] A = new int[a.length()];
        int[] B = new int[b.length()];
        for (int i = 0; i < a.length(); i++) {
            char num = a.charAt(a.length() - i - 1);
            A[i] = Character.getNumericValue(num);
        }
        for (int i = 0; i < b.length(); i++) {
            char num = b.charAt(b.length() - i - 1);
            B[i] = Character.getNumericValue(num);
        }
        ArrayList<Integer> ans =  add(A, B);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(ans.size() - i - 1));
        }
        return;
    }

    public static ArrayList<Integer> add(int[] A, int[] B) {
        ArrayList<Integer> ans = new ArrayList<>();
        int t = 0;      // ½øÎ»
        for (int i = 0; i < A.length || i < B.length; i++) {
            if (i < A.length) t += A[i];
            if (i < B.length) t += B[i];
            ans.add(t % 10);
            t /= 10;
        }
        if (t != 0) ans.add(1);
        return ans;
    }
}
