package com.acwing.binary;

import java.io.*;
import java.util.Scanner;

// 单调队列
public class Main154 {
//    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(new BufferedInputStream(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int[] nums = new int[n];
//        int[] q = new int[n];           // 一个模拟队列,队伍里装的是索引
//        int head = 0, tail = -1;         // 队头队尾指针
//        for (int i = 0; i < n; i++) {
//            int x = sc.nextInt();
//            nums[i] = x;
//        }
//        for (int i = 0; i < n; i++) {
//            // 窗口滑动：如果队首装的索引恰好在窗口的最左边，就需要出队
//            // 这里用if不用while，是因为最多只需要滑动一次，不可能滑动多次的
//            if (head <= tail && i - q[head] + 1 > k)    head++;
//            // 判断大小：如果即将入队的那个新元素比队伍的里的所有元素都更小，那就没有队伍里的所有元素什么事了，全都出队列吧
//            while (head <= tail && nums[q[tail]] >= nums[i]) tail--;
//            // 入队
//            q[++tail] = i;
//            if (i >= k - 1) bw.write(nums[q[head]] + " ");
//        }
//        bw.write("\n");
//        head = 0;
//        tail = -1;
//        for (int i = 0; i < n; i++) {
//            if (head <= tail && i - q[head] + 1 > k) head++;
//            while (head <= tail && nums[q[tail]] <= nums[i]) tail--;
//            q[++tail] = i;
//            if (i >= k - 1) bw.write(nums[q[head]] + " ");
//        }
//        bw.flush();
//        sc.close();
//        bw.close();
//    }

    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner reader = new Scanner(new InputStreamReader(System.in));
        int n = reader.nextInt();
        int k = reader.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = reader.nextInt();
        }
        int hh = 0, tt = -1;        // 队头队尾指针
        int[] queue = new int[n];   // 一个模拟队列，队伍里装的是索引
        // 输出滑窗内的最小值
        for (int i = 0; i < n; i++) {
            if (hh <= tt && i - queue[hh] + 1 > k) hh++;
            // 判断大小：如果即将入队的那个新元素比队里的所有元素都更小，那就没有队伍里的所有元素什么事了，全部出队吧
            while (tt >= hh && nums[queue[tt]] >= nums[i]) tt--;
            queue[++tt] = i;
            if (i >= k - 1) writer.write(nums[queue[hh]] + " ");
        }
        hh = 0;
        tt = -1;
        writer.write("\n");
        // 输出滑窗内的最大值
        for (int i = 0; i < n; i++) {
            if (hh <= tt && i - queue[hh] + 1 > k) hh++;
            while (tt >= hh && nums[queue[tt]] <= nums[i])  tt--;
            queue[++tt] = i;
            if (i >= k - 1) writer.write(nums[queue[hh]] + " ");
        }
        writer.flush();
        reader.close();
        writer.close();
    }
}










