package com.acwing.sort;

public class Solution461 {
    public int hammingDistance(int x, int y) {
        int res = 0;
        // x��y���Ϊ31λ
        for (int i = 0; i < 31; i++) {
            if (((x >> i) & 1) != ((y >> i) & 1)) res++;
        }
        return res;
    }
}
