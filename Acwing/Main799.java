package com.acwing.binary;

import java.util.Scanner;

public class Main799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int[] nums = new int[n];
        int[] count = new int[100001];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(sc.next());
        }
        int res = 0;
        // 双指针
        for (int left = 0, right = 0; right < n; right++) {
            count[nums[right]]++;
            // 如果出现重复数字，左指针就右移
            while (count[nums[right]] > 1) {
                count[nums[left]]--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        System.out.println(res);
    }
}
