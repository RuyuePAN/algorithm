package com.acwing.binary;

import java.util.ArrayList;

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        quick_sort(0, n - 1, nums1);
        quick_sort(0, m - 1, nums2);
        int i = 0, j = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        int tempNum = 1005;
        while (i < n && j < m) {
            if (nums1[i] < nums2[j])  {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                if (tempNum != nums1[i]) {
                    arr.add(nums1[i]);
                }
                tempNum = nums1[i];
                i++;
                j++;
            }
        }
        int[] res = new int[arr.size()];
        for (int k = 0; k < arr.size(); k++) {
            res[k] = arr.get(k);
        }
        return res;
    }
    public void quick_sort(int low, int high, int[] nums) {
        if (low < high) {
            int mid = partition(low, high, nums);
            quick_sort(low, mid - 1, nums);
            quick_sort(mid + 1, high, nums);
        }
    }
    public int partition(int low, int high, int[] nums) {
        int temp = nums[high];
        while (low < high) {
            while (low < high && nums[low] <= temp) {
                low++;
            }
            nums[high] = nums[low];
            while (low < high && nums[high] >= temp) {
                high--;
            }
            nums[low] = nums[high];
        }
        nums[low] = temp;
        return low;
    }
}
