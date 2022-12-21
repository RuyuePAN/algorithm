package com.acwing.sort;

public class Solution260 {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }
        // 最小的为1的数位：原数 11100  lowBit 100
        int lowBit = xor & (-xor);
        for (int num : nums) {
            if ((lowBit & num) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
