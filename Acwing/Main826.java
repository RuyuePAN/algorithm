package com.acwing.binary;

import java.util.Scanner;

//public class Main826 {
//    static int N = 100010;
//    /*
//        head��ʾͷ�����±�
//        e[i]��ʾ�ڵ�i��ֵ
//        ne[i]��ʾ�ڵ�i��nextָ���Ƕ���
//        idx��ʾ��һ�����Դ洢Ԫ�ص�λ������
//    */
//    static int head, idx;
//    static int[] e = new int[N];
//    static int[] ne = new int[N];
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();       // ��������
//        init();
//        while (m-- > 0) {
//            String op = sc.next();
//            if (op.equals("H")) {
//                addToHead(sc.nextInt());
//            } else if (op.equals("D")) {
//                int k = sc.nextInt();
//                if (k == 0) head = ne[head];
//                else deleteK(k - 1);
//            } else {
//                addToK(sc.nextInt() - 1, sc.nextInt());
//            }
//        }
//        for (int i = head; i != -1; i = ne[i]) {
//            System.out.print(e[i] + " ");
//        }
//
//    }
//    // ��ʼ������
//    public static void init() {
//        head = -1;
//        idx = 0;
//    }
//    // ��x�嵽ͷ���
//    public static void addToHead(int x) {
//        // �µĵ����idx
//        e[idx] = x;
//        ne[idx] = head;     // idxָ��Ľڵ����һ���ڵ���ǵ�ǰ��head�ڵ� ==�� ��Ϊͷ���
//        head = idx++;       // ��ͷ���ָ��ǰ�ڵ㣬�ȸ�ֵ���ٵ���
//    }
//    // ��x���뵽k�ڵ�ĺ���
//    public static void addToK(int k, int x) {
//        e[idx] = x;
//        ne[idx] = ne[k];    // idx����һ���ڵ����k�ڵ����һ���ڵ�
//        ne[k] = idx++;      // k�ڵ����һ���ڵ����idx
//    }
//    // ��k�ڵ����һ���ڵ�ɾ��
//    public static void deleteK(int k) {
//        ne[k] = ne[ne[k]];
//    }
//}
public class Main826 {
    static int N = 1000010;
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int head, idx;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        init();
        while (m-- > 0) {
            String op = sc.next();
            if (op.equals("H")) {
                addToHead(sc.nextInt());
            } else if (op.equals("D")) {
                int k = sc.nextInt();
                if (k == 0) head = ne[head];
                else removeK(k - 1);
            } else {
                int k = sc.nextInt(), x = sc.nextInt();
                addToK(k - 1, x);
            }
        }
        for (int i = head; i != -1 ; i = ne[i]) {
            System.out.print(e[i] + " ");
        }
    }
    // Ϊʲô��ʼ��Ϊ������ֵ
    static public void init() {
        head = -1;
        idx = 0;
    }
    static public void addToHead(int x) {
        // idxָ�����µĲ���ֵ
        e[idx] = x;
        ne[idx] = head;
        head = idx++;
    }
    static public void addToK(int k, int x) {
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx++;
    }
    static public void removeK(int k) {
        ne[k] = ne[ne[k]];
    }
}

 
 
