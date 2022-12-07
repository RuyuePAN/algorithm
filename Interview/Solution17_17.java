import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution17_17 {
    public static void main(String[] args) {
        Solution su = new Solution();
    }
}
// 直接拿到提很难想到用trie树来做
class Solution {
    public int[][] multiSearch(String big, String[] smalls) {
        Trie trie = new Trie();
        for (int i = 0; i < big.length(); i++) {
            trie.insert(big.substring(i), i);
        }
        int[][] ans = new int[smalls.length][];
        for (int i = 0; i < smalls.length; i++) {
            ans[i] = trie.query(smalls[i]);
        }
        return ans;
    }
    public class Trie {
        private Trie[] children;
        // 用来表示某个节点 1. 是词尾 2. 在big字符串中的索引
        private int isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = -1;                     // 如果不是词尾就是-1，否则就为它赋值该词在big中的起始索引
        }

        public void insert(String word, int idxBig) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (node.children[idx] == null) node.children[idx] = new Trie();
                node = node.children[idx];
            }
            node.isEnd = idxBig;
        }

        public int[] query(String word) {
            Trie node = this;
            int[] ans = {};
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (node.children[idx] == null) return ans;
                node = node.children[idx];
            }
            // 如果节点都没有往下移动
            if (node == this) return ans;
            // 查询完毕，顺着节点往下
            ArrayList<Integer> res = queryIsEnd(node);
            res.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            ans = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                ans[i] = res.get(i);
            }
            return ans;
        }
        // DFS
        public ArrayList<Integer> queryIsEnd(Trie node) {
            ArrayList<Integer> res = new ArrayList<>();
            if (node == null)   return res;
            if (node.isEnd != -1)   res.add(node.isEnd);
            for (int i = 0; i < 26; i++) {
                ArrayList<Integer> tempRes =  queryIsEnd(node.children[i]);
                for (int tmp : tempRes) res.add(tmp);
            }
            return res;
        }
    }
}