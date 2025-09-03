package com.akhilesh.dsa.recursion_backtracking;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int target = 1;
        boolean res = binarySearch(arr, 0, arr.length-1, target);
        System.out.println(res);
    }

    private static boolean binarySearch(int[] arr, int start, int end, int target) {
        if(start > end) {
            return false;
        }
        int mid = (start + end) / 2;
        if(arr[mid] == target) {
            return true;
        }else if(arr[mid] > target) {
            end = mid - 1;
        }else if(arr[mid] < target) {
            start = mid + 1;
        }
        return binarySearch(arr, start, end, target);

    }
}
