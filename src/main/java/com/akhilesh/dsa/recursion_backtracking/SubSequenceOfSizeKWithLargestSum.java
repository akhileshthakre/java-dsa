//Better and most optimal solution is to user Greedy approch by sorting the array by keeping its respective postions and sun the digits after sorting

package com.akhilesh.dsa.recursion_backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSequenceOfSizeKWithLargestSum {
    static List<Integer> best = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int[] nums = {2,1,3,3};
        int k = 2;
        List<Integer> arr = new ArrayList<>();
        subSeq(nums, arr, 0, 0, k );
        System.out.println(best);
    }


    private static void subSeq(int[] nums, List<Integer> arr, int sum, int index, int k){
        if (arr.size() + (nums.length - index) < k) return;
        if(arr.size() == k ) {
            if(sum > max) {
                max = sum;
                best = new ArrayList<>(arr);
            }
            return;
        }

        if(index == nums.length) return;

        sum = sum + nums[index];
        arr.add(nums[index]);
        subSeq(nums, arr, sum, index+1, k);
        sum = sum -  nums[index];
        arr.remove(arr.size() -1);
        subSeq(nums, arr, sum, index+1, k);
    }
}
