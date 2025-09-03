# Sliding Window Pattern

## Overview
The sliding window technique is used to solve problems involving arrays/strings where we need to find/calculate something among all subarrays/substrings of a certain size.

## When to Use
- Problems involving subarrays/substrings
- Need to find min/max/average of subarrays
- Need to find subarrays with certain properties
- String problems with substring constraints

## Template

### Fixed Size Window
```java
public int fixedSizeWindow(int[] arr, int k) {
    int n = arr.length;
    if (n < k) return -1; // or handle edge case
    
    // Calculate sum of first window
    int windowSum = 0;
    for (int i = 0; i < k; i++) {
        windowSum += arr[i];
    }
    
    int maxSum = windowSum;
    
    // Slide the window
    for (int i = k; i < n; i++) {
        windowSum = windowSum - arr[i - k] + arr[i];
        maxSum = Math.max(maxSum, windowSum);
    }
    
    return maxSum;
}
```

### Variable Size Window
```java
public int variableSizeWindow(int[] arr, int target) {
    int n = arr.length;
    int windowSum = 0;
    int minLength = Integer.MAX_VALUE;
    int windowStart = 0;
    
    for (int windowEnd = 0; windowEnd < n; windowEnd++) {
        windowSum += arr[windowEnd];
        
        // Shrink window while condition is met
        while (windowSum >= target) {
            minLength = Math.min(minLength, windowEnd - windowStart + 1);
            windowSum -= arr[windowStart];
            windowStart++;
        }
    }
    
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
}
```

## Common Problems

### 1. Maximum Sum Subarray of Size K
```java
public int maxSumSubarray(int[] arr, int k) {
    int n = arr.length;
    int windowSum = 0;
    
    // First window
    for (int i = 0; i < k; i++) {
        windowSum += arr[i];
    }
    
    int maxSum = windowSum;
    
    // Slide window
    for (int i = k; i < n; i++) {
        windowSum = windowSum - arr[i - k] + arr[i];
        maxSum = Math.max(maxSum, windowSum);
    }
    
    return maxSum;
}
```

### 2. Longest Substring with K Distinct Characters
```java
public int longestSubstringKDistinct(String s, int k) {
    Map<Character, Integer> charCount = new HashMap<>();
    int maxLength = 0;
    int windowStart = 0;
    
    for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
        char rightChar = s.charAt(windowEnd);
        charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
        
        // Shrink window if more than k distinct characters
        while (charCount.size() > k) {
            char leftChar = s.charAt(windowStart);
            charCount.put(leftChar, charCount.get(leftChar) - 1);
            if (charCount.get(leftChar) == 0) {
                charCount.remove(leftChar);
            }
            windowStart++;
        }
        
        maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }
    
    return maxLength;
}
```

### 3. Minimum Size Subarray Sum
```java
public int minSubArrayLen(int target, int[] nums) {
    int n = nums.length;
    int windowSum = 0;
    int minLength = Integer.MAX_VALUE;
    int windowStart = 0;
    
    for (int windowEnd = 0; windowEnd < n; windowEnd++) {
        windowSum += nums[windowEnd];
        
        while (windowSum >= target) {
            minLength = Math.min(minLength, windowEnd - windowStart + 1);
            windowSum -= nums[windowStart];
            windowStart++;
        }
    }
    
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
}
```

## Key Points

### Time Complexity
- **Fixed Size**: O(n) - each element is processed at most twice
- **Variable Size**: O(n) - each element is processed at most twice

### Space Complexity
- Usually O(1) for simple cases
- O(k) where k is the number of distinct elements (for hash map)

### Common Mistakes
1. Not handling edge cases (array smaller than window)
2. Incorrect window shrinking condition
3. Forgetting to update result in each iteration
4. Not considering empty/null inputs

### Tips
- Always initialize result variable properly
- Use while loop for shrinking (not if)
- Consider using HashMap for character counting
- Think about what to track in the window

## Related Problems
- [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
- [209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)
- [340. Longest Substring with At Most K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/)
- [424. Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)
- [567. Permutation in String](https://leetcode.com/problems/permutation-in-string/)

