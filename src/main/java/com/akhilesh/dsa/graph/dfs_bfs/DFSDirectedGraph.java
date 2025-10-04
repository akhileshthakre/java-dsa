package com.akhilesh.dsa.graph.dfs_bfs;

import java.util.ArrayList;
import java.util.List;

public class DFSDirectedGraph {
    public static void main(String[] args) {
        DFSDirectedGraph ddg = new DFSDirectedGraph();
        //Convert to adjacency List
        int[][] edgeList = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i<=edgeList.length; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edgeList) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
        }
        ////////////////////////////////////////
        //perform dfs
        boolean[] vis = new boolean[edgeList.length + 1];
        List<Integer> res = new ArrayList<>();

        int count = 0;
        for(int i = 0; i<= edgeList.length; i++) {
            if(!vis[i]){
                count++;
                ddg.dfs(graph, vis, res, i);
            }
        }
        System.out.println(res + " +  count = " + count);
    }

    private void dfs(List<List<Integer>> graph, boolean[] vis, List<Integer> res, int source) {
        vis[source] = true;
        res.add(source);
        for(int val: graph.get(source)) {
            if(!vis[val]) {
                dfs(graph, vis, res, val);
            }
        }
    }
}
