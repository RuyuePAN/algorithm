package com.acwing.sort;

import java.util.TreeMap;

public class Solution421 {
    public int findMaximumXOR(int[] nums) {
        TireTree tree = new TireTree();
        for (int num : nums) {
            tree.insert(num);
        }
        int res = 0;
        for (int num : nums) {
            res = Math.max(res, num ^ tree.search(num));
        }
        return res;
    }

    public class TireTree {
        private TireTree[] child;
        private int end;
        public TireTree() {
            child = new TireTree[2];
            end = -1;
        }


        public void insert(int num) {
            TireTree node = this;
            for (int i = 30; i >= 0; i--) {
                int p = (num >> i) & 1;
                if (node.child[p] == null)  node.child[p] = new TireTree();
                node = node.child[p];
            }
            node.end = num;
        }
        /*
        * 给定一个数，在trie树中查找和它的异或伙伴
        * */
        public int search(int num) {
            TireTree node = this;
            for (int i = 30; i >= 0; i--) {
                int p = (num >> i) & 1;
                if (node.child[p ^ 1] == null) node = node.child[p];
                else node = node.child[p ^ 1];
            }
            return node.end;
        }
    }
}
