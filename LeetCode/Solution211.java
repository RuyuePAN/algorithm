package com.acwing.sort;

public class Solution211 {
}

// 用trie树实现
class WordDictionary {
    private WordDictionary[] children;
    private boolean isEnd;
    // 初始化一个根节点。根节点可以有26个子节点，但是目前是空的
    public WordDictionary() {
        children = new WordDictionary[26];
        isEnd = false;
    }
    public void addWord(String word) {
        WordDictionary node = this;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.children[idx] == null) node.children[idx] = new WordDictionary();
            node = node.children[idx];
        }
        node.isEnd = true;
    }
    public boolean search(String word) {
        return search(word, this);
    }
    public boolean search(String word, WordDictionary node) {
        boolean res = false;
        if (node == null)   return false;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (idx >= 0 && idx < 26) {                     // 如果搜索的是字母
                if (node.children[idx] == null) return false;
            } else {                // 如果遇到了通配符 .
                for (int j = 0; j < 26; j++) {              // 遍历26个子节点
                    if (search(word.substring(i + 1), node.children[j])) return true;
                }
                return false;
            }
            node = node.children[idx];
        }
        return node.isEnd;
    }
}