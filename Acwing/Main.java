package com.acwing.binary;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());            // ��ȡ���鳤��
        int queryNum = Integer.parseInt(sc.next());     // ��ȡ��ѯ����
        int[] nums = new int[n];
        // ��ȡ����
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(sc.next());
        }
        int x;
        // ��ȡ��ѯ
        while(queryNum-- > 0) {
            x = Integer.parseInt(sc.next());          // xΪ����ѯ����
            int low = 0, high = n - 1;
            while(low < high) {
                int mid = low + high >> 1;
                if (nums[mid] >= x) high = mid;
                else low = mid + 1;
            }

            if (nums[low] != x) {
                System.out.println("-1 -1");
            } else {
                System.out.print(low + " ");
                low = 0;
                high = n - 1;
                while(low < high) {
                    int mid = low + high + 1 >> 1;
                    if (nums[mid] <= x) low = mid;
                    else high = mid - 1;
                }
                System.out.println(low);
            }
        }
    }
}
