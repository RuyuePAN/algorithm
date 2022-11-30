package com.acwing.binary;

import java.util.Scanner;

public class Main835 {
    /**
     *    N �������������ַ������ܳ��ȣ�Ҳ����˵�������������������"apple" "was" "ward"
     *    ��ʱ�� N = 5 + 3 + 4 = 12
     *    �������һ�����������Ҫ�� N ������Ϊ���ܻ���ǰ׺��ͬ���ַ���������
     **/
    static int N = 100010;          // ������ַ����ĳ���
    // ������N���ַ��Ƿ�Ϊ���ʽ�β����Ҫע����ǣ���Щ����עΪtrue�Ľڵ�͵�����һһ��Ӧ�ģ���һ��true����һ����֮��Ӧ�ĵ���
    // ��������Ϊ�˼������Ͳ���boolean�����ˣ���int���飬��¼�м������ʵ�ǰ׺һ��
    static int[] flag = new int[N];
    // Ŀǰtrie���е��ַ�Ԫ�أ���idx���ַ�
    static int idx = 0;
    // �洢trie���Ľڵ�
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
     * {@param p ��һ���ַ��Ǵ�0��Ҳ���ǵ�һ�㿪ʼ������}
     * */
    public static void insert(char[] s) {
        int p = 0;
        for (int i = 0; i < s.length; i++) {
            // ����ַ����û�в��룬�Ͳ�������ַ�
            if (trie[p][s[i] - 'a'] == 0) trie[p][s[i] - 'a'] = ++idx;
            p = trie[p][s[i] - 'a'];
        }
        // ���һ�¸õ��ʵ����һ���ַ�����һ�����ʵ�β׺������
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
