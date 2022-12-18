package com.acwing.sort;

import java.util.*;

public class Solution1408 {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (words[i].length() < words[j].length() && kmp(words[j], words[i])){
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
    public boolean kmp(String s, String p) {
        int n = p.length();
        int m = s.length();
        int[] next = new int[n + 1];

        for (int i = 1, j = 0; i < n; i++) {
            while (j != 0 && p.charAt(i) != p.charAt(j))    j = next[j];
            if (p.charAt(i) == p.charAt(j)) j++;
            next[i + 1] = j;
        }

        for (int i = 0, j = 0; i < m; i++) {
            while (j != 0 && s.charAt(i) != p.charAt(j))    j = next[j];
            if (s.charAt(i) == p.charAt(j)) j++;
            if (n == j) return true;
        }

        return false;
    }
}
