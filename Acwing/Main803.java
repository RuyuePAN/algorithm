package com.acwing.binary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

//public class Main803 {
//    static class Pair {
//        int first;
//        int second;
//
//        public Pair(int first, int second) {
//            this.first = first;
//            this.second = second;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        ArrayList<Pair> sections = new ArrayList<>();
//        // �����������������
//        for (int i = 0; i < n; i++) {
//            sections.add(new Pair(sc.nextInt(), sc.nextInt()));
//        }
//
//        // ����ÿ�������l��������
//        sections.sort(new Comparator<Pair>() {
//            @Override
//            public int compare(Pair o1, Pair o2) {
//                return o1.first - o2.first;
//            }
//        });
//        int start = sections.get(0).first, end = sections.get(0).second;
//        int s1, e1, s2, e2;
//        int ans = 1;
//        // ��ʼ����ϲ�
//        for (int i = 1; i < n; i++) {
//            s1 = start;
//            e1 = end;
//            s2 = sections.get(i).first;
//            e2 = sections.get(i).second;
//            // �����һ��������һ�����������
//            if (e2 <= e1) {
//                // ����
//            }
//            // ���������������һ��������ཻ
//            else if (s2 <= e1) {
//                start = s1;
//                end = e2;
//            } else if (e1 < s2) {
//                start = s2;
//                end = e2;
//                ans++;
//            }
//        }
//        System.out.println(ans);
//    }
//}

// try2
class Main803 {
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
        ArrayList<Pair> scopes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            scopes.add(new Pair(sc.nextInt(), sc.nextInt()));
        }
        int res = 1;
        // ���������䰴����˵�����
        scopes.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.first - o2.first;
            }
        });
        /*
        * �����������
        * 1. y1 > y2 ����һ�����串���˵ڶ�������
        * 2. y1 < x2 : ��������ֿ�
        * 3. x2 <= y1 �������������ཻ
        * */
        for (int i = 1; i < n; i++) {
            int x1 = scopes.get(i - 1).first;
            int y1 = scopes.get(i - 1).second;
            int x2 = scopes.get(i).first;
            int y2 = scopes.get(i).second;

            if (y1 > y2) {
                scopes.set(i, new Pair(x1, y1));
            } else if (y1 < x2) {
                res++;
            } else if (x2 <= y1){
                scopes.set(i, new Pair(x1, y2));
            }
        }

        System.out.println(res);
    }
}
