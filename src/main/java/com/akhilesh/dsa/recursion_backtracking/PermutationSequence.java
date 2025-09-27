package com.akhilesh.dsa.recursion_backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//This is brute force approch to Permutation Sequence
public class PermutationSequence {
    public static void main(String[] args) {
        PermutationSequence ps = new PermutationSequence();
        String res = ps.getPermutation(3, 3);
        System.out.println(res);
       
    }

     public String getPermutation(int n, int k) {
            Set<Integer> hmap = new HashSet<>();
            List<Integer> nums = new ArrayList<>();
            List<List<Integer>> list = new ArrayList<>();
            StringBuilder str = new StringBuilder();
            for(int i = 1; i<=n; i++) {
                nums.add(i);
            }
            solve(nums, list, new ArrayList<>(), hmap);
            List<Integer> res = list.get(k-1);
            for(int i = 0; i<res.size() ;i++) {
                str.append(res.get(i));
            }
            String resultString = str.toString();
            return resultString;
        }

        private void solve(List<Integer> nums, List<List<Integer>> list, List<Integer> arr, Set<Integer> hmap) {
            if(arr.size() == nums.size()) {
                list.add(new ArrayList<>(arr));
                return;
            }

            for(int i = 0; i< nums.size(); i++) {
                if(hmap.contains(nums.get(i))) continue;
                hmap.add(nums.get(i));
                arr.add(nums.get(i));
                solve(nums, list, arr, hmap);
                hmap.remove(arr.get(arr.size() - 1));
                arr.remove(arr.size() -1);
            }
        }
}


