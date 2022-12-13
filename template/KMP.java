package com.acwing.binary;

import java.io.*;

public class KMP {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());               // 模式串长度
        String P = reader.readLine();               // 模式串
        int m = Integer.parseInt(reader.readLine());               // 字符串长度
        String S = reader.readLine();               // 字符串


        char[] p = new char[n + 1];
        char[] s = new char[m + 1];

        for (int i = 1; i <= n; i++) {
            p[i] = P.charAt(i - 1);
        }
        for (int i = 1; i <= m; i++) {
            s[i] = S.charAt(i - 1);
        }

        int[] next = new int[n + 1];

        // 计算next数组
        for (int i = 2, j = 0; i <= n; i++) {
            while (j != 0 && p[i] != p[j + 1])  j = next[j];
            if (p[i] == p[j + 1])   j++;
            next[i] = j;
        }

        for (int i = 1, j = 0; i <= m; i++) {
            while (j != 0 && s[i] != p[j + 1])  j = next[j];
            if (s[i] == p[j + 1])   j++;
            if (j == n) {
                writer.write(i - j + " ");
                j = next[j];
            }
        }
        writer.flush();
        writer.close();
        reader.close();
    }
}