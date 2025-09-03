# Two Pointers Pattern

## Overview
The two pointers technique uses two pointers to traverse an array or linked list, often from different positions or moving at different speeds. This pattern is efficient for solving problems involving pairs, subarrays, or linked list operations.

## When to Use
- Problems involving pairs of elements
- Linked list problems (cycle detection, middle element)
- Array problems requiring O(n) time complexity
- Problems involving sorted arrays
- Palindrome or string manipulation problems

## Template

### Basic Two Pointers (Start and End)
```java
public int[] twoPointers(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    
    while (left < right) {
        // Process elements at left and right pointers
        if (condition) {
            left++;
        } else {
            right--;
        }
    }
    
    return result;
}
```

### Fast and Slow Pointers
```java
public boolean fastSlowPointers(ListNode head) {
    if (head == null || head.next == null) return false;
    
    ListNode slow = head;
    ListNode fast = head;
    
    // Find meeting point
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        
        if (slow == fast) {
            return true; // Cycle detected
        }
    }
    
    return false;
}
```

### Two Pointers with Different Starting Positions
```java
public int[] twoPointersDifferentStart(int[] arr) {
    int pointer1 = 0;
    int pointer2 = 1; // or any other starting position
    
    while (pointer2 < arr.length) {
        // Process elements
        if (condition) {
            pointer1++;
        }
        pointer2++;
    }
    
    return result;
}
```

## Common Problems

### 1. Two Sum in Sorted Array
```java
public int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;
    
    while (left < right) {
        int sum = numbers[left] + numbers[right];
        
        if (sum == target) {
            return new int[]{left + 1, right + 1};
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }
    
    return new int[]{-1, -1};
}
```

### 2. Remove Duplicates from Sorted Array
```java
public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    
    int writePointer = 1;
    
    for (int readPointer = 1; readPointer < nums.length; readPointer++) {
        if (nums[readPointer] != nums[readPointer - 1]) {
            nums[writePointer] = nums[readPointer];
            writePointer++;
        }
    }
    
    return writePointer;
}
```

### 3. Linked List Cycle Detection
```java
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;
    
    ListNode slow = head;
    ListNode fast = head;
    
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        
        if (slow == fast) {
            return true;
        }
    }
    
    return false;
}
```

### 4. Container With Most Water
```java
public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int maxArea = 0;
    
    while (left < right) {
        int width = right - left;
        int h = Math.min(height[left], height[right]);
        maxArea = Math.max(maxArea, width * h);
        
        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }
    
    return maxArea;
}
```

### 5. Valid Palindrome
```java
public boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    
    while (left < right) {
        // Skip non-alphanumeric characters
        while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
            left++;
        }
        while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
            right--;
        }
        
        if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
            return false;
        }
        
        left++;
        right--;
    }
    
    return true;
}
```

## Key Points

### Time Complexity
- **Basic Two Pointers**: O(n) - each element is processed at most once
- **Fast and Slow**: O(n) - fast pointer moves twice as fast
- **Different Starting Positions**: O(n) - depends on the specific implementation

### Space Complexity
- Usually O(1) - only using a few variables
- O(n) if additional data structures are needed

### Common Mistakes
1. Not handling edge cases (empty array, single element)
2. Incorrect pointer movement logic
3. Not considering array bounds
4. Forgetting to update both pointers

### Tips
- Always check bounds before accessing array elements
- Use while loops for more control over pointer movement
- Consider using different pointer speeds for linked list problems
- Think about the termination condition carefully

## Related Problems
- [1. Two Sum](https://leetcode.com/problems/two-sum/)
- [15. 3Sum](https://leetcode.com/problems/3sum/)
- [26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
- [141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)
- [142. Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)
- [11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/)
- [125. Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)
- [167. Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
