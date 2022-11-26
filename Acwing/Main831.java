package com.acwing.binary;

import java.io.*;

public class Main831 {
    /*
    * ��������ǣ�
    * 1. ���ƥ�������
    * 2. ûƥ���ϾͲ����
    * ��Ϊ�������裺
    * 1. ��ģʽ����ǰ׺����
    * 2. ƥ��ģʽ��
    * */
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//        int n = Integer.parseInt(reader.readLine());
//        String P = reader.readLine();
//        // ģʽ��p
//        char[] p = new char[n + 1];
//        for (int i = 1; i <= n; i++) {
//            p[i] = P.charAt(i - 1);
//        }
//        // ��next����
//        int[] next = new int[n + 1];
//
//        /*
//        * ����ǰ׺���飬��Ϊ��һ��ǰ׺���Ϊ0�����������Ǵ��±�1��ʼ�ǣ����Դ�i=2��ʼ����
//        * �󷨲��������ƥ�����
//        * ����������������ģʽ��ƥ��ģʽ��
//        * */
//        for (int i = 2, j = 0; i <= n; i++) {
//            while (j != 0 && p[i] != p[j + 1]) j = next[j];
//            if (p[i] == p[j + 1])   j++;
//            next[i] = j;
//        }
//
//        int m = Integer.parseInt(reader.readLine());
//        String S = reader.readLine();
//        char[] s = new char[m + 1];
//        for (int i = 1; i <= m; i++) {
//            s[i] = S.charAt(i - 1);
//        }
//
//        // ƥ��
//        for (int i = 1, j = 0; i <= m; i++) {
//            /*
//            * ѭ��ֹͣ������j = 0
//            * ��Ϊ�Ȿ�����һ��˫ָ�����⣬��j������ģʽ�����ƶ��ģ���jΪ0��ʱ���Ѿ���ͷ�ˣ��������ƶ��ˡ�
//            * ��ʱ���Ǿ���Ҫ��s[i]��p[1]���Ƚϣ�Ҳ���Ǻ�ģʽ���ĵ�һ���ַ����Ƚ�
//            * ����֮������j!=0������������Ϊ���j = 0 ͬʱ s[i] != p[j + 1]��ʱ�����ѭ��
//            * */
//            while (j != 0 && s[i] != p[j + 1]) j = next[j];
//            if (s[i] == p[j + 1])   j++;
//            // �������p��ƥ�����
//            if (j == n) {
//                writer.write(i - n + " ");
//                j = next[j];        // ��ȫƥ������������������һ����൱���������ƥ���ϵĽ��
//            }
//        }
//        writer.flush();//����write�µ����ݣ����ȴ���writers�У�������flush�Ժ󣬻�����������е����ݡ����û�е���flush���򲻻Ὣwriter�е����ݽ��������
//        writer.close();
//        reader.close();
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String P = reader.readLine();
        char[] p = new char[n + 1];
        int m = Integer.parseInt(reader.readLine());
        String S = reader.readLine();
        char[] s = new char[m + 1];
        for (int i = 1; i < n + 1; i++) {
            p[i] = P.charAt(i - 1);
        }
        for (int i = 1; i < m + 1; i++) {
            s[i] = S.charAt(i - 1);
        }
        int[] next = new int[n + 1];
        // ��ǰ׺����
        for (int i = 2, j = 0; i <= n; i++) {
            while (j != 0 && p[i] != p[j + 1])  j = next[j];
            if (p[i] == p[j + 1])   j++;
            next[i] = j;
        }
        // ƥ��
        for (int i = 1, j = 0; i <= m; i++) {
            while (j != 0 && s[i] != p[j + 1])  j = next[j];
            if (s[i] == p[j + 1])   j++;
            if (n == j) {
                writer.write(i - j);
                j = next[j];
            }
        }
        writer.flush();
        writer.close();
        reader.close();

    }
}
