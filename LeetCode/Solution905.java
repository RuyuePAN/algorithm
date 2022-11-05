package com.acwing.sort;

public class Solution905 {

    public int[] sortArrayByParity(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int i = 0, j = nums.length - 1;
        int temp;
        while (i < j) {
            while (i < j && nums[i] % 2 == 0) {
                i++;
            }
            while (i < j && nums[j] % 2 == 1) {
                j--;
            }
            if (i < j) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }
}
