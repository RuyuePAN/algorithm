package com.acwing.binary;

import java.util.Scanner;

public class Main835 {
    /**
     *    N 代表的是输入的字符串的总长度，也就是说如果你输入了三个单词"apple" "was" "ward"
     *    此时的 N = 5 + 3 + 4 = 12
     *    这个数字一般比我们真正要的 N 更大，因为可能会有前缀相同的字符共用数组
     **/
//    static int N = 100010;          // 输入的字符串的长度
//    // 标明第N个字符是否为单词结尾：需要注意的是，这些被标注为true的节点和单词是一一对应的，有一个true就有一个与之对应的单词
//    // 但是现在为了计数，就不用boolean数组了，用int数组，记录有几个单词的前缀一致
//    static int[] flag = new int[N];
//    // 目前trie树中的字符元素，第idx个字符
//    static int idx = 0;
//    // 存储trie树的节点
//    static int[][] trie = new int[N][26];
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        while (n-- > 0) {
//            String op = sc.next();
//            String S = sc.next();
//            char[] s = new char[S.length()];
//            for (int i = 0; i < s.length; i++) {
//                s[i] = S.charAt(i);
//            }
//            if (op.equals("I")) {
//                insert(s);
//            } else {
//                System.out.println(query(s));
//            }
//        }
////        for (int i = 0; i < N; i++) {
////            System.out.print("\n| ");
////            for (int j = 0; j < 26; j++) {
////                System.out.print(trie[i][j] + " | ");
////            }
////        }
////        System.out.println("\n");
////        for (int i = 0; i < N; i++) {
////            System.out.print(flag[i] + " ");
////        }
//    }
//    /**
//     * {@param p 第一个字符是从0，也就是第一层开始操作的}
//     * */
//    public static void insert(char[] s) {
//        int p = 0;
//        for (int i = 0; i < s.length; i++) {
//            // 这个字符如果没有插入，就插入这个字符
//            if (trie[p][s[i] - 'a'] == 0) trie[p][s[i] - 'a'] = ++idx;
//            p = trie[p][s[i] - 'a'];
//        }
//        // 标记一下该单词的最后一个字符，多一个单词的尾缀在这里
//        flag[p]++;
//    }
//
//    public static int query(char[] s) {
//        int p = 0;
//        for (int i = 0; i < s.length; i++) {
//            if (trie[p][s[i] - 'a'] == 0)   return 0;
//            else p = trie[p][s[i] - 'a'];
//        }
//        return flag[p];
//    }

    static int[][] trie;
    static int idx;
    static boolean[] flag;
    public static void main(String[] args) {
        int N = 100010;                         // 输入的字符串总长度
        trie = new int[N][26];          // 存储Tire树
        idx = 0;                            // Tire树的戒子节点的索引
        flag = new boolean[N];        // 标记某个叶子结点是否为词尾
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            String op = sc.next();
            String newWord = sc.next();
            char[] word = new char[newWord.length()];
            for (int i = 0; i < newWord.length(); i++) {
                word[i] = newWord.charAt(i);
            }

            if (op.equals("I")) {
                insert(word);
            } else {
                query(word);
            }
        }
    }

    /**
     * 向trie树中插入单词
     * p为父节点序号，一开始为0，因为每个单词都是从第一层开始插入的。我们以插入字母'w'为例，查看trie[p]['w' - 'a']是否为0就是在查看序号为p的节点有没有'w'叶子结点.
     *
     * @param word 插入的新单词
     * */
    public static void insert(char[] word) {
        // p 表示节点序号，但是一开始为0，因为每一个新单词都要从trie树的第一层开始插入
        int p = 0;
        // 遍历该单词，挨个插入每一个字母节点
        for (int i = 0; i < word.length; i++) {
            // 该字母节点已经存在于Trie树中——该二维数组上的节点位置不为0
            if (trie[p][word[i] - 'a'] == 0) trie[p][word[i] - 'a'] = ++idx;           // 插入一个新的字母节点——表上序号
            p = trie[p][word[i] - 'a'];               // 更新p，在下一轮循环中，探索节点trie[p][word[i]]的叶子结点
        }
        // 标记词尾
        flag[p] = true;
    }
    /**
     * 在trie树中查找单词
     *
     * @param word 查找的单词
     * */
    public static boolean query(char[] word) {
        // 查找一个单词也是从trie树的第一层开始查找
        int p = 0;
        for (int i = 0; i < word.length; i++) {
            // 如果这个字母不存在
            if (trie[p][word[i] - 'a'] == 0) return false;
            // 否则就是这个字母存在，更新p，在下一轮循环中，探索节点trie[p][word[i]]的叶子结点
            else p = trie[p][word[i] - 'a'];
        }
        return true;
    }
}
