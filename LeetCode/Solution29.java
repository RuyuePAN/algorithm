package com.acwing.sort;

public class Solution29 {
//    public int divide(int dividend, int divisor) {
//        // 讨论边界情况
//        // 被除数是最小值
//        if (dividend == Integer.MIN_VALUE) {
//            if (divisor == 1) return Integer.MIN_VALUE;
//            if (divisor == -1) return Integer.MAX_VALUE;
//        }
//        // 除数是最小值
//        if (divisor == Integer.MIN_VALUE) {
//            if (dividend == divisor) return 1;
//            else return 0;
//        }
//        // 被除数是0
//        if (divisor == 0) return 0;
//
//
//        // 普通情况：把所有数字转为负数，用rev用于标记最后是否需要把结果取反
//        boolean rev = false;
//        if (dividend > 0) {
//            dividend = -dividend;
//            rev = !rev;
//        }
//        if (divisor > 0) {
//            divisor = -divisor;
//            rev = !rev;
//        }
////        // 二分查找
////        int left = 1, right = Integer.MAX_VALUE, ans = 0;
////        while (left <= right) {
////            // 注意溢出，并且不能使用除法
////            int mid = left + ((right - left) >> 1);
////            boolean check = quickAdd(divisor, mid, dividend);
////            // 要寻找最大的那个z，使得z*y>=x
////            if (check) {
////                ans = mid;
////                // 注意溢出：如果mid已经是整数型的最大值了，就不能再+1了，否则会溢出
////                if (mid == Integer.MAX_VALUE)   break;
////                left = mid + 1;
////            } else right = mid - 1;
////        }
////        return rev ? -ans : ans;
////    }
////
////    // 快速乘：验证是否能有z*y>=x
////    // x 和 y 为负数，z为正数
////    public boolean quickAdd(int y, int z, int x) {
////        int result = 0, add = y;
////        while (z != 0) {
////            if ((z & 1) != 0) {
////                // 需要一直保证 result + add >= x
////                if (result < x - add) return false;
////                result += add;
////            }
////            if (z != 1) {
////                // 需要一直保证 add + add >= x
////                if (add < x - add)  return false;
////                add += add;
////            }
////            z >>= 1;
////        }
////        return true;
////    }
//
//        int left = 1, right = Integer.MAX_VALUE, ans = 0;
//
//        while (left <= right) {
//            int mid = left + ((right - left) >> 1);
//            if (quick(divisor, dividend, mid)) {
//                ans = mid;
//                // mid 已经是最大值了，不能再左移了，再左移就溢出了
//                if (mid == Integer.MAX_VALUE)   break;
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//
//        }
//        return rev ? -ans : ans;
//    }
//        public boolean quick(int divisor, int dividend, int mid) {
//            int add = mid;
//            int result = 0;
//            while (divisor != 0) {
//                if ((divisor & 1) == 1) {
//                    if (result + add < dividend)   return false;
//                    result += add;
//                }
//                if (divisor != 1) {
//                    if (add + add < dividend)  return false;
//                    add += add;
//                }
//                divisor >>= 1;
//            }
//            return true;
//        }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1)   return dividend;
            if (divisor == -1)  return Integer.MAX_VALUE;
        }
        if (divisor == Integer.MIN_VALUE) {
            if (divisor == dividend)   return 1;
            else return 0;
        }
        if (dividend == 0)  return 0;
        boolean rev = false;
        if (dividend > 0) {
            dividend = -dividend;
            rev = !rev;
        }
        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }
        int left = 1, right = Integer.MAX_VALUE;
        int ans = 0;
        while (left <= right) {
            // 先减后加，避免溢出
            int mid = left + ((right - left) >> 1);
            boolean check = quick(dividend, divisor, mid);
            System.out.println("check = " + check + " mid = " + mid);
            if (check) {
                ans = mid;
                if (mid == Integer.MAX_VALUE)   break;
                left = mid + 1;
            } else right = mid - 1;
        }
        return rev ? -ans : ans;

    }
    public boolean quick(int dividend, int divisor, int mid) {
        int result = 0;
        int add = divisor;
        while (mid != 0) {
            if ((mid & 1) == 1) {
                if (result < dividend - add) return false;
                result += add;
            }
            if (mid != 1) {
                if (add < dividend - add)   return false;
                add += add;
            }
            mid >>= 1;
        }
        return true;
    }
}