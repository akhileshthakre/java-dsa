package com.akhilesh.dsa.recursion_backtracking;

public class PrintOneToNBacktrack {
    public static void main(String[] args) {
        PrintOneToNBacktrack backtrack = new PrintOneToNBacktrack();
        backtrack.printOneToNBacktrack(5); //Idean here is to print 1 to 5 without + sign but you can use - sign
        backtrack.printNToOneBacktrack(1);
    }

    private void printOneToNBacktrack(int n) {
        if(n == 0) {
            return;
        }
        printOneToNBacktrack(n-1);
        System.out.println(n); //by adding the print after the function call we are backtracking means anything after the function call executed in top to down manner
    }

        private void printNToOneBacktrack(int n) {
        if(n == 5) {
            return;
        }
        printNToOneBacktrack(n+1);
        System.out.println(n); //by adding the print after the function call we are backtracking means anything after the function call executed in top to down manner
    }
}

