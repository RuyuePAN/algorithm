package com.acwing.sort;

// һ�����ܳ���������������Ϊ10^7��10^8���ң�����Ŀ���ݹ�ģ��һ�£����ݹ�ģ10^3�Ļ�O(n^2)����10^6����ȫ�ǹ��ģ�������ݹ�ģ10^5�����뿼��O(nlogn)
public class Solution318 {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] wordsNum = new int[n];
        int res = 0;
        // ���� words �����е�ÿ������,������ words �е�ÿ�����ʼ���λ����
        for (int i = 0; i < n; i++) {
            // ���� word �е�ÿ����ĸ
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                wordsNum[i] |= (1 << word.charAt(j) - 'a');
            }
        }
        // ���� words �����е�ÿ������
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
