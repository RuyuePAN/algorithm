package com.acwing.sort;

public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        return quickSelectSort(nums, 0, nums.length - 1, nums.length - k + 1);
    }
    public int quickSelectSort(int[] nums, int low, int high, int k) {
        if (low == high)    return nums[low];
        int i = low - 1, j = high + 1, temp = nums[low];
        int swap;
        while (i < j) {
            while (nums[++i] < temp);
            while (nums[--j] > temp);
            if (i < j) {
                swap = nums[i];
                nums[i] = nums[j];
                nums[j] = swap;
            }
        }
        int left = j - low + 1;
        if (k <= left) return quickSelectSort(nums, low, j, k);
        return quickSelectSort(nums, j + 1, high, k - left);
    }
}
