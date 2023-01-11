package com.acwing.binary;

import java.util.Scanner;

public class Main836 {
    static int[] p = new int[100010];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            // 把所有节点的值赋值为自己
            p[i] = i;
        }

        // 挨个操作
        while (m-- > 0) {
            String op = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (op.equals("M")) {
                // 让 a 的祖宗节点的父亲 = b 的祖宗节点
                p[find(a)] = find(b);
            } else {
                // 判断两个节点是否在同一个集合里面
                if (find(a) == find(b)) System.out.println("Yes");
                else System.out.println("No");
            }

        }
    }

    // 并查集中最核心的操作：返回 x 所在集合的编号，或者说返回 x 的祖宗节点 + 路径压缩
    public static int find(int x) {
        // 如果它不是根节点，就让它的父节点等于它的祖宗节点
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}
