package com.acwing.binary;

import com.sun.jdi.PathSearchingVirtualMachine;

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


//public class Main802 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(), m = sc.nextInt();
//        int N = 300010;     // 将所有x、l、r都保存在数组中，n + 2m < 300010
//        int[] nums = new int[N];        // 经过add操作之后的数组
//        int[] sum = new int[N];         // 前缀和数组
//        List<Integer> alls = new ArrayList<>();     // 将所有用到的数字都存入
//        // 会有先后顺序的差别，以及重复，所以需要排序和去重
//        List<Pair> adds = new ArrayList<>();   // 存储n次操作
//        List<Pair> queries = new ArrayList<>();// 存储m次查询
//
//        // 加法操作
//        for (int i = 0; i < n; i++) {
//            int x = sc.nextInt();
//            int c = sc.nextInt();
//            adds.add(new Pair(x, c));
//            alls.add(x);            // 存入备用
//        }
//
//        for (int i = 0; i < m; i++) {
//            int l = sc.nextInt();
//            int r = sc.nextInt();
//            queries.add(new Pair(l, r));
//            alls.add(l);
//            alls.add(r);
//        }
//
//        // 到目前为止alls已经存好所有数轴上需要的点，现在可以排序、去重了
//        Collections.sort(alls);
//        int unique = unique(alls);
//        alls = alls.subList(0, unique);     // 将去重之后的List保存下来
//
//        // 构造nums数组
//        for (Pair item : adds) {
//            int index = find(alls, item.first);    // find()的前提条件是数组排有序，所以我们在前面要排序
//            nums[index] += item.second;
//        }
//
//        // 求前缀和数组sum
//        for (int i = 1; i <= alls.size(); i++) {
//            sum[i] = sum[i - 1] + nums[i];
//        }
//
//        for (Pair item : queries) {
//            int l = find(alls, item.first);
//            int r = find(alls, item.second);
//            System.out.println(sum[r] - sum[l - 1]);
//        }
//
//
//    }
//    // 返回的是不重复的元素的个数
//    static int unique(List<Integer> alls) {
//        int j = 0;
//        for (int i = 0; i < alls.size(); i++) {
//            if (i == 0 || !alls.get(i).equals(alls.get(i - 1))) {
//                alls.set(j, alls.get(i));
//                j++;
//            }
//        }
//        return j;
//    }
//
//    static int find(List<Integer> list, int x) {
//        int l = 0, r = list.size() - 1;
//        int mid;
//        while (l < r) {
//            mid = l + r >> 1;
//            if (list.get(mid) >= x) r = mid;
//            else l = mid + 1;
//        }
//        return l + 1;   // 考虑到前缀和，因为返回的是索引，它在List中是l，但是对应到数组中应该+1
//    }
//}
//class Pair {
//    int first;
//    int second;
//
//    public Pair(int first, int second) {
//        this.first = first;
//        this.second = second;
//    }
//}

// try3:离散化
//class Main802 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(), m = sc.nextInt();
//        int N = 300010;         // 将所有的x、l、r保存在数组之中，n + 2m < 300010
//        int[] nums = new int[N];    // 经过add之后的数组
//        List<Integer> alls = new ArrayList<>();         // 所有用到的数字
//        // 会有先后顺序的差别，还会有重复，所以需要排序和去重
//        List<Pair> adds = new ArrayList<>();            // 存储n次操作
//        List<Pair> queries = new ArrayList<>();         // 存储m次查询操作
//        for (int i = 0; i < n; i++) {
//            int x = sc.nextInt();
//            int c = sc.nextInt();
//            adds.add(new Pair(x, c));
//            alls.add(x);
//        }
//
//        for (int i = 0; i < m; i++) {
//            int l = sc.nextInt();
//            int r = sc.nextInt();
//            queries.add(new Pair(l, r));
//            alls.add(l);
//            alls.add(r);
//        }
//
//        // alls上已经存入数轴上所有需要的点，现在可以排序，去重了
//        Collections.sort(alls);
//        int res = unique(alls);
//        alls = alls.subList(0, res);
//
//        // 构造nums数组
//        for (Pair item : adds) {
//            int index = find(alls, item.first);
//            nums[index] += item.second;
//        }
//
//        // 求前缀和数组
//        for (int i = 1; i <= res; i++) {
//            nums[i] += nums[i - 1];
//        }
//
//        // 输出查询结果
//        for (Pair item : queries) {
//            int left = find(alls, item.first);
//            int right = find(alls, item.second);
//
//            System.out.println(nums[right] - nums[left - 1]);
//        }
//
//
//    }
//
//    // 去重
//    public static int unique(List<Integer> alls) {
//        int res = alls.size();
//        // 删除重复元素
//        for (int i = 1; i < alls.size(); i++) {
//            while (alls.get(i).equals(alls.get(i - 1))) {
//                alls.remove(i);
//                res--;
//            }
//        }
//        return res;
//    }
//
//    // 返回的数字要加1
//    public static int find(List<Integer> arrs, int x) {
//        int low = 0, high = arrs.size() - 1;
//        int mid = 0;
//        while (arrs.get(mid) != x) {
//            mid = low + high >> 1;
//            if (arrs.get(mid) < x) {
//                low = mid + 1;
//            } else if (arrs.get(mid) == x) {
//                return mid + 1;
//            } else {
//                high = mid;
//            }
//        }
//        return mid + 1;     /////////////////////////////////
//    }
//}
//class Pair {
//    int first;
//    int second;
//    public Pair(int first, int second) {
//        this.first = first;
//        this.second = second;
//    }
//}

// try4
class Main802 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        ArrayList<Pair> adds = new ArrayList<>();            // 所有adds操作
        ArrayList<Pair> queries = new ArrayList<>();         // 所有queries操作
        ArrayList<Integer> alls = new ArrayList<>();         // 存储所有的数字(所有用到的数字：加操作，查询的上下界)
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int c = sc.nextInt();
            adds.add(new Pair(x, c));
            alls.add(x);
        }
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            queries.add(new Pair(l, r));
            alls.add(l);
            alls.add(r);
        }
        // 对所有用到的数字的链表，查询，去重
        Collections.sort(alls);
        int unique = unique(alls);
        alls.subList(0, unique);
        int[] nums = new int[unique + 1];            // 2m + n 个数字

        // 进行add操作
        for (Pair item : adds) {
            int index = find(alls, item.first);
            nums[index] += item.second;
        }
        for (int i = 0; i <= unique; i++) {
            System.out.print(nums[i] + " ");
        }
        // 求前缀数组和
        for (int i = 1; i <= unique; i++) {
            nums[i] += nums[i - 1];
        }
        // 查询
        for (Pair item : queries) {
            int left = find(alls, item.first);
            int right = find(alls, item.second);
            System.out.println(nums[right] - nums[left - 1]);
        }
    }

    // 去重
    public static int unique(ArrayList<Integer> arr) {
        int res = arr.size();
        for (int i = 1; i < res; i++) {
            if (arr.get(i).equals(arr.get(i - 1))) {
                arr.remove(i);
                res--;
            }
        }
        return res;
    }
    // 查询
    public static int find(ArrayList<Integer> arr, int x) {
        int low = 0, high = arr.size() - 1;
        int mid = low;
        while (low < high) {
            mid = low + high >> 1;
            if (arr.get(mid).equals(x)) {
                return mid + 1;
            } else if (arr.get(mid) < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low + 1;
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