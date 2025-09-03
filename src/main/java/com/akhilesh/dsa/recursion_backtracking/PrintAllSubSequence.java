package com.akhilesh.dsa.recursion_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllSubSequence {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> arr = new ArrayList<>(Arrays.asList(3,1,2,4,5));
        printSubsequnce(arr, list, 0);
    }

    private static void printSubsequnce(List<Integer> arr, List<Integer> list, int index) {
        if(index >= arr.size()) {
            System.out.println(list);
            return;
        }
        list.add(arr.get(index));
        printSubsequnce(arr, list, index+1);
        list.remove(arr.get(index));
        printSubsequnce(arr, list, index+1);

    }
}
