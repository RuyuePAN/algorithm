package com.acwing.binary;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());            // 读取数组长度
        int queryNum = Integer.parseInt(sc.next());     // 读取查询个数
        int[] nums = new int[n];
        // 读取数组
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(sc.next());
        }
        int x;
        // 读取查询
        while(queryNum-- > 0) {
            x = Integer.parseInt(sc.next());          // x为待查询数字
            int low = 0, high = n - 1;
            while(low < high) {
                int mid = low + high >> 1;
                if (nums[mid] >= x) high = mid;
                else low = mid + 1;
            }

            if (nums[low] != x) {
                System.out.println("-1 -1");
            } else {
                System.out.print(low + " ");
                low = 0;
                high = n - 1;
                while(low < high) {
                    int mid = low + high + 1 >> 1;
                    if (nums[mid] <= x) low = mid;
                    else high = mid - 1;
                }
                System.out.println(low);
            }
        }
    }
}
