package com.acwing.binary;

public class binaryQuery {
    // 检查是否成立
    public boolean check(int mid) {
        return false;
    }
    // 区间[low, high]被划分为[low, mid]和[mid + 1, high]使用
    public int bSearch1(int low, int high) {
        while (low < high) {
            int mid = low + high >> 1;
            if (check(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // 区间[low, high]被划分为[low, mid - 1]和[mid, high]使用
    public int bSearch(int low, int high) {
        while (low < high) {
            int mid = low + high + 1 >> 1;
            if (check(mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    // 我的模板
    public static int binary_search(int[] nums, int x) {
        int low = 0, high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = low + high >> 1;
            if (nums[mid] == x) {
                return mid;
            }
            if (nums[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 5, 8, 11, 15, 20};
        System.out.println(binary_search(nums, 15));
    }
}
