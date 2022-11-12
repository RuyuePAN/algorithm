package com.acwing.sort;

public class Solution1051 {
    // ����һ������
//    public int heightChecker(int[] heights) {
//        int n = heights.length;
//        int ans = 0;
//        // ���
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
    // ��������Ͱ����
    public int heightChecker(int[] heights) {
        // ֵ�ķ�Χ��1<=heights[i]<=100�������Ҫ1,2,...,100��һ��101��Ͱ
        int[] arr = new int[101];
        // ����heights�����е�ÿ��Ԫ�أ���Ԫ�ط���Ͱ��
        for (int height : heights) {
            arr[height]++;
        }
        int count = 0;
        for (int i = 0, j = 0; i < arr.length; i++) {
            // ���δ�ÿ��Ͱ��ȡ��Ԫ��
            while (arr[i]-- > 0) {
                // �ѡ�Ͱ��š��͡�heights�е�Ԫ�ء��Ա�
                if (heights[j++] != i)  count++;
            }
        }
        return count;
    }
}
