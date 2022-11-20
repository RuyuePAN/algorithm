package com.acwing.binary;

import java.util.EventListener;
import java.util.Scanner;

//public class Main827 {
//    static int N = 100010;
//    /*
//    * e[N]表示元素
//    * l[N]表示每个点左边是谁
//    * r[N]表示每个点右边是谁
//    * idx指向当前元素
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
//                remove(k + 1);  // 因为初始化加了两个节点，所以第k个数的下标为 k + 2 - 1
//            } else if (op.equals("IL")) {
//                int k = sc.nextInt();
//                int x = sc.nextInt();
//                add(l[k + 1], x);   // 第k个插入元素对应的索引为k + 1, l[k + 1] 为链表中上一个位置对应的索引
//            } else {
//                int k = sc.nextInt();
//                int x = sc.nextInt();
//                add(k + 1, x);
//            }
//        }
//
//        // 1代表着尾结点
//        for (int i = r[0]; i != 1; i = r[i]) {
//            System.out.print(e[i] + " ");
//        }
//    }
//
//    // 初始化
//    public static void init() {
//        // 如下初始化会导致第k个插入的元素的索引为 k + 1
//        r[0] = 1;       // 右端点：head -> next = tail
//        l[1] = 0;       // 左端点：tail -> pre = head
//        idx = 2;        // 加入两个节点
//    }
//
//    // 在下标是k的点的右边，插入x，对应的是第k - 1个插入元素右侧插入x
//    public static void add(int k, int x) {
//        e[idx] = x;
//        r[idx] = r[k];
//        l[idx] = k;
//        l[r[k]] = idx;
//        r[k] = idx++;
//    }
//    // 删除索引为k的元素，对应于删除第k - 1个插入元素
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
    static int[] e = new int[N];        // 链表中的所有元素
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
        r[0] = 1; // 右端点 head->next = tail
        l[1] = 0; // 左端点 tail->pre = head
        idx = 2;        // 增加两个端点
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
