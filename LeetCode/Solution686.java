package com.acwing.sort;

public class Solution686 {
    public int repeatedStringMatch(String a, String b) {
        int res = (int) Math.ceil((double) (a.length() + b.length() - 1) / a.length());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res; i++) sb.append(a);
        String s = sb.toString();

        int n = b.length();
        int m = s.length();

        // KMP Ëã·¨Æ¥Åä
        int[] next = new int[n + 1];
        for (int i = 1, j = 0; i < n; i++) {
            while (j != 0 && b.charAt(i) != b.charAt(j))  j = next[j];
            if (b.charAt(i) == b.charAt(j)) j++;
            next[i + 1] = j;
        }
        for (int i = 0, j = 0; i < m; i++) {
            while (j != 0 && s.charAt(i) != b.charAt(j))    j = next[j];
            if (s.charAt(i) == b.charAt(j))     j++;
            // Æ¥Åä³É¹¦
            if (n == j) {
                return (int) Math.ceil((double) (i + 1) / a.length());
            }
        }
        return -1;
    }
}
