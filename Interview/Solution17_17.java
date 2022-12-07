import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution17_17 {
    public static void main(String[] args) {
        Solution su = new Solution();
    }
}
// ֱ���õ�������뵽��trie������
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
        // ������ʾĳ���ڵ� 1. �Ǵ�β 2. ��big�ַ����е�����
        private int isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = -1;                     // ������Ǵ�β����-1�������Ϊ����ֵ�ô���big�е���ʼ����
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
            // ����ڵ㶼û�������ƶ�
            if (node == this) return ans;
            // ��ѯ��ϣ�˳�Žڵ�����
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