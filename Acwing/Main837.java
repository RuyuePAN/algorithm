package com.acwing.binary;

import java.util.Scanner;

public class Main837 {
    static int[] p = new int[100010];
    // ��ʾÿһ������������������ֻ��֤���ڵ��size���������
    static int[] size = new int[100010];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            // �����нڵ��ֵ��ֵΪ�Լ�
            p[i] = i;
            // ����ļ��϶�ֻ��һ����
            size[i] = 1;
        }

        // ��������
        while (m-- > 0) {
            String op = sc.next();
            if (op.equals("C")) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (find(a) == find(b)) continue;
                size[find(b)] += size[find(a)];
                // �� a �����ڽڵ�ĸ��� = b �����ڽڵ�
                p[find(a)] = find(b);
            } else if (op.equals("Q1")){
                int a = sc.nextInt();
                int b = sc.nextInt();
                // �ж������ڵ��Ƿ���ͬһ����������
                if (find(a) == find(b)) System.out.println("Yes");
                else System.out.println("No");
            } else {
                int a = sc.nextInt();
                System.out.println(size[find(a)]);
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

