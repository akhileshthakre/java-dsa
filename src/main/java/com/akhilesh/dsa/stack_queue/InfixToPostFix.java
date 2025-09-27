package com.akhilesh.dsa.stack_queue;

import java.util.Stack;

public class InfixToPostFix {
    public static void main(String[] args) {
        InfixToPostFix itp = new InfixToPostFix();
        String res = itp.infixToPostfix("(3-2+l/8)-(4+6/3*(5^8))");
        System.out.println(res);
    }

    public String infixToPostfix(String str) {
        int i = 0;
        int n = str.length();
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();
        while(i < n) {
            char s = str.charAt(i);
            //If char is operand
            if((s >= 'A' && s <= 'Z') || (s >= 'a' && s <= 'z') || (s >= '0' && s <= '9') ) {
                ans.append(s);
            }
            else if(s == '(') {
                st.push(s);
            }
            else if(s == ')') {
                 while(!st.empty() && st.peek() != '(') {
                    ans.append(st.peek());
                    st.pop();
                }
                st.pop();
            }
            //if char is operator
            else {
                while(!st.isEmpty() && priority(s) <= priority(st.peek())){
                    ans.append(st.peek());
                    st.pop();
                }
                st.push(s);
            }
            i++;
        }

        while(!st.isEmpty()) {
            ans.append(st.peek());
            st.pop();
        }
        return ans.toString();
    }

    private int priority(char c) {
        if(c == '^') {
            return 3;
        }else if(c == '*' || c == '/') {
            return 2;
        }else if(c == '+' || c == '-') {
            return 1;
        }else {
            return -1;
        }
    }
}
