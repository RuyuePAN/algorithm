package com.acwing.binary;

import java.io.*;
import java.util.Scanner;

// ��������
public class Main154 {
//    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(new BufferedInputStream(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int[] nums = new int[n];
//        int[] q = new int[n];           // һ��ģ�����,������װ��������
//        int head = 0, tail = -1;         // ��ͷ��βָ��
//        for (int i = 0; i < n; i++) {
//            int x = sc.nextInt();
//            nums[i] = x;
//        }
//        for (int i = 0; i < n; i++) {
//            // ���ڻ������������װ������ǡ���ڴ��ڵ�����ߣ�����Ҫ����
//            // ������if����while������Ϊ���ֻ��Ҫ����һ�Σ������ܻ�����ε�
//            if (head <= tail && i - q[head] + 1 > k)    head++;
//            // �жϴ�С�����������ӵ��Ǹ���Ԫ�رȶ�����������Ԫ�ض���С���Ǿ�û�ж����������Ԫ��ʲô���ˣ�ȫ�������а�
//            while (head <= tail && nums[q[tail]] >= nums[i]) tail--;
//            // ���
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
        int hh = 0, tt = -1;        // ��ͷ��βָ��
        int[] queue = new int[n];   // һ��ģ����У�������װ��������
        // ��������ڵ���Сֵ
        for (int i = 0; i < n; i++) {
            if (hh <= tt && i - queue[hh] + 1 > k) hh++;
            // �жϴ�С�����������ӵ��Ǹ���Ԫ�رȶ��������Ԫ�ض���С���Ǿ�û�ж����������Ԫ��ʲô���ˣ�ȫ�����Ӱ�
            while (tt >= hh && nums[queue[tt]] >= nums[i]) tt--;
            queue[++tt] = i;
            if (i >= k - 1) writer.write(nums[queue[hh]] + " ");
        }
        hh = 0;
        tt = -1;
        writer.write("\n");
        // ��������ڵ����ֵ
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










