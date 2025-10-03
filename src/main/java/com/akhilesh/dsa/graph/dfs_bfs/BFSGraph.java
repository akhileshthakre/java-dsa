package com.akhilesh.dsa.graph.dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFSGraph {

    public void bfs(Map<Integer, List<Integer>> graph, int size, int source) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[size];

        q.add(source);
        vis[source] = true;
        while(!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            
            for(int val: graph.get(node)) {
                if(vis[val] == false) {
                    vis[val] = true;
                    q.add(val);
                }
            }
        }
        System.out.println(res);
    }

    public void edgeListToList(List<List<Integer>> list, int size) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(List<Integer> ls: list) {
            int u = ls.get(0);
            int v = ls.get(1);

            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        bfs(graph, size, 0);
    }
    public static void main(String[] args) {
        BFSGraph bfs = new BFSGraph();
        List<List<Integer>> edgeList = new ArrayList<>();
        edgeList.add(Arrays.asList(0,1));
        edgeList.add(Arrays.asList(0,2));
        edgeList.add(Arrays.asList(2,3));
        edgeList.add(Arrays.asList(3,4));
        edgeList.add(Arrays.asList(4,3));
        edgeList.add(Arrays.asList(1,5));


        bfs.edgeListToList(edgeList, edgeList.size());
    }
}
