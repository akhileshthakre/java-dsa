package com.akhilesh.dsa.graph.topo_sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//this code only works with asyclic graph as cycle detection code is broken and neew to use 3 color graph technique I guess or just pass by reference
public class TopoLogicalSortDFS {
    public static void main(String[] args) {
        
        TopoLogicalSortDFS tsd = new TopoLogicalSortDFS();
        int[][] edgeList = {{0,1},{1,3},{2,3},{4,0},{4,5}, {2,0}, {5,1}}; //acyclic graph
        // int[][] edgeList = {{0,1},{1,3},{2,3},{4,0},{4,5}, {2,0}, {5,1}, {3,4}}; // cyclic graph
        List<List<Integer>> graph = new ArrayList<>();

        int n = 0;
        //This is to determine number of vertices or nodes
        for (int[] edge : edgeList) {
            n = Math.max(n, Math.max(edge[0], edge[1]));
        }
        n = n + 1;

        for(int i = 0; i< n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edgeList) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
        }
        boolean[] vis = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0 ;i < n; i++) {
            if(!vis[i]) {
                tsd.topologicalSorting(graph, vis, q, i);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int val: q) {
            res.add(val);
        }
        System.out.println(q);
        System.out.println(res);
        
    }

    private void topologicalSorting(List<List<Integer>> graph, boolean[] vis, Deque<Integer> q, int source) {
        vis[source] = true;
        for(int edge: graph.get(source)) {
            if(!vis[edge]) {
                topologicalSorting(graph, vis, q, edge);
            }
        }
        q.addFirst(source);
    } 
}
