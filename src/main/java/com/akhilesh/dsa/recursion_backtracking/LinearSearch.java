package com.akhilesh.dsa.recursion_backtracking;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int target = 8;
        boolean res = linearSearch(arr, target, 0);
        System.out.println(res);
    }

    private static boolean linearSearch(int[] arr, int target, int index) {
        if(index == arr.length) {
            return false;
        }
        if(arr[index] == target) {
            return true;
        }

        return linearSearch(arr, target, index+1);
    }
}
