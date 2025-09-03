package com.akhilesh.dsa.sliding_window;

public class MinLengthOfSubArrayWithTarget {
    public static void main(String[] args) {
       int target = 20;
       int[] nums = {2,3,1,2,4,3};
       MinLengthOfSubArrayWithTarget res = new MinLengthOfSubArrayWithTarget();
       res.minLengthCalculation(nums, target);
    }

    private void minLengthCalculation(int[] nums, int target) {
        int sum = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++) {
            sum = sum + nums[i];
            while(sum >= target) {
                min = Math.min(min, i - start + 1);
                sum = sum -  nums[start];
                start++;
            }
        }
        if(min == Integer.MAX_VALUE) {
            System.out.println(0);
        }else {
            System.out.println(min);
        }
    }
}
