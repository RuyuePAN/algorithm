package com.acwing.binary;

import java.util.*;

//public class Main802 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(), m = sc.nextInt();
//        int N = 300010;     // 将x、l、r都保存在数组中，n + 2m < 300010
//        int[] a = new int[N];
//        int[] s = new int[N];
//
//        List<Integer> alls = new ArrayList<>();     // 将所有使用到的数字存在alls链表中
//        // 但其中会有先后顺序的差别，以及重复，所以需要排序和去重
//        List<Pairs> adds = new ArrayList<>();        // 用来存n次操作
//        List<Pairs> queries = new ArrayList<>();      // 用来存m次查询
//        for (int i = 0; i < n; i++) {
//            int x = sc.nextInt();
//            int c = sc.nextInt();
//            adds.add(new Pairs(x, c));
//            alls.add(x);        // 存入alls中，为后续操作做准备
//        }
//        for (int i = 0; i < m; i++) {
//            int l = sc.nextInt();
//            int r = sc.nextInt();
//            queries.add(new Pairs(l, r));
//            alls.add(l);
//            alls.add(r);
//        }
//        // 到此为止，alls中存好了所有会被用到的数轴上的点，可以进行离散化操作了
//        // 1. 排序  2. 去重
//        Collections.sort(alls);
//        int unique = unique(alls);      // 返回了不重复元素的个数
//        alls = alls.subList(0, unique); // 将去重之后的List保存下来，或者此处可以将unique作为最后一个数，
//
//        for (Pairs item:adds) {
//            int index = find(item.first, alls);
//            a[index] += item.second;
//        }
//
//        // 求前缀和
//        for (int i = 1; i <= alls.size(); i++) {
//            s[i] = s[i - 1] + a[i];
//        }
//        for (Pairs item:queries) {
//            int l = find(item.first, alls);
//            int r = find(item.second, alls);
//            System.out.println(s[r] - s[l - 1]);
//        }
//
//
//    }
//
//    // 去重
//    public static int unique(List<Integer> list) {
//        int j = 0;
//        for (int i = 0; i < list.size(); i++) {
//            if (i == 0 || !list.get(i).equals(list.get(i - 1))) {
//                list.set(j, list.get(i));
//                j++;
//            }
//        }
//        return j;
//    }
//
//    // 二分查找
//    static int find(int x, List<Integer> list) {
//        int l = 0;
//        int r = list.size() - 1;
//        while (l < r) {
//            int mid = l + r >> 1;
//            if (list.get(mid) >= x) r = mid;
//            else l = mid + 1;
//        }
//        return l + 1;       // 因为要考虑到前缀和
//    }
//}
//
//class  Pairs {
//    int first;
//    int second;
//    public Pairs(int first, int second) {
//        this.first = first;
//        this.second = second;
//    }
//}


public class Main802 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int N = 300010;     // 将所有x、l、r都保存在数组中，n + 2m < 300010
        int[] nums = new int[N];        // 经过add操作之后的数组
        int[] sum = new int[N];         // 前缀和数组
        List<Integer> alls = new ArrayList<>();     // 将所有用到的数字都存入
        // 会有先后顺序的差别，以及重复，所以需要排序和去重
        List<Pair> adds = new ArrayList<>();   // 存储n次操作
        List<Pair> queries = new ArrayList<>();// 存储m次查询

        // 加法操作
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int c = sc.nextInt();
            adds.add(new Pair(x, c));
            alls.add(x);            // 存入备用
        }

        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            queries.add(new Pair(l, r));
            alls.add(l);
            alls.add(r);
        }

        // 到目前为止alls已经存好所有数轴上需要的点，现在可以排序、去重了
        Collections.sort(alls);
        int unique = unique(alls);
        alls = alls.subList(0, unique);     // 将去重之后的List保存下来

        // 构造nums数组
        for (Pair item : adds) {
            int index = find(alls, item.first);    // find()的前提条件是数组排有序，所以我们在前面要排序
            nums[index] += item.second;
        }

        // 求前缀和数组sum
        for (int i = 1; i <= alls.size(); i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        for (Pair item : queries) {
            int l = find(alls, item.first);
            int r = find(alls, item.second);
            System.out.println(sum[r] - sum[l - 1]);
        }


    }
    // 返回的是不重复的元素的个数
    static int unique(List<Integer> alls) {
        int j = 0;
        for (int i = 0; i < alls.size(); i++) {
            if (i == 0 || !alls.get(i).equals(alls.get(i - 1))) {
                alls.set(j, alls.get(i));
                j++;
            }
        }
        return j;
    }

    static int find(List<Integer> list, int x) {
        int l = 0, r = list.size() - 1;
        int mid;
        while (l < r) {
            mid = l + r >> 1;
            if (list.get(mid) >= x) r = mid;
            else l = mid + 1;
        }
        return l + 1;   // 考虑到前缀和，因为返回的是索引，它在List中是l，但是对应到数组中应该+1
    }
}
class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}