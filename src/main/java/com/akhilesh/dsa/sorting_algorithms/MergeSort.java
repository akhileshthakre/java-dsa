package com.akhilesh.dsa.sorting_algorithms;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3,4,1,3,5,7,9,4,0,2,4,6};
        MergeSort ms = new MergeSort();
        ms.mergeSort(arr, 0, arr.length-1);
        for(int val : arr) {
            System.out.println(val);
        }
    }

    private void mergeSort(int[] arr, int low, int high) {
        if(low == high) return;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, high, mid);
    }

    private void merge(int[] arr, int low, int high, int mid) {
        List<Integer> temp = new ArrayList<>();
        int i = low;
        int j = mid + 1;
        while(i <= mid && j <= high) {
            if(arr[i] <= arr[j]) {
                temp.add(arr[i]);
                i++;
            }else  {
                temp.add(arr[j]);
                j++;
            }
        }

        while( i <= mid ) {
            temp.add(arr[i]);
            i++;
        }

        while( j <= high ) {
            temp.add(arr[j]);
            j++;
        }

        for(int k = low; k <=high; k++) {
            arr[k] = temp.get(k - low);
        }
    }
}
