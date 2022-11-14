package com.acwing.binary;

import java.util.Scanner;

public class Main796 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next()), m = Integer.parseInt(sc.next()), q = Integer.parseInt(sc.next());
        int[][] nums = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                nums[i][j] = Integer.parseInt(sc.next());
                nums[i][j] = nums[i][j] + nums[i - 1][j] + nums[i][j - 1] - nums[i - 1][j - 1];
            }
        }
        int x1, y1, x2, y2;
        // Ñ¯ÎÊq´Î
        while (q-- > 0) {
            x1 = Integer.parseInt(sc.next());
            y1 = Integer.parseInt(sc.next());
            x2 = Integer.parseInt(sc.next());
            y2 = Integer.parseInt(sc.next());

            System.out.println(nums[x2][y2] - nums[x1 - 1][y2] - nums[x2][y1 - 1] + nums[x1 - 1][y1 - 1]);
        }
    }
}
