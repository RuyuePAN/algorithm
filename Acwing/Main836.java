package com.acwing.binary;

import java.util.Scanner;

public class Main836 {
    static int[] p = new int[100010];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            // �����нڵ��ֵ��ֵΪ�Լ�
            p[i] = i;
        }

        // ��������
        while (m-- > 0) {
            String op = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (op.equals("M")) {
                // �� a �����ڽڵ�ĸ��� = b �����ڽڵ�
                p[find(a)] = find(b);
            } else {
                // �ж������ڵ��Ƿ���ͬһ����������
                if (find(a) == find(b)) System.out.println("Yes");
                else System.out.println("No");
            }

        }
    }

    // ���鼯������ĵĲ��������� x ���ڼ��ϵı�ţ�����˵���� x �����ڽڵ� + ·��ѹ��
    public static int find(int x) {
        // ��������Ǹ��ڵ㣬�������ĸ��ڵ�����������ڽڵ�
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}
