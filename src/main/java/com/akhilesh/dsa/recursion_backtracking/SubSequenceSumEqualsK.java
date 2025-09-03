package com.akhilesh.dsa.recursion_backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSequenceSumEqualsK {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5};
        int k = 8;
        List<Integer> list = new ArrayList<>();
        calculate(list, arr, 0, k, 0);
    }

    private static void calculate(List<Integer> list , int[] arr, int index, int k, int sum) {
        if(index == arr.length) {
            if(sum == k) {
                System.out.println(list + " is true");
            }
            return;
        }
        sum = sum + arr[index];

        list.add(arr[index]);
        calculate(list, arr, index+1, k, sum);
        sum = sum - arr[index];
        list.remove(list.size() -1);
        calculate(list, arr, index+1, k, sum);

    }
}
