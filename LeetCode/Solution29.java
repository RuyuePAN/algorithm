package com.acwing.sort;

public class Solution29 {
//    public int divide(int dividend, int divisor) {
//        // ���۱߽����
//        // ����������Сֵ
//        if (dividend == Integer.MIN_VALUE) {
//            if (divisor == 1) return Integer.MIN_VALUE;
//            if (divisor == -1) return Integer.MAX_VALUE;
//        }
//        // ��������Сֵ
//        if (divisor == Integer.MIN_VALUE) {
//            if (dividend == divisor) return 1;
//            else return 0;
//        }
//        // ��������0
//        if (divisor == 0) return 0;
//
//
//        // ��ͨ���������������תΪ��������rev���ڱ������Ƿ���Ҫ�ѽ��ȡ��
//        boolean rev = false;
//        if (dividend > 0) {
//            dividend = -dividend;
//            rev = !rev;
//        }
//        if (divisor > 0) {
//            divisor = -divisor;
//            rev = !rev;
//        }
////        // ���ֲ���
////        int left = 1, right = Integer.MAX_VALUE, ans = 0;
////        while (left <= right) {
////            // ע����������Ҳ���ʹ�ó���
////            int mid = left + ((right - left) >> 1);
////            boolean check = quickAdd(divisor, mid, dividend);
////            // ҪѰ�������Ǹ�z��ʹ��z*y>=x
////            if (check) {
////                ans = mid;
////                // ע����������mid�Ѿ��������͵����ֵ�ˣ��Ͳ�����+1�ˣ���������
////                if (mid == Integer.MAX_VALUE)   break;
////                left = mid + 1;
////            } else right = mid - 1;
////        }
////        return rev ? -ans : ans;
////    }
////
////    // ���ٳˣ���֤�Ƿ�����z*y>=x
////    // x �� y Ϊ������zΪ����
////    public boolean quickAdd(int y, int z, int x) {
////        int result = 0, add = y;
////        while (z != 0) {
////            if ((z & 1) != 0) {
////                // ��Ҫһֱ��֤ result + add >= x
////                if (result < x - add) return false;
////                result += add;
////            }
////            if (z != 1) {
////                // ��Ҫһֱ��֤ add + add >= x
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
//                // mid �Ѿ������ֵ�ˣ������������ˣ������ƾ������
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
            // �ȼ���ӣ��������
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