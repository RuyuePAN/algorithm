package com.acwing.sort;

public class Solution28 {
    public int strStr(String haystack, String needle) {
        char[] s = new char[haystack.length() + 1];
        char[] p = new char[needle.length() + 1];
        for (int i = 1; i <= haystack.length(); i++) {
            s[i] = haystack.charAt(i - 1);
        }
        for (int i = 1; i <= needle.length(); i++) {
            p[i] = needle.charAt(i - 1);
        }
        int[] next = new int[needle.length() + 1];

        for (int i = 2, j = 0; i <= needle.length(); i++) {
            while (j != 0 && p[i] != p[j + 1])  j = next[j];
            if (p[i] == p[j + 1])   j++;
            next[i] = j;
        }

        for (int i = 1, j = 0; i <= haystack.length(); i++) {
            while (j != 0 && s[i] != p[j + 1])  j = next[j];
            if (s[i] == p[j + 1])   j++;
            if (needle.length() == j)  return i - j;
        }
        return -1;
    }
}
