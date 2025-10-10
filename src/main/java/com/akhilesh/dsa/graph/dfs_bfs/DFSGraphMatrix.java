package com.akhilesh.dsa.graph.dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFSGraphMatrix {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    public static void main(String[] args) {
        DFSGraphMatrix dgm = new DFSGraphMatrix();
        List<List<Integer>> edgeList = new ArrayList<>();
        edgeList.add(Arrays.asList(0,1));
        edgeList.add(Arrays.asList(0,2));
        edgeList.add(Arrays.asList(2,3));
        edgeList.add(Arrays.asList(3,4));
        edgeList.add(Arrays.asList(4,3));
        edgeList.add(Arrays.asList(1,5));

        //Number of vertices
        int n = 5;

        dgm.edgeListToMatrix(edgeList,n);
    }

    private void edgeListToMatrix(List<List<Integer>> edgeList, int n) {
        int[][] graph = new int[n+1][n+1];
        boolean[] vis = new boolean[n+1];

        List<Integer> res = new ArrayList<>();

        for(List<Integer> edge: edgeList) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        // Print adjacency matrix
        for (int i = 0; i <=n; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }

        dfs(graph, vis, res, 0);
        System.out.println(res);
    }

    private void dfs(int[][] graph, boolean[] vis, List<Integer> res, int source) {
        vis[source] = true;
        res.add(source);
        for(int i = 0;i<graph[source].length; i++) {
            if(graph[source][i] ==1 && !vis[i]) {
                dfs(graph, vis, res, i);
            }
        }
    }
}
