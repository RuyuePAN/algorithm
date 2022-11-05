package com.acwing.sort;


import java.util.Scanner;

public class quickSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = (int) 1e+6;
        int n;

        // 手动输入数组长度
        System.out.println("请输入数组长度：");
        n = Integer.parseInt(sc.next());
        System.out.println("好的，数组长度为：" + n);

        int[] q = new int[n];

        // 输入数组元素
        System.out.println("现在请分别输入" + n + "个数组元素（以回车分割数组元素）：");
        for (int i = 0; i < q.length; i++) {
            q[i] = Integer.parseInt(sc.next());
        }
        System.out.println("输入完毕！您输入的数组为：");
        for (int i = 0; i < q.length; i++) {
            System.out.print(q[i] + " ");
        }

        System.out.println("现在开始排序...");

        quick_sort(q, 0, n - 1);


        System.out.println("排序完毕！排序后的数组为：");
        for (int i = 0; i < q.length; i++) {
            System.out.print(q[i] + " ");
        }
    }

    public static void quick_sort(int[] q, int l, int r) {
        // 边界里没有数字，或者只有一个数字，就不用排序了
        if (l >= r) {
            return;
        }

        // x随便取一个边界点，可以取q[l]、q[r]、q[(l + r) / 2]
        int x = q[l], i = l - 1, j = r + 1;

        while (i < j) {
            // i指针右移
            do {
                i++;
            } while (q[i] < x);
            // j指针左移
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
