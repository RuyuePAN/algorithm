package com.acwing.Num;

import java.util.ArrayList;
import java.util.Scanner;

public class Main793 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int b = Integer.parseInt(sc.next());
        int[] A = new int[a.length()];
        for (int i = 0; i < a.length(); i++) {
            A[i] = a.charAt(a.length() - i - 1) - '0';
        }
        ArrayList<Integer> ans = mul(A, b);
        // Ïû³ýÇ°µ¼0
        while (ans.size() > 1 && ans.get(ans.size() - 1) == 0) {
            ans.remove(ans.size() - 1);
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(ans.size() - i - 1));
        }
    }

    public static ArrayList<Integer> mul(int[] A, int b) {
        ArrayList<Integer> ans = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < A.length || t > 0; i++) {
            if (i < A.length)   t += b * A[i];
            ans.add(t % 10);
            t /= 10;
        }
        return ans;

    }
}
