package com.akhilesh.dsa.recursion_backtracking;

public class PrintOneToN {
    public static void main(String[] args) {
        PrintOneToN print = new PrintOneToN();
        print.printOneToNFunc(1);
        print.printNToOneFunc(10);
    }

    private void printOneToNFunc(int n) {
        if(n == 10) {
            return;
        }
        System.out.println(n);
        printOneToNFunc(n+1);
    }

    private void printNToOneFunc(int n) {
        if(n == 0) {
            return;
        }
        System.out.println(n);
        printNToOneFunc(n-1);
    }
}
