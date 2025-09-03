package com.akhilesh.dsa.recursion_backtracking;

public class SumOfAllDigits {
    public static void main(String[] args) {
        SumOfAllDigits sum = new SumOfAllDigits();
        int res = sum.sumOfDigitsParametrize(5, 0);
        int res1 = sum.sumOFDigitsFunctional(5);
        System.out.println(res + " and " + res1);
    }

    //Passing value as parameter and updates it
    private int sumOfDigitsParametrize(int n, int sum) {
        if(n == 1) {
            return sum + 1;
        }
        sum = sum + n;
        return sumOfDigitsParametrize(n-1 , sum);
        
    }

    //passing value in function and waits for it to finish and return then sum it
    private int sumOFDigitsFunctional(int n) {
        if(n == 0) {
            return 0;
        }
        return n + sumOFDigitsFunctional(n-1);
    }
}
