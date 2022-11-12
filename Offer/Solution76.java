
public class Solution76 {
    /**
     * ��ΪҪ��ʱ�临�Ӷ�ΪO(n)�����ÿ���ѡ������
     * �����ŵ�ʱ�临�Ӷ�ΪO(nlgn)
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
            // ������������
            if (i < j) {
                swapNum = nums[i];
                nums[i] = nums[j];
                nums[j] = swapNum;
            }
        }
        // ��ߵĳ���
        int left = j - low + 1;
        // �����
        if (left >= k) return quickSelectSort(nums, low, j, k);
        // �ұ���
        return quickSelectSort(nums, j + 1, high, k - left);

    }
}