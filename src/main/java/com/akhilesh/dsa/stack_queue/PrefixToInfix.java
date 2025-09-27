package com.akhilesh.dsa.stack_queue;

import java.util.Stack;

public class PrefixToInfix {
    public static void main(String[] args) {
        PrefixToInfix pti = new PrefixToInfix();
        String str = "-+-32/l8+4*/63^58";
        String res = pti.prefixToInfix(str);
        System.out.println(res);
    }

    private String prefixToInfix(String str) {
        int i = str.length() -1;
        Stack<String> st = new Stack<>();

        while(i >= 0) {
            char s = str.charAt(i);
            if((s >= 'A' && s <= 'Z') || (s >= 'a' && s <= 'z') || (s >= '0' && s <= '9') ) {
                st.push(String.valueOf(s));
            }else {
                String t1 = st.pop();
                String t2 = st.pop();
                String ans = '(' + t1 + s + t2 + ')';
                st.push(ans);
            }
            i--;
        }

        return st.peek();

    }
}
