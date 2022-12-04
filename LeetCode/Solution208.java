package com.acwing.sort;

import java.util.HashMap;
import java.util.HashSet;

public class Solution208 {
}

class Trie {

//    class Pair {
//        int order;
//        char c;
//
//        public Pair(int order, char c) {
//            this.order = order;
//            this.c = c;
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if (this == obj)  return true;
//            if (obj == null || getClass() != obj.getClass())    return false;
//            Pair pair = (Pair) obj;
//            if (order != pair.order || c != pair.c)    return false;
//            return true;
//        }
//
//        @Override
//        public int hashCode() {
//            return order;
//        }
//    }
//    public HashMap<Pair, Integer> trie;
//    public HashSet<Integer> flag;
//    public int idx;
//    /**
//     * 初始化：
//     * trie 用 HashMap 存储，(Key，value)为(序号-字母, idx)
//     * 用 flag 存储所有为词尾的序号
//     * 用idx标记节点序号
//     **/
//    public Trie() {
//        trie = new HashMap<>();
//        flag = new HashSet<>();
//        idx = 0;
//    }
//
//    /**
//     * @param word 往trie树中插入的单词
//     *
//     **/
//    public void insert(String word) {
//        int p = 0;          // 父节点序号
//        for (int i = 0; i < word.length(); i++) {
//            Pair newPair = new Pair(p, word.charAt(i));
//            // 如果没有这个节点，就插入这个新节点
//            if (trie.get(newPair) == null){
//                trie.put(newPair, ++idx);
//            }
//            // 如果已经有这个节点了，就顺着这个父节点向下
//            p = trie.get(newPair);
//        }
//        flag.add(p);
//    }
//
//    public boolean search(String word) {
//        int p = 0;
//        for (int i = 0; i < word.length(); i++) {
//            Pair newPair = new Pair(p, word.charAt(i));
//            if (trie.get(newPair) == null)   return false;
//            p = trie.get(newPair);
//        }
//        // 查询是否为词尾
//        return flag.contains(p);
//    }
//
//    public boolean startsWith(String prefix) {
//        int p = 0;
//        for (int i = 0; i < prefix.length(); i++) {
//            Pair newPair = new Pair(p, prefix.charAt(i));
//            if (trie.get(newPair) == null)   return false;
//            p = trie.get(newPair);
//        }
//        // 查询是否为词尾
//        return true;
//    }


    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.children[idx] == null) node.children[idx] = new Trie();
            node = node.children[idx];
        }
        node.isEnd = true;
    }
    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return node.isEnd;
    }
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return true;
    }
}