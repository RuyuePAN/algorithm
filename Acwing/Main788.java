package com.acwing.binary;

import java.util.Scanner;

public class Main788 {
    static int[] temp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int[] nums = new int[n];
        temp = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(sc.next());
        }
        System.out.println(merge_sort(nums,0, n - 1));
    }

    public static long merge_sort(int[] nums, int left, int right) {
        if (left >= right)  return 0;
        int mid = left + right >> 1;
        long res = merge_sort(nums, left, mid) + merge_sort(nums, mid + 1, right);

        // 归并的过程
        int k = 0, i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            }
            else {
                temp[k++] = nums[j++];
                res += mid - i + 1;
            }
        }
        // 扫尾
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right)  temp[k++] = nums[j++];
        
        // 把临时数组放回去
        for (i = left, j = 0; i <= right ; i++, j++) {
            nums[i] = temp[j];
        }
        return res;
    }
}
