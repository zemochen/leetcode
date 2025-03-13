package com.zemo.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ClassName: SmallestString_1202
 * @author: zeming.chen
 * @email: zeming.chen@dmall.com
 * @Date 11/16/2022
 * @Description
 */
public class SmallestString_1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        if(pairs.size()==0||s.length()==1) return s;

        int len = s.length();
        UnionFind uf = new UnionFind(len);
        //构建并查集
        for(List<Integer> pair : pairs){
            uf.merge(pair.get(0),pair.get(1));
        }
        // 构建字符映射
        Map<Integer,PriorityQueue<Character>> map = new HashMap();
        char[] chars = s.toCharArray();
        for(int i = 0;i<len;i++){
            int root = uf.find(i);
            if(map.containsKey(root)){
                map.get(root).offer(chars[i]);
            }else{
                PriorityQueue<Character> queue =  new PriorityQueue();
                queue.offer(chars[i]);
                map.put(root,queue);
            }
        }
        //排序字符串
        String result = "";
        for(int i = 0;i<len;i++){
            int root = uf.find(i);
            result += map.get(root).poll();
        }
        return result;
    }

    public class UnionFind{
        int[] parent;
        int[] rank;
        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0;i<n ;i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x){
            if(x!=parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void merge(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rank[rootX] == rank[rootY]){
                parent[rootX] = rootY;
                rank[rootY]++;
            }else if(rank[rootX]< rank[rootY]){
                parent[rootX] = rootY;
            }else{
                parent[rootY] = rootX;
            }
        }
    }

    public static void main(String[] args) {
        SmallestString_1202 test = new SmallestString_1202();
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> pair = new ArrayList<>();
        pair.add(0);
        pair.add(1);
        pairs.add(pair);
        List<Integer> pair1 = new ArrayList<>();
        pair1.add(2);
        pair1.add(3);
        pairs.add(pair1);

        String dbca = test.smallestStringWithSwaps("dbca", pairs);
        System.out.println(dbca);

    }
}
