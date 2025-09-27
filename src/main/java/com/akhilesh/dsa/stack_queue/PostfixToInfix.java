package com.akhilesh.dsa.stack_queue;

import java.util.Stack;

public class PostfixToInfix {
    public static void main(String[] args) {
        PostfixToInfix pti = new PostfixToInfix();
        String str = "32-l8/+463/58^*+-";
        String res = pti.postfixToInfix(str);
        System.out.println(res);
    }
    private String postfixToInfix(String str) {
        int i = 0;
        int n = str.length();
        Stack<String> st =new Stack<>();
        while(i < n) {
            char s = str.charAt(i);
            if((s >= 'A' && s <= 'Z') || (s >= 'a' && s <= 'z') || (s >= '0' && s <= '9') ) {
                st.push(String.valueOf(s));
            }else {
                String t1 = st.pop();
                String t2 = st.pop();
                String ans = '(' + t2 + s + t1 + ')';
                st.push(ans);
            }
            i++;
        }
        return st.peek();
    }
}
