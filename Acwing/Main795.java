package com.acwing.binary;

import java.util.Scanner;

public class Main795 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());

        int[] nums = new int[n + 1];
        int low;
        int high;
        // ÊäÈëÊı×é
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(sc.next());
            nums[i] = nums[i - 1] + nums[i];
        }
        while (m > 0) {
            low = Integer.parseInt(sc.next());
            high = Integer.parseInt(sc.next());
            System.out.println(nums[high] - nums[low - 1]);
            m--;
        }

    }
}
