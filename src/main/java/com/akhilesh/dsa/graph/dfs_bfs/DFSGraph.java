package com.akhilesh.dsa.graph.dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFSGraph {

    private void dfs(Map<Integer, List<Integer>> graph, int n, boolean[] vis, int source, List<Integer> res) {
        vis[source] = true;
        res.add(source);
        for(int val: graph.get(source)) {
            if(!vis[val]) {
                dfs(graph, n, vis, val, res);
            }
        }
    }

    private void edgeListToList(List<List<Integer>> edgeList, int n) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i< n; i++) {
            int u = edgeList.get(i).get(0);
            int v = edgeList.get(i).get(1);

            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        boolean[] vis = new boolean[n];
        List<Integer> res = new ArrayList<>();
        dfs(graph, n, vis, 0, res);
        System.out.println(res);

    }
    public static void main(String[] args) {
        DFSGraph dfs = new DFSGraph();
        List<List<Integer>> edgeList = new ArrayList<>();
        edgeList.add(Arrays.asList(0,1));
        edgeList.add(Arrays.asList(0,2));
        edgeList.add(Arrays.asList(2,3));
        edgeList.add(Arrays.asList(3,4));
        edgeList.add(Arrays.asList(4,3));
        edgeList.add(Arrays.asList(1,5));


        dfs.edgeListToList(edgeList, edgeList.size());
    }
}
