package com.akhilesh.dsa.templates;

import java.util.*;

/**
 * PrintUtils utility for formatted output and debugging
 * Provides convenient methods for printing arrays, matrices, and other data structures
 */
public class PrintUtils {
    
    /**
     * Print an array with custom separator
     */
    public static void printArray(int[] arr) {
        printArray(arr, " ");
    }
    
    public static void printArray(int[] arr, String separator) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(separator);
            }
        }
        System.out.println();
    }
    
    public static void printArray(long[] arr) {
        printArray(arr, " ");
    }
    
    public static void printArray(long[] arr, String separator) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(separator);
            }
        }
        System.out.println();
    }
    
    public static void printArray(String[] arr) {
        printArray(arr, " ");
    }
    
    public static void printArray(String[] arr, String separator) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(separator);
            }
        }
        System.out.println();
    }
    
    /**
     * Print a 2D array/matrix
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            printArray(row);
        }
    }
    
    public static void printMatrix(long[][] matrix) {
        for (long[] row : matrix) {
            printArray(row);
        }
    }
    
    public static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            printArray(row);
        }
    }
    
    /**
     * Print a list
     */
    public static void printList(List<?> list) {
        printList(list, " ");
    }
    
    public static void printList(List<?> list, String separator) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(separator);
            }
        }
        System.out.println();
    }
    
    /**
     * Print a set
     */
    public static void printSet(Set<?> set) {
        printSet(set, " ");
    }
    
    public static void printSet(Set<?> set, String separator) {
        Iterator<?> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext()) {
                System.out.print(separator);
            }
        }
        System.out.println();
    }
    
    /**
     * Print a map
     */
    public static void printMap(Map<?, ?> map) {
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
    
    /**
     * Print with debug prefix
     */
    public static void debug(String message) {
        System.out.println("[DEBUG] " + message);
    }
    
    public static void debug(Object obj) {
        System.out.println("[DEBUG] " + obj);
    }
    
    /**
     * Print array with indices for debugging
     */
    public static void printArrayWithIndices(int[] arr) {
        System.out.print("Indices: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%2d ", i);
        }
        System.out.println();
        System.out.print("Values:  ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%2d ", arr[i]);
        }
        System.out.println();
    }
    
    /**
     * Print a tree level by level (for debugging)
     */
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Simple TreeNode class for tree problems
     */
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        
        public TreeNode(int val) {
            this.val = val;
        }
        
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

