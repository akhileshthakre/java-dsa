package com.akhilesh.dsa.sliding_window;

public class MaxConsecutiveOnesAfterFilpingOneZero {
    public static void main(String[] args) {
        // int[] nums = {1,0,1,1,0,0,1};
        int[] nums = {0,0,1,1,0,1};
        int k = 2;
        MaxConsecutiveOnesAfterFilpingOneZero res = new MaxConsecutiveOnesAfterFilpingOneZero();
        res.maxConsecutiveOne(nums, k);
    }

    private void maxConsecutiveOne(int[] nums, int k) {
        int start = 0;
        int count = 0;
        int max = 0;
        for(int end = 0; end < nums.length; end++) {
            if(nums[end] == 0) {
                count++;
            }
            while(count > k) {
                if(nums[start] == 0) {
                    count--;
                }
                start++;
            }
            max = Math.max(max, end - start + 1);
        }
        System.out.println(max);
    }
}
