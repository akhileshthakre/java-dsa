package com.akhilesh.dsa.recursion_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {
    public static void main(String[] args) {
        CombinationSumII cs2 = new CombinationSumII();
        int[] candidates = {1,1,1,2,2};
        int target = 4;
        cs2.combinationSum2(candidates, target);
    }

    //Brute Force where the time compexity is 2^n * n where n is number of operation required to add in set and list;
    public void combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        calculate(list, candidates, 0, target, 0, set);
        for(List<Integer> i: set) {
            res.add(new ArrayList<>(i));
        }
        System.out.println(res);
    }

        private static void calculate(List<Integer> list , int[] arr, int index, int k, int sum, Set<List<Integer>> set) {
        if(index == arr.length) {
            if(sum == k) {
                set.add(new ArrayList<>(list));
            }
            return;
        }
        sum = sum + arr[index];

        list.add(arr[index]);
        calculate(list, arr, index+1, k, sum, set);
        sum = sum - arr[index];
        list.remove(list.size() -1);
        calculate(list, arr, index+1, k, sum, set);

    }
}

