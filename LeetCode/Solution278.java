package com.acwing.binary;

public class Solution278 extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        int mid = 1;
        while (low < high) {
            mid = low + (high - low >> 1);
            if (!isBadVersion(mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
class VersionControl {
    boolean isBadVersion(int version){
        return false;
    };
}
