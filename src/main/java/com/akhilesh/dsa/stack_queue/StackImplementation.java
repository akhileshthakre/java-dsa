package com.akhilesh.dsa.stack_queue;

public class StackImplementation {
    static int[] arr = new int[10];
    static int  top = -1;
    public static void main(String[] args) {
        StackImplementation stack = new StackImplementation();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        for(int i = 0; i<= top; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("POP " + stack.pop());
        System.out.println("TOP "+stack.top());
        System.out.println("SIZE " +stack.size());
        System.out.println("POP " + stack.pop());
        for(int i = 0; i<= top; i++) {
            System.out.println(arr[i]);
        }


    }

    private void push(int val) {
        if(size() == arr.length) {
            System.out.println("Stack OverFlow");
            return;
        }
        if(top == -1) {
            arr[0] = val;
            top++;
        }else {
            arr[top+1] = val;
            top++;
        }
    }

    private int pop() {
        int val = arr[top];
        top--;
        return val;
    }

    private int top() {
        return top;
    }

    private int size() {
        return top + 1;
    }
}
