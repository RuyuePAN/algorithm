package com.acwing.sort;

import javax.swing.*;
import java.util.*;

public class Solution187 {
//    public List<String> findRepeatedDnaSequences(String s) {
//        List<String> res = new ArrayList<>();
//        TrieTree tree = new TrieTree();
//        for (int i = 0; i <= s.length() - 10; i++) {
//            if (tree.insert(s.substring(i, i + 10)) == 2){
//                res.add(s.substring(i, i + 10));
//            }
//        }
//        return res;
//    }
//    public class TrieTree {
//        private TrieTree[] child;
//        private int end;
//
//        public TrieTree() {
//            this.child = new TrieTree[4];
//            this.end = 0;
//        }
//
//        public int insert(String seq) {
//            TrieTree node = this;
//            for (int i = 0; i < 10; i++) {
//                int index = searchIndex(seq.charAt(i));
//                if (node.child[index] == null) node.child[index] = new TrieTree();
//                node = node.child[index];
//            }
//            return ++node.end;
//        }
//
//        public int searchIndex(char c) {
//            if (c == 'A') return 0;
//            else if (c == 'G') return 1;
//            else if (c == 'C') return 2;
//            else return 3;
//        }
//    }

    static final int L = 10;

    Map<Character, Integer> bin = new HashMap<>(){
        {
            put('A', 0);
            put('G', 1);
            put('C', 2);
            put('G', 3);
        }
    };
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        if (n <= L) return ans;
        int x = 0;
        for (int i = 0; i < L - 1; i++) {
            x =  (x << 2) | bin.get(s.charAt(i));
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i <= n - L; i++) {
            x = (x << 2) | bin.get(s.charAt(i + L - 1)) & ((1 << L * 2) - 1);
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            if (cnt.get(x) == 2) ans.add(s.substring(i, i + L));
        }
        return ans;
    }
}
