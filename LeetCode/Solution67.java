package com.acwing.sort;

public class Solution67 {
//    public String addBinary(String a, String b) {
//        int n = a.length();
//        int m = b.length();
//        int count = 0;          // 表示进位
//        int i = n - 1;
//        int j = m - 1;
//        String res = "";
//        while (i >= 0 && j >= 0) {
//            int bitSum = (int)a.charAt(i) + (int)b.charAt(j) - 2 * '0' + count;
//            if (bitSum <= 1) {
//                count = 0;
//                res = bitSum + res;
//            } else if (bitSum == 2) {
//                count = 1;
//                res = "0" + res;
//            } else if (bitSum == 3){
//                count = 1;
//                res = "1" + res;
//            }
//            i--;
//            j--;
//        }
//        while (i >= 0) {
//            int bitSum = (int)b.charAt(i) - '0' + count;
//            if (bitSum <= 1) {
//                count = 0;
//                res = bitSum + res;
//            } else if (bitSum == 2) {
//                count = 1;
//                res = "0" + res;
//            }
//            i--;
//        }
//        while (j >= 0) {
//            int bitSum = (int)a.charAt(j) - '0' + count;
//            if (bitSum <= 1) {
//                count = 0;
//                res = bitSum + res;
//            } else if (bitSum == 2) {
//                count = 1;
//                res = "0" + res;
//            }
//            j--;
//        }
//        if (count == 1) res = "1" + res;
//        return res;
//    }
//    public String addBinary(String a, String b) {
//        StringBuffer sb = new StringBuffer();
//        int carry = 0;
//        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
//            carry = i >= 0 ? carry + (int) a.charAt(i) - '0' : carry;
//            carry = j >= 0 ? carry + (int) b.charAt(j) - '0' : carry;
//            sb.insert(0, carry % 2);
//            carry /= 2;
//        }
//        if (carry == 1) sb.insert(0, carry);
//        return sb.toString();
//    }

    public String addBinary(String a, String b) {
        int x = Integer.parseInt(a, 2);
        int y = Integer.parseInt(b, 2);
        int answer = 0, carry = 0;
        while (y != 0) {
            System.out.println("y = " + y + "-----------------------------------------------");
            answer = x ^ y;
            carry = (x & y) << 1;
            x = answer;
            y = carry;
            System.out.println("answer = " + answer + " carry = " + carry);
        }
        return Integer.toBinaryString(x);
    }
}
