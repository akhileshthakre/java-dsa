# Monotonic Stack Pattern

## Overview
A monotonic stack is a stack that maintains elements in a specific order (either strictly increasing or strictly decreasing). It's used to solve problems where we need to find the next greater/smaller element or maintain a specific order while processing elements.

## When to Use
- Finding next greater/smaller element
- Problems involving temperature, stock prices, or similar sequences
- Histogram problems (largest rectangle in histogram)
- Problems requiring maintaining order while processing
- Trapping rain water problems

## Template

### Monotonic Decreasing Stack (Next Greater Element)
```java
public int[] nextGreaterElement(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    
    // Initialize result array with -1
    Arrays.fill(result, -1);
    
    for (int i = 0; i < n; i++) {
        // Pop elements smaller than current element
        while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
            result[stack.pop()] = nums[i];
        }
        stack.push(i);
    }
    
    return result;
}
```

### Monotonic Increasing Stack (Next Smaller Element)
```java
public int[] nextSmallerElement(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    
    // Initialize result array with -1
    Arrays.fill(result, -1);
    
    for (int i = 0; i < n; i++) {
        // Pop elements greater than current element
        while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
            result[stack.pop()] = nums[i];
        }
        stack.push(i);
    }
    
    return result;
}
```

### Monotonic Stack with Circular Array
```java
public int[] nextGreaterElementsCircular(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    
    // Initialize result array with -1
    Arrays.fill(result, -1);
    
    // Process array twice for circular nature
    for (int i = 0; i < 2 * n; i++) {
        int num = nums[i % n];
        
        while (!stack.isEmpty() && nums[stack.peek()] < num) {
            result[stack.pop()] = num;
        }
        
        if (i < n) {
            stack.push(i);
        }
    }
    
    return result;
}
```

## Common Problems

### 1. Next Greater Element I
```java
public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Map<Integer, Integer> nextGreater = new HashMap<>();
    Stack<Integer> stack = new Stack<>();
    
    // Find next greater for all elements in nums2
    for (int num : nums2) {
        while (!stack.isEmpty() && stack.peek() < num) {
            nextGreater.put(stack.pop(), num);
        }
        stack.push(num);
    }
    
    // Build result for nums1
    int[] result = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
        result[i] = nextGreater.getOrDefault(nums1[i], -1);
    }
    
    return result;
}
```

### 2. Daily Temperatures
```java
public int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    
    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
            int prevIndex = stack.pop();
            result[prevIndex] = i - prevIndex;
        }
        stack.push(i);
    }
    
    return result;
}
```

### 3. Largest Rectangle in Histogram
```java
public int largestRectangleArea(int[] heights) {
    int n = heights.length;
    Stack<Integer> stack = new Stack<>();
    int maxArea = 0;
    
    for (int i = 0; i <= n; i++) {
        int h = (i == n) ? 0 : heights[i];
        
        while (!stack.isEmpty() && heights[stack.peek()] > h) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        
        stack.push(i);
    }
    
    return maxArea;
}
```

### 4. Trapping Rain Water
```java
public int trap(int[] height) {
    int n = height.length;
    Stack<Integer> stack = new Stack<>();
    int water = 0;
    
    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
            int top = stack.pop();
            
            if (stack.isEmpty()) break;
            
            int distance = i - stack.peek() - 1;
            int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
            water += distance * boundedHeight;
        }
        
        stack.push(i);
    }
    
    return water;
}
```

### 5. Remove K Digits
```java
public String removeKdigits(String num, int k) {
    if (k >= num.length()) return "0";
    
    Stack<Character> stack = new Stack<>();
    
    for (char digit : num.toCharArray()) {
        while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
            stack.pop();
            k--;
        }
        stack.push(digit);
    }
    
    // Remove remaining k digits from end
    while (k > 0) {
        stack.pop();
        k--;
    }
    
    // Build result string
    StringBuilder result = new StringBuilder();
    while (!stack.isEmpty()) {
        result.insert(0, stack.pop());
    }
    
    // Remove leading zeros
    while (result.length() > 1 && result.charAt(0) == '0') {
        result.deleteCharAt(0);
    }
    
    return result.toString();
}
```

## Key Points

### Time Complexity
- **Basic Operations**: O(n) - each element is pushed and popped at most once
- **Space Complexity**: O(n) - worst case when all elements are in stack

### Common Mistakes
1. Not handling empty stack conditions
2. Incorrect comparison logic for monotonic order
3. Forgetting to initialize result array
4. Not considering edge cases (empty input, single element)

### Tips
- Always check if stack is empty before popping
- Use indices instead of values when you need position information
- Consider using a sentinel value for easier boundary handling
- Think about the order you want to maintain (increasing vs decreasing)

### Monotonic Stack vs Monotonic Queue
- **Stack**: LIFO - useful for next greater/smaller element problems
- **Queue**: FIFO - useful for sliding window maximum/minimum problems

## Related Problems
- [496. Next Greater Element I](https://leetcode.com/problems/next-greater-element-i/)
- [503. Next Greater Element II](https://leetcode.com/problems/next-greater-element-ii/)
- [739. Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)
- [84. Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)
- [42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)
- [402. Remove K Digits](https://leetcode.com/problems/remove-k-digits/)
- [901. Online Stock Span](https://leetcode.com/problems/online-stock-span/)
- [907. Sum of Subarray Minimums](https://leetcode.com/problems/sum-of-subarray-minimums/)
