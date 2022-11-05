package com.acwing.sort;


import java.util.Scanner;

public class quickSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = (int) 1e+6;
        int n;

        // �ֶ��������鳤��
        System.out.println("���������鳤�ȣ�");
        n = Integer.parseInt(sc.next());
        System.out.println("�õģ����鳤��Ϊ��" + n);

        int[] q = new int[n];

        // ��������Ԫ��
        System.out.println("������ֱ�����" + n + "������Ԫ�أ��Իس��ָ�����Ԫ�أ���");
        for (int i = 0; i < q.length; i++) {
            q[i] = Integer.parseInt(sc.next());
        }
        System.out.println("������ϣ������������Ϊ��");
        for (int i = 0; i < q.length; i++) {
            System.out.print(q[i] + " ");
        }

        System.out.println("���ڿ�ʼ����...");

        quick_sort(q, 0, n - 1);


        System.out.println("������ϣ�����������Ϊ��");
        for (int i = 0; i < q.length; i++) {
            System.out.print(q[i] + " ");
        }
    }

    public static void quick_sort(int[] q, int l, int r) {
        // �߽���û�����֣�����ֻ��һ�����֣��Ͳ���������
        if (l >= r) {
            return;
        }

        // x���ȡһ���߽�㣬����ȡq[l]��q[r]��q[(l + r) / 2]
        int x = q[l], i = l - 1, j = r + 1;

        while (i < j) {
            // iָ������
            do {
                i++;
            } while (q[i] < x);
            // jָ������
            do {
                j--;
            } while (q[j] > x);
            if (i < j) {
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        quick_sort(q, l, j);
        quick_sort(q, j + 1, r);

    }

    public static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
}
