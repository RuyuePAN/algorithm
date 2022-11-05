package com.acwing.sort;

import java.util.Arrays;
import java.util.Enumeration;

public class Solution2418 {
//    public String[] sortPeople(String[] names, int[] heights) {
//
//        // 排序heights数组
//        quick_sort(names, heights, 0, heights.length - 1);
//        return names;
//
//    }
//
//    public void quick_sort(String[] names, int[] nums, int left, int right) {
//
//        // 如果两个边界靠在一起就没必要继续排序
//        if (left >= right) {
//            return;
//        }
//        // 找到边界数字
//        int x = nums[left], i = left - 1, j = right + 1;
//        while (i < j) {
//            do {
//                i++;
//            } while (nums[i] > x);
//            do {
//                j--;
//            } while (nums[j] < x);
//            // 交换两个数字
//            if (i < j) {
//                int temp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = temp;
//
//                String tempName = names[i];
//                names[i] = names[j];
//                names[j] = tempName;
//            }
//        }
//        quick_sort(names, nums, left, j);
//        quick_sort(names, nums, j + 1, right);
//
//    }










//    public String[] sortPeople(String[] names, int[] heights) {
//        quick_sort(heights, names, 0, heights.length - 1);
//        return names;
//    }
//
//
//    public int[] quick_sort(int[] arr, String[] names, int left, int right) {
//        // left 左边界
//        // right 右边界
//        if (left < right) {
//            int partitionIndex = partition(arr, names, left, right);
//            quick_sort(arr, names, left, partitionIndex - 1);
//            quick_sort(arr, names,partitionIndex + 1, right);
//        }
//        return arr;
//    }
//
//    private int partition(int[] arr, String[] names, int left, int right) {
//        // 设定基准值（pivot）
//        int pivot = left;
//        int index = pivot + 1;
//        // index 记录数组中比基准数小的数的 最大数组下标
//        for (int i = index; i <= right; i++) {
//            // 大于目标值基准值 交换位置
//            if (arr[i] > arr[pivot]) {
//                swap(arr, i, index);
//                swap(names, i, index);
//                index++;
//            }
//        }
//        swap(arr, pivot, index - 1);
//        return index - 1;
//    }
//
//    private void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//
//    private void swap(String[] arr, int i, int j) {
//        String temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }

    public String[] sortPeople(String[] names, int[] heights) {
        quick_sort(names, heights, 0, heights.length - 1);
        return names;
    }

    public void quick_sort(String[] name, int[] heights, int low, int high) {
        if (low < high) {
            int midValue = partition(name, heights, low, high);
            quick_sort(name, heights, low, midValue - 1);
            quick_sort(name, heights, midValue + 1, high);
        }
    }

    public int partition(String[] name, int[] heights, int low, int high) {
        int pivot = heights[high];
        String pivotName = name[high];
        while (low < high) {
            while (low < high && heights[low] >= pivot) {
                low++;
            }
            heights[high] = heights[low];
            name[high] = name[low];
            while (low < high && heights[high] <= pivot) {
                high--;
            }
            heights[low] = heights[high];
            name[low] = name[high];
        }
        heights[low] = pivot;
        name[low] = pivotName;
        return low;
    }
}
