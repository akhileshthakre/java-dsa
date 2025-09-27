package com.akhilesh.dsa.stack_queue;

import java.util.Stack;

public class InfixToPreFix {
    public static void main(String[] args) {
        InfixToPreFix itp = new InfixToPreFix();
        String str = "(3-2+l/8)-(4+6/3*(5^8))";
        String res = itp.infixToPrefix(str);
        System.out.println(res);
    }

    private String infixToPrefix(String str) {
        str = reverseString(str);
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
                while(!st.isEmpty() && st.peek() != '(') {
                    ans.append(st.pop());
                }
                st.pop();
            }else {
                if(s == '^') {
                    while(!st.isEmpty() && priority(s) <= priority(st.peek())) {
                        ans.append(st.peek());
                        st.pop();
                    }
                }else {
                    while(!st.isEmpty() && priority(s) < priority(st.peek())) {
                        ans.append(st.peek());
                        st.pop();
                    }
                }
                st.push(s);
            }
            i++;
        }
        while(!st.isEmpty()) {
            ans.append(st.pop());
        }
        String finalRes = reverseString(ans.toString());
        return finalRes;
    }

    private String reverseString(String str) {
        StringBuilder rev = new StringBuilder();
        for(int i = str.length()-1; i >=0; i--) {
            if(str.charAt(i) == '(') {
                rev.append(')');
            }else if(str.charAt(i) == ')') {
                rev.append('(');
            }else {
                rev.append(str.charAt(i));
            }
        }
        return rev.toString();
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
