package com.acwing.sort;

import java.util.ArrayList;
import java.util.List;

public class Solution1455 {
//    public int isPrefixOfWord(String sentence, String searchWord) {
//        List<String> senWord = new ArrayList<>();
//        int wordStart = 0;
//        int wordEnd = 0;
//        for (int i = 0; i < sentence.length(); i++) {
//            if (sentence.charAt(i) == ' ') {
//                wordEnd = i;
//                senWord.add(sentence.substring(wordStart, wordEnd));
//                wordStart = i + 1;
//            }
//        }
//        senWord.add(sentence.substring(wordStart));
//
//        for (int i = 0; i < senWord.size(); i++) {
//            if (kmp(senWord.get(i), searchWord))    return i + 1;
//        }
//        return -1;
//    }
//
//
//    public boolean kmp(String s, String p) {
//        int n = p.length();
//        int m = s.length();
//        int[] next = new int[n + 1];
//        for (int i = 1, j = 0; i < n; i++) {
//            while (j != 0 && p.charAt(i) != p.charAt(j))    j = next[j];
//            if (p.charAt(i) == p.charAt(j)) j++;
//            next[i + 1] = j;
//        }
//
//        for (int i = 0, j = 0; i < m; i++) {
//            while (j != 0 && s.charAt(i) != p.charAt(j))    j = next[j];
//            if (s.charAt(i) == p.charAt(j)) j++;
//            if (n == j) return i - j + 1 == 0;
//        }
//        return false;
//    }

    public int isPrefixOfWord(String sentence, String searchWord) {
        int wordStart = 0;
        int wordEnd = 0;
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                wordEnd = i;
                if (kmp(sentence.substring(wordStart, wordEnd), searchWord))    return ++count;
                wordStart = i + 1;
            }
        }
        if (kmp(sentence.substring(wordStart), searchWord))    return ++count;
        return -1;
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
            if (n == j) return i - j + 1 == 0;
        }
        return false;
    }
}
