# Binary Tree Pattern

## Overview
Binary trees are hierarchical data structures where each node has at most two children. Common operations include traversal (DFS/BFS), path finding, and tree manipulation. Understanding tree traversal patterns is crucial for solving tree-related problems.

## When to Use
- Tree traversal problems (inorder, preorder, postorder)
- Path finding in trees
- Tree construction from traversal results
- Binary search tree operations
- Tree validation and property checking
- Level-order traversal problems

## Template

### Tree Node Definition
```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
```

### Depth-First Search (DFS) Traversals
```java
public class TreeTraversal {
    // Inorder: Left -> Root -> Right
    public void inorderTraversal(TreeNode root) {
        if (root == null) return;
        
        inorderTraversal(root.left);
        // Process root
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }
    
    // Preorder: Root -> Left -> Right
    public void preorderTraversal(TreeNode root) {
        if (root == null) return;
        
        // Process root
        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
    
    // Postorder: Left -> Right -> Root
    public void postorderTraversal(TreeNode root) {
        if (root == null) return;
        
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        // Process root
        System.out.print(root.val + " ");
    }
}
```

### Breadth-First Search (BFS) - Level Order
```java
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            result.add(currentLevel);
        }
        
        return result;
    }
}
```

### Recursive DFS with Return Value
```java
public class RecursiveDFS {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
```

### Iterative DFS using Stack
```java
public class IterativeDFS {
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
            // Go to leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        
        return result;
    }
}
```

## Common Problems

### 1. Maximum Depth of Binary Tree
```java
public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    
    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);
    
    return Math.max(leftDepth, rightDepth) + 1;
}
```

### 2. Binary Tree Inorder Traversal
```java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    inorderHelper(root, result);
    return result;
}

private void inorderHelper(TreeNode root, List<Integer> result) {
    if (root == null) return;
    
    inorderHelper(root.left, result);
    result.add(root.val);
    inorderHelper(root.right, result);
}
```

### 3. Symmetric Tree
```java
public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return isMirror(root.left, root.right);
}

private boolean isMirror(TreeNode left, TreeNode right) {
    if (left == null && right == null) return true;
    if (left == null || right == null) return false;
    
    return (left.val == right.val) && 
           isMirror(left.left, right.right) && 
           isMirror(left.right, right.left);
}
```

### 4. Path Sum
```java
public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false;
    
    // Check if it's a leaf node
    if (root.left == null && root.right == null) {
        return targetSum == root.val;
    }
    
    return hasPathSum(root.left, targetSum - root.val) || 
           hasPathSum(root.right, targetSum - root.val);
}
```

### 5. Construct Binary Tree from Inorder and Postorder
```java
public TreeNode buildTree(int[] inorder, int[] postorder) {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
        inorderMap.put(inorder[i], i);
    }
    
    return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, 
                          0, postorder.length - 1, inorderMap);
}

private TreeNode buildTreeHelper(int[] inorder, int[] postorder, 
                                int inStart, int inEnd, 
                                int postStart, int postEnd, 
                                Map<Integer, Integer> inorderMap) {
    if (inStart > inEnd || postStart > postEnd) return null;
    
    TreeNode root = new TreeNode(postorder[postEnd]);
    int rootIndex = inorderMap.get(root.val);
    int leftSubtreeSize = rootIndex - inStart;
    
    root.left = buildTreeHelper(inorder, postorder, inStart, rootIndex - 1,
                               postStart, postStart + leftSubtreeSize - 1, inorderMap);
    root.right = buildTreeHelper(inorder, postorder, rootIndex + 1, inEnd,
                                postStart + leftSubtreeSize, postEnd - 1, inorderMap);
    
    return root;
}
```

### 6. Lowest Common Ancestor
```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    
    if (left != null && right != null) return root;
    return left != null ? left : right;
}
```

### 7. Binary Tree Level Order Traversal
```java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    
    while (!queue.isEmpty()) {
        int levelSize = queue.size();
        List<Integer> currentLevel = new ArrayList<>();
        
        for (int i = 0; i < levelSize; i++) {
            TreeNode node = queue.poll();
            currentLevel.add(node.val);
            
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        
        result.add(currentLevel);
    }
    
    return result;
}
```

### 8. Validate Binary Search Tree
```java
public boolean isValidBST(TreeNode root) {
    return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
}

private boolean isValidBSTHelper(TreeNode root, long min, long max) {
    if (root == null) return true;
    
    if (root.val <= min || root.val >= max) return false;
    
    return isValidBSTHelper(root.left, min, root.val) && 
           isValidBSTHelper(root.right, root.val, max);
}
```

## Key Points

### Time Complexity
- **Traversal**: O(n) - visit each node once
- **Height calculation**: O(n) - visit each node once
- **Path finding**: O(n) - worst case visit all nodes

### Space Complexity
- **Recursive**: O(h) where h is height of tree (call stack)
- **Iterative**: O(w) where w is maximum width of tree
- **Worst case**: O(n) for skewed trees

### Common Mistakes
1. Not handling null nodes properly
2. Forgetting to check edge cases (empty tree)
3. Incorrect traversal order
4. Not considering tree properties (BST validation)

### Tips
- Always check for null before accessing node properties
- Use helper methods for recursive solutions
- Consider iterative solutions for space optimization
- Think about the problem in terms of traversal patterns

### Tree Properties
- **Height**: Maximum path from root to leaf
- **Depth**: Distance from root to a specific node
- **Level**: Nodes at same distance from root
- **Balanced**: Height difference between left and right subtrees ≤ 1

## Related Problems
- [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)
- [94. Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)
- [101. Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)
- [112. Path Sum](https://leetcode.com/problems/path-sum/)
- [106. Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
- [236. Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
- [102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)
- [98. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)
- [543. Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/)
- [226. Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/)
