package com.acwing.binary;

import java.util.Scanner;

public class Main790 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = Float.parseFloat(sc.next());

        double low = -10e4, high = 10e4;
        double mid = -1;

        while (high - low >= 10e-8) {
            mid = (low + high) / 2;
            if (mid * mid * mid >= x)   high = mid;
            else low = mid;
        }
        System.out.println(String.format("%.6f", low));
        System.out.println(low);

    }
}
