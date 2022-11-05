package com.acwing.sort;

import java.util.Scanner;

public class mergeSort {
    static int[] temp;
    static int[] q;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = (int) 1e+6;
        int n;

        // 手动输入数组长度
        System.out.println("请输入数组长度：");
        n = Integer.parseInt(sc.next());
        System.out.println("好的，数组长度为：" + n);

        q = new int[n];
        temp = new int[n];

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

        merge_sort(q, 0, n - 1);
        System.out.println("排序完成！");

        for (int i = 0; i < q.length; i++) {
            System.out.print(q[i] + " ");
        }
    }

     static void merge_sort(int[] q, int low, int high) {
        if (low >= high)    {
            return;
        }

        int mid = low + high >> 1;
        merge_sort(q, low, mid);
        merge_sort(q, mid + 1, high);
        int k = 0, i = low, j = mid + 1;
        while (i <= mid && j <= high) {
            if (q[i] <= q[j]) {
                temp[k++] = q[i++];
            } else {
                temp[k++] = q[j++];
            }
        }
        // 如果左半边没有循环完
        while (i <= mid) {
            temp[k++] = q[i++];
        }
        // 如果右半边没有循环完
         while (j <= high) {
             temp[k++] = q[j++];
         }
         for (i = low, j = 0; i <= high; i++, j++) {
             q[i] = temp[j];
         }
    }
}
