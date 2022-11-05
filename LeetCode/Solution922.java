package com.acwing.sort;

public class Solution922 {

    public int[] sortArrayByParityII(int[] nums) {
        int j;
        for (int i = 0; i < nums.length; i++) {
            // 奇偶性和索引的奇偶性不相等
            if (nums[i] % 2 != i % 2) {
              j = i + 1;
              while (j < nums.length) {
                  if (nums[j] % 2 != j % 2) {
                      int temp = nums[i];
                      nums[i] = nums[j];
                      nums[j] = temp;
                      break;
                  }
                  j += 2;
              }
            }
        }
        return nums;
    }
}
