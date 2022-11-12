package com.acwing.binary;

import java.util.Scanner;

// 最好是用快速选择排序
public class Main786 {
    static int k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        k = Integer.parseInt(sc.next());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(sc.next());
        }
        System.out.println(quick_sort(nums, 0, n - 1, k));
    }
    public static int quick_sort(int[] nums, int low, int high, int k) {
        if (low == high) return nums[low];

        int temp = nums[low];
        int i = low - 1, j = high + 1;
        while (i < j) {
            while (nums[++i] < temp);
            while (nums[--j] > temp);
            if (i < j) {
                int swapTemp = nums[i];
                nums[i] = nums[j];
                nums[j] = swapTemp;
            }
        }
        int s1 = j - low + 1;
        if (k <= s1) return quick_sort(nums, low, j, k);
        return quick_sort(nums,j + 1, high, k - s1);
    }
}