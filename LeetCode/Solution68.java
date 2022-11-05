package com.acwing.binary;

public class Solution68 {

    public int mySqrt(int x) {
        long low = 0;
        long high = x;
        long mid;
        long ans = -1;
        while (low < high) {
            mid = low + high >> 1;
            if (mid * mid >= x) high = mid;
            else {
                ans = mid;
                low = mid + 1;
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int mid = 2147483647;
        System.out.println((mid + 1) / 2);
    }
}
