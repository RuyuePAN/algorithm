package com.acwing.sort;

public class Solution211 {
}

// ��trie��ʵ��
class WordDictionary {
    private WordDictionary[] children;
    private boolean isEnd;
    // ��ʼ��һ�����ڵ㡣���ڵ������26���ӽڵ㣬����Ŀǰ�ǿյ�
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
            if (idx >= 0 && idx < 26) {                     // �������������ĸ
                if (node.children[idx] == null) return false;
            } else {                // ���������ͨ��� .
                for (int j = 0; j < 26; j++) {              // ����26���ӽڵ�
                    if (search(word.substring(i + 1), node.children[j])) return true;
                }
                return false;
            }
            node = node.children[idx];
        }
        return node.isEnd;
    }
}