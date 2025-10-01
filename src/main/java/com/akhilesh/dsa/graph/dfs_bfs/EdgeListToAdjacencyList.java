package com.akhilesh.dsa.graph.dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EdgeListToAdjacencyList {
    public static void main(String[] args) {
        EdgeListToAdjacencyList eta = new EdgeListToAdjacencyList();
        List<List<Integer>> edgeList = new ArrayList<>();
        edgeList.add(Arrays.asList(0,1));
        edgeList.add(Arrays.asList(1,2));
        edgeList.add(Arrays.asList(2,3));
        edgeList.add(Arrays.asList(3,1));
        edgeList.add(Arrays.asList(3,4));

        eta.edgeListToList(edgeList);

    }

    public void edgeListToList(List<List<Integer>> edgeList ) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i<edgeList.size(); i++) {
            int u = edgeList.get(i).get(0);
            int v = edgeList.get(i).get(1);
            // Add v to u's adjacency list
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);

            // If it's an undirected graph, also add u to v's adjacency list
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        System.out.println(graph);
    }
}
