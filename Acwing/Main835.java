package com.acwing.binary;

import java.util.Scanner;

public class Main835 {
    /**
     *    N 代表的是输入的字符串的总长度，也就是说如果你输入了三个单词"apple" "was" "ward"
     *    此时的 N = 5 + 3 + 4 = 12
     *    这个数字一般比我们真正要的 N 更大，因为可能会有前缀相同的字符共用数组
     **/
    static int N = 100010;          // 输入的字符串的长度
    // 标明第N个字符是否为单词结尾：需要注意的是，这些被标注为true的节点和单词是一一对应的，有一个true就有一个与之对应的单词
    // 但是现在为了计数，就不用boolean数组了，用int数组，记录有几个单词的前缀一致
    static int[] flag = new int[N];
    // 目前trie树中的字符元素，第idx个字符
    static int idx = 0;
    // 存储trie树的节点
    static int[][] trie = new int[N][26];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            String op = sc.next();
            String S = sc.next();
            char[] s = new char[S.length()];
            for (int i = 0; i < s.length; i++) {
                s[i] = S.charAt(i);
            }
            if (op.equals("I")) {
                insert(s);
            } else {
                System.out.println(query(s));
            }
        }
//        for (int i = 0; i < N; i++) {
//            System.out.print("\n| ");
//            for (int j = 0; j < 26; j++) {
//                System.out.print(trie[i][j] + " | ");
//            }
//        }
//        System.out.println("\n");
//        for (int i = 0; i < N; i++) {
//            System.out.print(flag[i] + " ");
//        }
    }
    /**
     * {@param p 第一个字符是从0，也就是第一层开始操作的}
     * */
    public static void insert(char[] s) {
        int p = 0;
        for (int i = 0; i < s.length; i++) {
            // 这个字符如果没有插入，就插入这个字符
            if (trie[p][s[i] - 'a'] == 0) trie[p][s[i] - 'a'] = ++idx;
            p = trie[p][s[i] - 'a'];
        }
        // 标记一下该单词的最后一个字符，多一个单词的尾缀在这里
        flag[p]++;
    }

    public static int query(char[] s) {
        int p = 0;
        for (int i = 0; i < s.length; i++) {
            if (trie[p][s[i] - 'a'] == 0)   return 0;
            else p = trie[p][s[i] - 'a'];
        }
        return flag[p];
    }
}
