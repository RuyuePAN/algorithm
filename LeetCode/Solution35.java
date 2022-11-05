package com.acwing.binary;

public class Solution35 {
    public int searchInsert(int[] nums, int target) {

        int low = 0, high = nums.length - 1, mid;
        if (high == -1) {
            return 0;
        }

        while (low < high) {
            mid = low + high + 1 >> 1;
            if (nums[mid] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        if (nums[low] < target) {
            return low + 1;
        } else if (nums[low] > target){
            return Math.max(low - 1, 0);
        } else {
            return low;
        }
    }
}
