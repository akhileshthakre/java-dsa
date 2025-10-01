package com.akhilesh.dsa.stack_queue;

import java.util.Stack;

public class PrefixToPostfix {
    public static void main(String[] args) {
        PrefixToPostfix ptp = new PrefixToPostfix();
        String str =  "-+-32/l8+4*/63^58";
        String res = ptp.prefixToPostfix(str);
        System.out.println(res);
    }

    private String prefixToPostfix(String str) {
        int i = str.length() -1;
        Stack<String> st = new Stack<>();

        while(i >= 0) {
            char s = str.charAt(i);
            if((s >= 'A' && s <= 'Z') || (s >= 'a' && s <= 'z') || (s >= '0' && s <= '9') ) {
                st.push(String.valueOf(s));
            }else {
                String t1 = st.pop();
                String t2 = st.pop();
                String ans = t1 + t2 + s;
                st.push(ans);
            }
            i--;
        }
        return st.peek();
    }
}
