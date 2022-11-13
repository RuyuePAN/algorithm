public class Solution51 {
    int[] temp;
    public int reversePairs(int[] nums) {
        int n = nums.length;
        temp = new int[n];

        int res = mergeSort(nums, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        return res;
    }

    public int mergeSort(int[] nums, int left, int right) {
        if (left >= right)   return 0;
        int i = left, mid = left + right >> 1, j = mid + 1, k = 0;
        int res = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        while (i < mid && j < right) {
            if (nums[i] <= nums[j]) temp[k++] = nums[i++];
            else {
                temp[k++] = nums[j++];
                res += mid - left + 1;
            }
        }
        while (i < mid) temp[k++] = nums[i++];
        while (j < right) temp[k++] = nums[j++];
        for (i = left, j = 0; i < right; i++, j++) {
            nums[i] = temp[j];
        }
        return res;
    }
}
