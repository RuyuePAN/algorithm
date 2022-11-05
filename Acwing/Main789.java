package com.acwing.binary;

import java.util.Scanner;

public class Main789 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.next());            // 读取数组长度
//        int queryNum = Integer.parseInt(sc.next());     // 读取查询个数
//        int[] nums = new int[n];
//        // 读取数组
//        for (int i = 0; i < n; i++) {
//            nums[i] = Integer.parseInt(sc.next());
//        }
//        int x;
//        int low, high, mid;
//
//        // 读取查询
//        while (queryNum-- > 0) {
//            x = Integer.parseInt(sc.next());
//            low = 0;
//            high = n - 1;
//            while (low < high) {
//                mid = low + high >> 1;
//                if (nums[mid] >= x) {
//                    high = mid;
//                } else {
//                    low = mid + 1;
//                }
//            }
//            if (nums[low] != x) {
//                System.out.println("1 1");
//            } else {
//                System.out.print(low + " ");
//                while (low < high) {
//                 mid = low + high + 1 >> 1;
//                 if (nums[mid] <= x) {
//                     low = mid;
//                 } else {
//                     high = mid - 1;
//                 }
//                    System.out.println(low);
//                }
//            }
//        }
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int queryNums = Integer.parseInt(sc.next());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(sc.next());
        }

        int mid;
        int x;
        while (queryNums-- > 0) {
            int low = 0, high = n - 1;
            x = Integer.parseInt(sc.next());
            while (low < high) {
                mid = low + high >> 1;
                if (nums[mid] >= x) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            if (nums[low] != x) {
                System.out.println("-1 -1");
            } else {
                System.out.print(low + " ");
                low = 0;
                high = n - 1;
                while (low < high) {
                    mid = low + high + 1 >> 1;
                    if (nums[mid] <= x) {
                        low = mid;
                    } else {
                        high = mid - 1;
                    }

                }
                System.out.println(low);
            }
        }
    }
}
