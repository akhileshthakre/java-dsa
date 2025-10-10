package com.akhilesh.dsa.graph.dfs_bfs;

import java.util.ArrayList;
import java.util.List;

public class CycleInDirectedGraphDFS {
    private boolean dfs(List<List<Integer>> graph, boolean[] vis, boolean[] currNodes, int source) {
        vis[source] = true;
        currNodes[source] = true;

        for(int edge: graph.get(source)) {
            if(!vis[edge]) {
                // vis[edge] = true;
                // currNodes[edge] = true;
                if(dfs(graph, vis, currNodes, edge)){
                    return true;
                }
            }else {
                if(currNodes[edge]) {
                    return true;
                }
            }
        }
        currNodes[source] = false;
        return false;
    }
    public static void main(String[] args) {
        CycleInDirectedGraphDFS cdg = new CycleInDirectedGraphDFS();
        int[][] edgeList = {{0,1},{1,3},{2,3},{4,0},{4,5}, {2,0}, {5,1}, {3,4}};

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i<=edgeList.length; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edgeList) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
        }

        boolean[] vis = new boolean[edgeList.length + 1];
        boolean[] currNodes = new boolean[edgeList.length + 1];
        boolean res = false;
        for(int i =0; i<=edgeList.length; i++) {
            if(!vis[i]) {
                res = cdg.dfs(graph, vis, currNodes, i);
                if(res == true) {
                    break;
                }
            }
        }
        //If only cycle detection then just print true or false
        System.out.println(res);

        //If Interviewer asks to print the array then use this
        for(int i = 0; i< currNodes.length; i++) {
            if(currNodes[i]) {
                System.out.println(i);
            }
        }

    }
}
