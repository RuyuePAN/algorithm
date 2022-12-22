package com.acwing.sort;

public class Solution137 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i) & 1;
            }
            // �ͳ���3������
            ans |= (sum % 3 << i);
        }
        return ans;
    }
}
