package com.acwing.binary;

import java.util.Scanner;

//public class Main826 {
//    static int N = 100010;
//    /*
//        head表示头结点的下标
//        e[i]表示节点i的值
//        ne[i]表示节点i的next指针是多少
//        idx表示下一个可以存储元素的位置索引
//    */
//    static int head, idx;
//    static int[] e = new int[N];
//    static int[] ne = new int[N];
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();       // 操作次数
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
//    // 初始化函数
//    public static void init() {
//        head = -1;
//        idx = 0;
//    }
//    // 将x插到头结点
//    public static void addToHead(int x) {
//        // 新的点就是idx
//        e[idx] = x;
//        ne[idx] = head;     // idx指向的节点的下一个节点就是当前的head节点 ==》 成为头结点
//        head = idx++;       // 把头结点指向当前节点，先赋值，再递增
//    }
//    // 将x插入到k节点的后面
//    public static void addToK(int k, int x) {
//        e[idx] = x;
//        ne[idx] = ne[k];    // idx的下一个节点就是k节点的下一个节点
//        ne[k] = idx++;      // k节点的下一个节点就是idx
//    }
//    // 将k节点的下一个节点删掉
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
    // 为什么初始化为这两个值
    static public void init() {
        head = -1;
        idx = 0;
    }
    static public void addToHead(int x) {
        // idx指向最新的插入值
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

 
 
