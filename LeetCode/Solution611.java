package com.acwing.sort;

import java.util.HashMap;
import java.util.HashSet;

public class Solution611 {
}

class MapSum {

    private MapSum[] children;
    private int value;
    private HashMap<String, Integer> map;
    public MapSum() {
        children = new MapSum[26];
        value = 0;
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int updateVal = map.get(key) == null ? val : val - map.get(key);
        map.put(key, val);
        MapSum node = this;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if (node.children[idx] == null) node.children[idx] = new MapSum();
            node.value += updateVal;
            node = node.children[idx];
        }
        node.value += updateVal;
    }

    public int sum(String prefix) {
        MapSum node = this;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (node.children[idx] == null) return 0;
            node = node.children[idx];
        }
        return node.value;
    }
}
