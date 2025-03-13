package com.zemo.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ClassName: UnionFind
 * @author: zeming.chen
 * @email: zeming.chen@dmall.com
 * @Date 11/16/2022
 * @Description
 */
public class UnionFind {

    private int[] parent;

    private int[] rank;

    public UnionFind(int n) {

        this.parent = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
            this.rank[i] = 1;
        }
    }

    public int find(int x) {

        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }

        if (rank[rootX] == rank[rootY]) {
            parent[rootX] = rootY;
            rank[rootY]++;
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
        }
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
    @Override
    public String toString() {
        return "UnionFind{" +
            "parent=" + Arrays.toString(parent) +
            ", rank=" + Arrays.toString(rank) +
            '}';
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(5);
        int[][] family = {{0, 3}, {1, 2},{0,4},{2,4}};
        for (int[] ints : family) {
            uf.union(ints[0], ints[1]);
            System.out.println(uf);

        }

        PriorityQueue<Character> queue = new PriorityQueue();
        char[] chars = {'b', 'd', 'a', 'c'};
        for (char aChar : chars) {
            queue.offer(aChar);
        }
        queue.poll();
        queue.peek();
        System.out.println(queue);

        Map<String, String> map = new HashMap();

    }
}
