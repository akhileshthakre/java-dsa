package com.akhilesh.dsa.graph.dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EdgeListToMatrix {
    public static void main(String[] args) {
        EdgeListToMatrix etm = new EdgeListToMatrix();
        List<List<Integer>> edgeList = new ArrayList<>();
        edgeList.add(Arrays.asList(0,1));
        edgeList.add(Arrays.asList(1,2));
        edgeList.add(Arrays.asList(2,3));
        edgeList.add(Arrays.asList(3,1));
        edgeList.add(Arrays.asList(3,4));

        etm.edgeListToMatrix(edgeList);
    }

    private void edgeListToMatrix(List<List<Integer>> edgeList) {
        int n = edgeList.size();
        int[][] graph = new int[n][n];

        for (List<Integer> edge : edgeList) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph[u][v] = 1; // mark edge
            graph[v][u] = 1; // mark reverse (if undirected)
        }

        // Print adjacency matrix
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
    }
}
