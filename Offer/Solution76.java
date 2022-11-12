
public class Solution76 {
    /**
     * 因为要求时间复杂度为O(n)所以用快速选择排序
     * 而快排的时间复杂度为O(nlgn)
     **/
    public int findKthLargest(int[] nums, int k) {
        return quickSelectSort(nums, 0, nums.length - 1, nums.length -  k + 1);
    }

    public int quickSelectSort(int[] nums, int low, int high, int k) {
        if (low == high)    return nums[low];
        int i = low - 1, j = high + 1, temp = nums[low];
        int swapNum;
        while (i < j) {
            while (nums[++i] < temp);
            while (nums[--j] > temp);
            // 交换两个数字
            if (i < j) {
                swapNum = nums[i];
                nums[i] = nums[j];
                nums[j] = swapNum;
            }
        }
        // 左边的长度
        int left = j - low + 1;
        // 左边找
        if (left >= k) return quickSelectSort(nums, low, j, k);
        // 右边找
        return quickSelectSort(nums, j + 1, high, k - left);

    }
}