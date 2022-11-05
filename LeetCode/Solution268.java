package com.acwing.binary;

public class Solution268 {
    // 做法一
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int low, high, mid;
        // 先快排
        quick_sort(nums, 0, n - 1);
        // 再二分查找

        while (n >= 0) {
            low = 0;
            high = nums.length - 1;
            while (low < high) {
                mid = low + high + 1 >> 1;
                if (nums[mid] <= n) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            if (nums[low] != n) {
                return n;
            }
            n--;
        }
        return -1;
    }

    public void quick_sort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = partition(nums, low, high);
            quick_sort(nums, low, mid - 1);
            quick_sort(nums, mid + 1, high);
        }
    }

    public int partition(int[] nums, int low, int high) {
        int temp = nums[high];
        while (low < high) {
            while (low < high && nums[low] <= temp) {
                low++;
            }
            nums[high] = nums[low];
            while (low < high && nums[high] >= temp) {
                high--;
            }
            nums[low] = nums[high];
        }
        nums[low] = temp;
        return low;
    }



}
