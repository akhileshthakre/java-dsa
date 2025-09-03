# Java Operations Pattern

## Overview
This pattern covers essential Java operations, data structures, and common programming techniques used in DSA problems. Understanding these operations is crucial for efficient problem-solving in Java.

## When to Use
- Basic Java operations and syntax
- Data structure implementations
- Common algorithms and utilities
- String and array manipulations
- Collections framework usage
- Bit manipulation operations

## Template

### Basic Data Structures

#### Arrays
```java
// Array declaration and initialization
int[] arr = new int[10];
int[] arr2 = {1, 2, 3, 4, 5};

// 2D Arrays
int[][] matrix = new int[3][4];
int[][] matrix2 = {{1,2,3}, {4,5,6}, {7,8,9}};

// Array operations
Arrays.sort(arr);                    // Sort array
Arrays.fill(arr, 0);                 // Fill with value
Arrays.copyOf(arr, newLength);       // Copy array
Arrays.equals(arr1, arr2);           // Compare arrays
```

#### Lists
```java
// ArrayList
List<Integer> list = new ArrayList<>();
list.add(1);                         // Add element
list.get(0);                         // Get element
list.set(0, 10);                     // Set element
list.remove(0);                      // Remove by index
list.remove(Integer.valueOf(1));     // Remove by value
list.size();                         // Get size
list.isEmpty();                      // Check if empty
list.clear();                        // Clear list

// LinkedList
List<Integer> linkedList = new LinkedList<>();
// Same operations as ArrayList
```

#### Sets
```java
// HashSet
Set<Integer> set = new HashSet<>();
set.add(1);                          // Add element
set.contains(1);                     // Check if contains
set.remove(1);                       // Remove element
set.size();                          // Get size
set.isEmpty();                       // Check if empty

// TreeSet (sorted)
Set<Integer> treeSet = new TreeSet<>();
// Same operations as HashSet, but maintains order
```

#### Maps
```java
// HashMap
Map<String, Integer> map = new HashMap<>();
map.put("key", 1);                   // Put key-value
map.get("key");                      // Get value
map.getOrDefault("key", 0);          // Get with default
map.containsKey("key");              // Check if contains key
map.containsValue(1);                // Check if contains value
map.remove("key");                   // Remove key-value
map.size();                          // Get size
map.isEmpty();                       // Check if empty

// TreeMap (sorted by keys)
Map<String, Integer> treeMap = new TreeMap<>();
// Same operations as HashMap, but keys are sorted
```

#### Queues and Stacks
```java
// Queue (LinkedList implementation)
Queue<Integer> queue = new LinkedList<>();
queue.offer(1);                      // Add element
queue.poll();                        // Remove and return head
queue.peek();                        // View head without removing
queue.size();                        // Get size
queue.isEmpty();                     // Check if empty

// Stack
Stack<Integer> stack = new Stack<>();
stack.push(1);                       // Push element
stack.pop();                         // Pop element
stack.peek();                        // View top without removing
stack.size();                        // Get size
stack.isEmpty();                     // Check if empty

// PriorityQueue (Min Heap by default)
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
minHeap.offer(1);                    // Add element
minHeap.poll();                      // Remove and return min/max
minHeap.peek();                      // View min/max without removing
```

### String Operations
```java
// String creation and manipulation
String str = "Hello World";
str.length();                        // Get length
str.charAt(0);                       // Get character at index
str.substring(0, 5);                 // Get substring
str.indexOf("World");                // Find index of substring
str.contains("Hello");               // Check if contains substring
str.startsWith("Hello");             // Check if starts with
str.endsWith("World");               // Check if ends with
str.replace("Hello", "Hi");          // Replace substring
str.toLowerCase();                   // Convert to lowercase
str.toUpperCase();                   // Convert to uppercase
str.trim();                          // Remove leading/trailing spaces
str.split(" ");                      // Split by delimiter

// String comparison
str.equals("Hello World");           // Compare content
str.equalsIgnoreCase("hello world"); // Compare ignoring case
str.compareTo("Hello");              // Lexicographical comparison

// StringBuilder for efficient string manipulation
StringBuilder sb = new StringBuilder();
sb.append("Hello");                  // Append string
sb.insert(0, "Hi ");                // Insert at position
sb.delete(0, 3);                    // Delete substring
sb.reverse();                        // Reverse string
sb.toString();                       // Convert to String
```

### Collections Framework Operations
```java
// Sorting
List<Integer> list = Arrays.asList(3, 1, 4, 1, 5);
Collections.sort(list);              // Sort in ascending order
Collections.sort(list, Collections.reverseOrder()); // Sort in descending order
Collections.reverse(list);           // Reverse list
Collections.shuffle(list);           // Shuffle list

// Binary Search (requires sorted list)
int index = Collections.binarySearch(list, 4);

// Frequency and other operations
Collections.frequency(list, 1);      // Count occurrences
Collections.max(list);               // Find maximum
Collections.min(list);               // Find minimum
Collections.swap(list, 0, 1);        // Swap elements
```

### Bit Manipulation
```java
// Basic bit operations
int num = 5;
num << 1;                            // Left shift (multiply by 2)
num >> 1;                            // Right shift (divide by 2)
num & 1;                             // Check if odd (last bit)
num | 1;                             // Set last bit
num ^ 1;                             // Toggle last bit
~num;                                // Bitwise NOT

// Common bit manipulation patterns
(num & (num - 1)) == 0;              // Check if power of 2
num & (-num);                        // Get lowest set bit
Integer.bitCount(num);               // Count set bits
Integer.toBinaryString(num);         // Convert to binary string
Integer.parseInt("101", 2);          // Convert binary string to int
```

### Math Operations
```java
// Basic math
Math.abs(-5);                        // Absolute value
Math.max(3, 5);                      // Maximum of two numbers
Math.min(3, 5);                      // Minimum of two numbers
Math.pow(2, 3);                      // Power function
Math.sqrt(16);                       // Square root
Math.ceil(3.7);                      // Ceiling function
Math.floor(3.7);                     // Floor function
Math.round(3.7);                     // Round to nearest integer

// Random numbers
Random random = new Random();
random.nextInt(100);                 // Random int 0-99
random.nextInt();                    // Random int
random.nextDouble();                 // Random double 0.0-1.0
```

## Common Problems

### 1. Array Rotation
```java
public void rotate(int[] nums, int k) {
    k = k % nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
}

private void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}
```

### 2. Two Sum with HashMap
```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[]{map.get(complement), i};
        }
        map.put(nums[i], i);
    }
    
    return new int[]{-1, -1};
}
```

### 3. String Palindrome Check
```java
public boolean isPalindrome(String s) {
    s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
    int left = 0, right = s.length() - 1;
    
    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }
    
    return true;
}
```

### 4. Find Missing Number
```java
public int missingNumber(int[] nums) {
    int n = nums.length;
    int expectedSum = n * (n + 1) / 2;
    int actualSum = 0;
    
    for (int num : nums) {
        actualSum += num;
    }
    
    return expectedSum - actualSum;
}
```

### 5. Power of Two Check
```java
public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
}
```

### 6. Reverse Integer
```java
public int reverse(int x) {
    long result = 0;
    
    while (x != 0) {
        result = result * 10 + x % 10;
        x /= 10;
    }
    
    if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
        return 0;
    }
    
    return (int) result;
}
```

### 7. Valid Parentheses
```java
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    Map<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');
    
    for (char c : s.toCharArray()) {
        if (map.containsValue(c)) {
            stack.push(c);
        } else if (map.containsKey(c)) {
            if (stack.isEmpty() || stack.pop() != map.get(c)) {
                return false;
            }
        }
    }
    
    return stack.isEmpty();
}
```

## Key Points

### Time Complexity
- **Array operations**: O(1) for access, O(n) for search
- **List operations**: O(1) for add/remove at end, O(n) for middle
- **Set/Map operations**: O(1) average case, O(n) worst case
- **String operations**: Varies by operation

### Space Complexity
- **Data structures**: O(n) for storing n elements
- **String operations**: O(n) for creating new strings
- **Collections**: Additional overhead for object references

### Common Mistakes
1. Using == instead of .equals() for objects
2. Not handling null values
3. Forgetting to check bounds
4. Inefficient string concatenation in loops

### Tips
- Use StringBuilder for string manipulation in loops
- Choose appropriate data structure for the problem
- Consider space-time tradeoffs
- Use built-in methods when available

### Best Practices
- Always check for null and bounds
- Use appropriate data structures
- Consider immutability for thread safety
- Use meaningful variable names
- Handle edge cases properly

## Related Problems
- [1. Two Sum](https://leetcode.com/problems/two-sum/)
- [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
- [125. Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)
- [189. Rotate Array](https://leetcode.com/problems/rotate-array/)
- [268. Missing Number](https://leetcode.com/problems/missing-number/)
- [231. Power of Two](https://leetcode.com/problems/power-of-two/)
- [7. Reverse Integer](https://leetcode.com/problems/reverse-integer/)
- [49. Group Anagrams](https://leetcode.com/problems/group-anagrams/)
