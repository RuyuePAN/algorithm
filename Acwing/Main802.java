package com.acwing.binary;

import java.util.*;

//public class Main802 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(), m = sc.nextInt();
//        int N = 300010;     // ��x��l��r�������������У�n + 2m < 300010
//        int[] a = new int[N];
//        int[] s = new int[N];
//
//        List<Integer> alls = new ArrayList<>();     // ������ʹ�õ������ִ���alls������
//        // �����л����Ⱥ�˳��Ĳ���Լ��ظ���������Ҫ�����ȥ��
//        List<Pairs> adds = new ArrayList<>();        // ������n�β���
//        List<Pairs> queries = new ArrayList<>();      // ������m�β�ѯ
//        for (int i = 0; i < n; i++) {
//            int x = sc.nextInt();
//            int c = sc.nextInt();
//            adds.add(new Pairs(x, c));
//            alls.add(x);        // ����alls�У�Ϊ����������׼��
//        }
//        for (int i = 0; i < m; i++) {
//            int l = sc.nextInt();
//            int r = sc.nextInt();
//            queries.add(new Pairs(l, r));
//            alls.add(l);
//            alls.add(r);
//        }
//        // ����Ϊֹ��alls�д�������лᱻ�õ��������ϵĵ㣬���Խ�����ɢ��������
//        // 1. ����  2. ȥ��
//        Collections.sort(alls);
//        int unique = unique(alls);      // �����˲��ظ�Ԫ�صĸ���
//        alls = alls.subList(0, unique); // ��ȥ��֮���List�������������ߴ˴����Խ�unique��Ϊ���һ������
//
//        for (Pairs item:adds) {
//            int index = find(item.first, alls);
//            a[index] += item.second;
//        }
//
//        // ��ǰ׺��
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
//    // ȥ��
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
//    // ���ֲ���
//    static int find(int x, List<Integer> list) {
//        int l = 0;
//        int r = list.size() - 1;
//        while (l < r) {
//            int mid = l + r >> 1;
//            if (list.get(mid) >= x) r = mid;
//            else l = mid + 1;
//        }
//        return l + 1;       // ��ΪҪ���ǵ�ǰ׺��
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
        int N = 300010;     // ������x��l��r�������������У�n + 2m < 300010
        int[] nums = new int[N];        // ����add����֮�������
        int[] sum = new int[N];         // ǰ׺������
        List<Integer> alls = new ArrayList<>();     // �������õ������ֶ�����
        // �����Ⱥ�˳��Ĳ���Լ��ظ���������Ҫ�����ȥ��
        List<Pair> adds = new ArrayList<>();   // �洢n�β���
        List<Pair> queries = new ArrayList<>();// �洢m�β�ѯ

        // �ӷ�����
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int c = sc.nextInt();
            adds.add(new Pair(x, c));
            alls.add(x);            // ���뱸��
        }

        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            queries.add(new Pair(l, r));
            alls.add(l);
            alls.add(r);
        }

        // ��ĿǰΪֹalls�Ѿ����������������Ҫ�ĵ㣬���ڿ�������ȥ����
        Collections.sort(alls);
        int unique = unique(alls);
        alls = alls.subList(0, unique);     // ��ȥ��֮���List��������

        // ����nums����
        for (Pair item : adds) {
            int index = find(alls, item.first);    // find()��ǰ����������������������������ǰ��Ҫ����
            nums[index] += item.second;
        }

        // ��ǰ׺������sum
        for (int i = 1; i <= alls.size(); i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        for (Pair item : queries) {
            int l = find(alls, item.first);
            int r = find(alls, item.second);
            System.out.println(sum[r] - sum[l - 1]);
        }


    }
    // ���ص��ǲ��ظ���Ԫ�صĸ���
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
        return l + 1;   // ���ǵ�ǰ׺�ͣ���Ϊ���ص�������������List����l�����Ƕ�Ӧ��������Ӧ��+1
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