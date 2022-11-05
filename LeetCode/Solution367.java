package com.acwing.binary;

public class Solution367 {
    public boolean isPerfectSquare(int num) {
        int low = 0, high = num;
        int mid;
        long tempResult;
        while (low < high) {
            mid = low + (high - low) / 2;
            tempResult = (long) mid * mid;
            if (tempResult < num) {
                low = mid + 1;
            } else if (tempResult == num) {
                return true;
            } else {
                high = mid - 1;
            }
        }
        if ((long) low * low == num)    return true;
        return false;
    }
}
