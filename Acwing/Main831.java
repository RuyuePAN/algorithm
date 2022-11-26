package com.acwing.binary;

import java.io.*;

public class Main831 {
    /*
    * 这个代码是：
    * 1. 多次匹配多次输出
    * 2. 没匹配上就不输出
    * 分为两个步骤：
    * 1. 求模式串的前缀数组
    * 2. 匹配模式串
    * */
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//        int n = Integer.parseInt(reader.readLine());
//        String P = reader.readLine();
//        // 模式串p
//        char[] p = new char[n + 1];
//        for (int i = 1; i <= n; i++) {
//            p[i] = P.charAt(i - 1);
//        }
//        // 求next数组
//        int[] next = new int[n + 1];
//
//        /*
//        * 计算前缀数组，因为第一个前缀结果为0，而且我们是从下标1开始记，所以从i=2开始遍历
//        * 求法参照下面的匹配的求法
//        * 但是我们在这里用模式串匹配模式串
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
//        // 匹配
//        for (int i = 1, j = 0; i <= m; i++) {
//            /*
//            * 循环停止条件是j = 0
//            * 因为这本身就是一个双指针问题，而j就是在模式串上移动的，当j为0的时候已经到头了，不能再移动了。
//            * 此时我们就是要拿s[i]和p[1]作比较，也就是和模式串的第一个字符做比较
//            * 这里之所以有j!=0的条件，是因为如果j = 0 同时 s[i] != p[j + 1]的时候会死循环
//            * */
//            while (j != 0 && s[i] != p[j + 1]) j = next[j];
//            if (s[i] == p[j + 1])   j++;
//            // 如果整个p都匹配完成
//            if (j == n) {
//                writer.write(i - n + " ");
//                j = next[j];        // 完全匹配后继续搜索，有了这一句就相当于输出所有匹配上的结果
//            }
//        }
//        writer.flush();//所有write下的内容，会先存在writers中，当启用flush以后，会输出存在其中的内容。如果没有调用flush，则不会将writer中的内容进行输出。
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
        // 求前缀数组
        for (int i = 2, j = 0; i <= n; i++) {
            while (j != 0 && p[i] != p[j + 1])  j = next[j];
            if (p[i] == p[j + 1])   j++;
            next[i] = j;
        }
        // 匹配
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
