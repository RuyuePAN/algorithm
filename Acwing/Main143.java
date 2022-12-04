package com.acwing.binary;

import java.util.Scanner;

public class Main143 {
//    static int[][] trie;
//    static int idx = 0;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        // ��ΪAi�Ƚ�С������ֱ����int�Ϳ���
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//        }
//        int res = 0;
//        // ����һ��Trie����ά���飬��һά�����������ַ����ܳ��ȣ���Ϊ��������������֣�������������������ĳ���
//        trie = new int[n * 31][2];
//        for (int i = 0; i < n; i++) {
//            insert(nums[i]);       // �����ֻ�תΪ������
//        }
//
//        for (int i = 0; i < n; i++) {
//            res = Math.max(res, query(nums[i]));
//        }
//        System.out.println(res);
//    }
//
//    // ��trie�в�������
//    public static void insert(int num) {
//        int p = 0;
//        /**
//         * ��Ϊ����� 0 <= Ai < 2^31�����Լ�ʹ Ai ��ʹΪ 2^31-1������30λ֮��Ҳֻʣһλ�ˣ� ��&1�����ܵõ����λ������
//         * ����30λ������29λ������28λ...����0λ
//         * ��� Ai = 10�������ƣ�����ôѭ��31�����ƣ���&1��õĽ������
//         * 000 0000 0000 0000 0000 0000 0000 0010 (һ��31λ)
//         * ��� Ai = 1101�������ƣ�����ôѭ��31�����ƣ���&1��õĽ������
//         * 000 0000 0000 0000 0000 0000 0000 1101 (һ��31λ)
//         * ��ô����ֻ��Ϊ�����������ֶ�����ͬ��λ��
//         *
//         **/
//        for (int i = 30; i >= 0; i--) {
//            if (trie[p][num >> i & 1] == 0) trie[p][num >> i & 1] = ++idx;            // ����һ���½ڵ�
//            p = trie[p][num >> i & 1];
//        }
//    }
//
//
//    /**
//     * ����
//     * 000 0000 0000 0000 0000 0000 0000 0010����ǰnum��
//     * 111 1111 1111 1111 1111 1111 1111 1101��Ŀ�����֣�Ҳ�����������ҵ�������������֣�����ȡ���֮��õ������ֻ����
//     * 111 1111 1111 1111 1111 1111 1111 1111�����ߵ��������
//     * */
//    public static int query(int num) {
//        int res = 0, p = 0;
//        for (int i = 30; i >= 0; i--) {
//            /*
//            * �����ĳһλ�ϣ����λ�෴�����ִ��ڣ���λΪ0�����ڽڵ�1�����߸�λΪ1�����ڽڵ�0.
//            * ��ô����ȡ���Ľ��һ��Ϊ1������ res += 1 << i;
//            * */
//            if (trie[p][(num >> i & 1)^1] != 0){
//                res += 1 << i;
//                p = trie[p][(num >> i & 1)^1];         // �߲�ͬ��֧
//            }
//            // ������������λ�෴�����֣��Ǿ��˶�����Σ�ѡ��������ͬ��
//            else  p = trie[p][num >> i & 1];        // ����ͬ��֧
//        }
//        return res;
//    }
    static int[][] trie;
    static int idx = 0, res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        trie = new int[n * 30 + 1][2];
        int[] nums = new int[n];
        // ���� Trie ��
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            insert(nums[i]);
        }
        // ������ֵ
        for (int i = 0; i < n; i++) {
            res = Math.max(res, query(nums[i]));
        }
        System.out.println(res);

    }

    // ����Trie��
    public static void insert(int num) {
        int p = 0;              // ���ڵ���ţ�ָ�򸸽ڵ�
        for (int i = 30; i >= 0; i--) {
            // ����ýڵ㲻���ڣ����������ڵ�
            if (trie[p][num >> i & 1] == 0) trie[p][num >> i & 1] = ++idx;
            // ���ڵ�ָ�����ƣ�ָ���ҵ����ӽڵ�
            p = trie[p][num >> i & 1];
        }
    }

    // ������ֵ
    public static int query(int num) {
        // res���ڼ�¼num�롾����顿�������
        int p = 0, res = 0;
        for (int i = 30; i >= 0; i--) {
            // ���Ŀ��ڵ���ڣ������ǰλΪ0����ôĿ��ڵ����1�������ǰλΪ1����ôĿ��ڵ����0��������������ȡĿ��ڵ��ֵ��
            // ע������ֻ�����������㣬��Ҫ��Ϊ�˻��num��ĳһλ�ϵ�����
            if (trie[p][(num >> i & 1) ^ 1] != 0) {
                // ֻҪ���ҵ����������ֵ����ֵһ����1�����ǰ���������ۼӵ������
                res += 1 << i;
                p = trie[p][(num >> i & 1) ^ 1];
            }
            // ���Ŀ��ڵ㲻���ڣ���ô���˶�����Σ�˳����һ���ڵ�����
            else p = trie[p][num >> i & 1];
        }
        return res;
    }
}
