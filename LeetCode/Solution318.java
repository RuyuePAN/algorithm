package com.acwing.sort;

// 一秒内能出结果的数量级大概为10^7～10^8左右，看题目数据规模算一下，数据规模10^3的话O(n^2)就是10^6，完全是够的，如果数据规模10^5，必须考虑O(nlogn)
public class Solution318 {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] wordsNum = new int[n];
        int res = 0;
        // 遍历 words 数组中的每个单词,对数组 words 中的每个单词计算位掩码
        for (int i = 0; i < n; i++) {
            // 遍历 word 中的每个字母
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                wordsNum[i] |= (1 << word.charAt(j) - 'a');
            }
        }
        // 遍历 words 数组中的每个单词
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((wordsNum[i] & wordsNum[j]) == 0) {
                    res = res > words[i].length() * words[j].length() ? res : words[i].length() * words[j].length();
                }
            }
        }
        return res;
    }
}
