package com.acwing.sort;

public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if (n <= 1) return false;
        for (int i = n / 2; i > 0; i--) {
            System.out.println("i = " + i);
            if (n % i == 0 && kmp(s, s.substring(0, i))) return true;
        }
        return false;
    }

    public boolean kmp(String s, String p) {
        int m = s.length();
        int n = p.length();
        int[] next = new int[n + 1];
        int count = 0;
        for (int i = 2, j = 0; i <= n; i++) {
            while (j != 0 && p.charAt(i - 1) != p.charAt(j))    j = next[j];
            if (p.charAt(i - 1) == p.charAt(j)) j++;
            next[i] = j;
        }
        for (int i = 0, j = 0; i < m; i++) {
            System.out.println("匹配前： i = " + i);
            while (j != 0 && s.charAt(i) != p.charAt(j))    j = next[j];
            if (s.charAt(i) == p.charAt(j)) j++;
            if (n == j) {
                i += n - 1;
                System.out.println("匹配成功时的 i = " + i + " " + p);
                j = next[j];
                count++;
            }
        }
        System.out.println("count = " + count);
        return count == s.length() / p.length();
    }
}
