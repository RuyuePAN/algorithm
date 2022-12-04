package com.acwing.binary;

import java.util.Scanner;

public class Main143 {
//    static int[][] trie;
//    static int idx = 0;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        // 因为Ai比较小，所以直接用int就可以
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//        }
//        int res = 0;
//        // 构建一个Trie：二维数组，第一维是所有输入字符的总长度，因为我们输入的是数字，所以这里是所有数码的长度
//        trie = new int[n * 31][2];
//        for (int i = 0; i < n; i++) {
//            insert(nums[i]);       // 将数字换转为二进制
//        }
//
//        for (int i = 0; i < n; i++) {
//            res = Math.max(res, query(nums[i]));
//        }
//        System.out.println(res);
//    }
//
//    // 往trie中插入数字
//    public static void insert(int num) {
//        int p = 0;
//        /**
//         * 因为这里的 0 <= Ai < 2^31，所以即使 Ai 即使为 2^31-1，右移30位之后，也只剩一位了， 再&1，就能得到最高位的数字
//         * 右移30位，右移29位，右移28位...右移0位
//         * 如果 Ai = 10（二进制），那么循环31次右移，并&1获得的结果就是
//         * 000 0000 0000 0000 0000 0000 0000 0010 (一共31位)
//         * 如果 Ai = 1101（二进制），那么循环31次右移，并&1获得的结果就是
//         * 000 0000 0000 0000 0000 0000 0000 1101 (一共31位)
//         * 这么处理只是为了让所有数字都有相同的位数
//         *
//         **/
//        for (int i = 30; i >= 0; i--) {
//            if (trie[p][num >> i & 1] == 0) trie[p][num >> i & 1] = ++idx;            // 创建一个新节点
//            p = trie[p][num >> i & 1];
//        }
//    }
//
//
//    /**
//     * 比如
//     * 000 0000 0000 0000 0000 0000 0000 0010（当前num）
//     * 111 1111 1111 1111 1111 1111 1111 1101（目标数字，也就是我们想找到的最理想的数字，二者取异或之后得到的数字会最大）
//     * 111 1111 1111 1111 1111 1111 1111 1111（二者的异或结果）
//     * */
//    public static int query(int num) {
//        int res = 0, p = 0;
//        for (int i = 30; i >= 0; i--) {
//            /*
//            * 如果在某一位上，与该位相反的数字存在：该位为0，存在节点1；或者该位为1，存在节点0.
//            * 那么它们取异或的结果一定为1，所以 res += 1 << i;
//            * */
//            if (trie[p][(num >> i & 1)^1] != 0){
//                res += 1 << i;
//                p = trie[p][(num >> i & 1)^1];         // 走不同分支
//            }
//            // 如果不存在与该位相反的数字，那就退而求其次，选择数字相同的
//            else  p = trie[p][num >> i & 1];        // 走相同分支
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
        // 构建 Trie 树
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            insert(nums[i]);
        }
        // 获得异或值
        for (int i = 0; i < n; i++) {
            res = Math.max(res, query(nums[i]));
        }
        System.out.println(res);

    }

    // 构建Trie树
    public static void insert(int num) {
        int p = 0;              // 父节点序号，指向父节点
        for (int i = 30; i >= 0; i--) {
            // 如果该节点不存在，则插入这个节点
            if (trie[p][num >> i & 1] == 0) trie[p][num >> i & 1] = ++idx;
            // 父节点指针下移，指向找到的子节点
            p = trie[p][num >> i & 1];
        }
    }

    // 获得异或值
    public static int query(int num) {
        // res用于记录num与【异或伙伴】的异或结果
        int p = 0, res = 0;
        for (int i = 30; i >= 0; i--) {
            // 如果目标节点存在，如果当前位为0，那么目标节点就是1；如果当前位为1，那么目标节点就是0。这边用异或来获取目标节点的值。
            // 注意这里只是右移做计算，主要是为了获得num在某一位上的数字
            if (trie[p][(num >> i & 1) ^ 1] != 0) {
                // 只要查找到，两个数字的异或值一定是1，我们把这个数字累加到结果中
                res += 1 << i;
                p = trie[p][(num >> i & 1) ^ 1];
            }
            // 如果目标节点不存在，那么就退而求其次，顺着另一个节点向下
            else p = trie[p][num >> i & 1];
        }
        return res;
    }
}
