package com.acwing.sort;

public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        quick_sort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public void quick_sort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = partition(nums, low, high);
            quick_sort(nums, low, mid - 1);
            quick_sort(nums, mid + 1, high);
        }
    }

    // �ҵ����
    public int partition(int[] nums, int low, int high) {
        // �趨��׼ֵ pivot
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            nums[high] = nums[low];
        }
        // ������ֵ��λ
        nums[low] = pivot;
        // ��������λ��
        return low;
    }


}
