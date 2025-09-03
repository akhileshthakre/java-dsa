package com.akhilesh.dsa.recursion_backtracking;

public class ReverseArray {
    public static void main(String[] args) {
        ReverseArray reverseArray = new ReverseArray();
        int[] arr = {1,2,3,4,5,6};
        reverseArray.reverse(arr, 0,  arr.length-1);
        for(int val : arr) {
            System.out.println(val);
        }
        
    }

    private void reverse(int[] arr , int left, int right) {
        if(left >= right){
            return;
        }
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        reverse(arr, left+1, right - 1);
    }
}
