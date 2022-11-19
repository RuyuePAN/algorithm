package com.acwing.binary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main803 {
    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Pair> sections = new ArrayList<>();
        // 接收所有输入的区间
        for (int i = 0; i < n; i++) {
            sections.add(new Pair(sc.nextInt(), sc.nextInt()));
        }

        // 按照每个区间的l升序排列
        sections.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.first - o2.first;
            }
        });
        int start = sections.get(0).first, end = sections.get(0).second;
        int s1, e1, s2, e2;
        int ans = 1;
        // 开始区间合并
        for (int i = 1; i < n; i++) {
            s1 = start;
            e1 = end;
            s2 = sections.get(i).first;
            e2 = sections.get(i).second;
            // 【情况一】：区间一包含了区间二
            if (e2 <= e1) {
                // 不变
            }
            // 【情况二】：区间一和区间二相交
            else if (s2 <= e1) {
                start = s1;
                end = e2;
            } else if (e1 < s2) {
                start = s2;
                end = e2;
                ans++;
            }
        }
        System.out.println(ans);
    }
}

