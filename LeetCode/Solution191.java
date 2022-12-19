package com.acwing.sort;

public class Solution191 {

//    public int hammingWeight(int n) {
//        int res = 0;
//        while (n != 0) {
//            if ((n & 1) == 1)   res++;
//            // n = n >>> 1; >>´ø·ûºÅ£¬>>>²»´ø·ûºÅ
//            n >>>= 1;
//        }
//        return res;
//    }

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }
}
