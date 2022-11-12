package com.acwing.sort;

public class Solution1051 {
    // 做法一：快排
//    public int heightChecker(int[] heights) {
//        int n = heights.length;
//        int ans = 0;
//        // 深拷贝
//        int[] nums = heights.clone();
//        quickSelectSort(nums, 0, n - 1);
//
//        for (int i = 0; i < n; i++) {
//            if (nums[i] != heights[i]) ans++;
//        }
//        return ans;
//    }
//
//    public void quickSelectSort(int[] nums, int low, int high) {
//        if (low == high)    return;
//        int i = low - 1, j = high + 1, temp = nums[low];
//        int swapTemp;
//        while (i < j) {
//            while (nums[++i] < temp);
//            while (nums[--j] > temp);
//            if (i < j) {
//                swapTemp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = swapTemp;
//            }
//        }
//        quickSelectSort(nums, low, j);
//        quickSelectSort(nums, j + 1, high);
//    }
    // 做法二：桶排序
    public int heightChecker(int[] heights) {
        // 值的范围是1<=heights[i]<=100，因此需要1,2,...,100，一共101个桶
        int[] arr = new int[101];
        // 遍历heights数组中的每个元素，把元素放入桶中
        for (int height : heights) {
            arr[height]++;
        }
        int count = 0;
        for (int i = 0, j = 0; i < arr.length; i++) {
            // 依次从每个桶中取出元素
            while (arr[i]-- > 0) {
                // 把【桶序号】和【heights中的元素】对比
                if (heights[j++] != i)  count++;
            }
        }
        return count;
    }
}
