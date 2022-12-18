package com.acwing.sort;

public class Solution796 {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        if (n != m) return false;
        s = s + s;
        int[] next = new int[n + 1];
        for (int i = 1, j = 0; i < n; i++) {
            while (j != 0 && goal.charAt(j) != goal.charAt(i)) j = next[j];
            if (goal.charAt(j) == goal.charAt(i))   j++;
            next[i + 1] = j;
        }

        for (int i = 0, j = 0; i < 2 * n; i++) {
            while (j != 0 && s.charAt(i) != goal.charAt(j)) j = next[j];
            if (s.charAt(i) == goal.charAt(j))  j++;
            if (n == j) return true;
        }
        return false;
    }
}
