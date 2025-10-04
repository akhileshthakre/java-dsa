package com.akhilesh.dsa.graph.topo_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//It is also knows as Kahn's Algorithm
//It nly works with DAG
public class TopoLogicalSortBFS {
    public static void main(String[] args) {

        TopoLogicalSortBFS tsb = new TopoLogicalSortBFS();
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

        int[] inDegree = new int[n];
        List<Integer> ans = new ArrayList<>();
        Arrays.fill(inDegree, 0);
        tsb.topologicalSorting(graph, n, inDegree, ans);
    }

    private void topologicalSorting(List<List<Integer>> graph, int n, int[] inDegree, List<Integer> ans) {
        //comput the indegree or all nodes
        for(int i = 0; i<n; i++) {
            for(int edge: graph.get(i)) {
                inDegree[edge]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i< inDegree.length; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for(int edge: graph.get(node)) {
                inDegree[edge]--;
                if(inDegree[edge] == 0) {
                    q.add(edge);
                }
            }
        }

        if(ans.size() != n) {
            System.out.println("It is not DAG graphn and cycle deteted");
        }else {
            System.out.println(ans);
        }

    }

}
