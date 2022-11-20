package com.acwing.binary;

import java.util.EventListener;
import java.util.Scanner;

//public class Main827 {
//    static int N = 100010;
//    /*
//    * e[N]��ʾԪ��
//    * l[N]��ʾÿ���������˭
//    * r[N]��ʾÿ�����ұ���˭
//    * idxָ��ǰԪ��
//    * */
//    static int[] e = new int[N];
//    static int[] l = new int[N];
//    static int[] r = new int[N];
//    static int idx = 0;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        init();
//        while (m-- > 0) {
//            String op = sc.next();
//            if (op.equals("L")) {
//                int x = sc.nextInt();
//                add(0, x);
//            } else if (op.equals("R")) {
//                int x = sc.nextInt();
//                add(l[1], x);
//            } else if (op.equals("D")) {
//                int k = sc.nextInt();
//                remove(k + 1);  // ��Ϊ��ʼ�����������ڵ㣬���Ե�k�������±�Ϊ k + 2 - 1
//            } else if (op.equals("IL")) {
//                int k = sc.nextInt();
//                int x = sc.nextInt();
//                add(l[k + 1], x);   // ��k������Ԫ�ض�Ӧ������Ϊk + 1, l[k + 1] Ϊ��������һ��λ�ö�Ӧ������
//            } else {
//                int k = sc.nextInt();
//                int x = sc.nextInt();
//                add(k + 1, x);
//            }
//        }
//
//        // 1������β���
//        for (int i = r[0]; i != 1; i = r[i]) {
//            System.out.print(e[i] + " ");
//        }
//    }
//
//    // ��ʼ��
//    public static void init() {
//        // ���³�ʼ���ᵼ�µ�k�������Ԫ�ص�����Ϊ k + 1
//        r[0] = 1;       // �Ҷ˵㣺head -> next = tail
//        l[1] = 0;       // ��˵㣺tail -> pre = head
//        idx = 2;        // ���������ڵ�
//    }
//
//    // ���±���k�ĵ���ұߣ�����x����Ӧ���ǵ�k - 1������Ԫ���Ҳ����x
//    public static void add(int k, int x) {
//        e[idx] = x;
//        r[idx] = r[k];
//        l[idx] = k;
//        l[r[k]] = idx;
//        r[k] = idx++;
//    }
//    // ɾ������Ϊk��Ԫ�أ���Ӧ��ɾ����k - 1������Ԫ��
//    public static void remove(int k) {
//        r[l[k]] = r[k];
//        l[r[k]] = l[k];
//    }
//
//}


public class Main827 {
    static int N = 100010;
    static int[] l = new int[N];
    static int[] r = new int[N];
    static int[] e = new int[N];        // �����е�����Ԫ��
    static int idx = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        init();
        int x, k;
        while (m-- > 0) {
            String op = sc.next();
            if (op.equals("L")) {
                x = sc.nextInt();
                add(0, x);
            } else if (op.equals("R")) {
                x = sc.nextInt();
                add(l[1], x);
            } else if (op.equals("D")) {
                k = sc.nextInt();
                remove(k + 1);
            } else if (op.equals("IL")) {
                k = sc.nextInt();
                x = sc.nextInt();
                add(l[k + 1], x);
            } else {
                k = sc.nextInt();
                x = sc.nextInt();
                add(k + 1, x);
            }
        }
        for (int i = r[0]; i != 1; i = r[i]) {
            System.out.print(e[i] + " ");
        }
    }
    public static void init() {
        r[0] = 1; // �Ҷ˵� head->next = tail
        l[1] = 0; // ��˵� tail->pre = head
        idx = 2;        // ���������˵�
    }
    public static void add(int k, int x) {
        e[idx] = x;
        r[idx] = r[k];
        l[idx] = k;
        l[r[k]] = idx;
        r[k] = idx++;
    }
    public static void remove(int k) {
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }
}
