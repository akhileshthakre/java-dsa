# Heaps Pattern

## Overview
A heap is a specialized tree-based data structure that satisfies the heap property. In Java, we use PriorityQueue which implements a min-heap by default. Heaps are used for problems involving finding kth largest/smallest elements, merging sorted lists, and maintaining order while processing elements.

## When to Use
- Finding kth largest/smallest element
- Merging k sorted lists
- Top K frequent elements
- Median of data stream
- Scheduling problems
- Problems requiring maintaining order while processing

## Template

### Min Heap (Default PriorityQueue)
```java
public class MinHeapExample {
    public int[] findKSmallest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Add all elements to heap
        for (int num : nums) {
            minHeap.offer(num);
        }
        
        // Extract k smallest elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        
        return result;
    }
}
```

### Max Heap (Using Collections.reverseOrder())
```java
public class MaxHeapExample {
    public int[] findKLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Add all elements to heap
        for (int num : nums) {
            maxHeap.offer(num);
        }
        
        // Extract k largest elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        
        return result;
    }
}
```

### Custom Comparator Heap
```java
public class CustomHeapExample {
    public List<Integer> customOrder(int[] nums) {
        // Custom comparator for specific ordering
        PriorityQueue<Integer> customHeap = new PriorityQueue<>((a, b) -> {
            // Custom comparison logic
            return Integer.compare(a, b);
        });
        
        for (int num : nums) {
            customHeap.offer(num);
        }
        
        List<Integer> result = new ArrayList<>();
        while (!customHeap.isEmpty()) {
            result.add(customHeap.poll());
        }
        
        return result;
    }
}
```

### Two Heaps (Min and Max)
```java
public class TwoHeapsExample {
    private PriorityQueue<Integer> maxHeap; // Lower half
    private PriorityQueue<Integer> minHeap; // Upper half
    
    public TwoHeapsExample() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
```

## Common Problems

### 1. Kth Largest Element in Array
```java
public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    for (int num : nums) {
        minHeap.offer(num);
        
        if (minHeap.size() > k) {
            minHeap.poll();
        }
    }
    
    return minHeap.peek();
}
```

### 2. Top K Frequent Elements
```java
public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> frequency = new HashMap<>();
    
    // Count frequencies
    for (int num : nums) {
        frequency.put(num, frequency.getOrDefault(num, 0) + 1);
    }
    
    // Min heap to keep top k frequent elements
    PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
        new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
    
    for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
        minHeap.offer(entry);
        
        if (minHeap.size() > k) {
            minHeap.poll();
        }
    }
    
    // Build result
    int[] result = new int[k];
    for (int i = k - 1; i >= 0; i--) {
        result[i] = minHeap.poll().getKey();
    }
    
    return result;
}
```

### 3. Merge K Sorted Lists
```java
public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;
    
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
    
    // Add first node from each list
    for (ListNode list : lists) {
        if (list != null) {
            minHeap.offer(list);
        }
    }
    
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    
    while (!minHeap.isEmpty()) {
        ListNode node = minHeap.poll();
        current.next = node;
        current = current.next;
        
        if (node.next != null) {
            minHeap.offer(node.next);
        }
    }
    
    return dummy.next;
}
```

### 4. Find Median from Data Stream
```java
class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // Lower half
    private PriorityQueue<Integer> minHeap; // Upper half
    
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        
        // Balance the heaps
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
```

### 5. K Closest Points to Origin
```java
public int[][] kClosest(int[][] points, int k) {
    // Max heap to keep k closest points
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> 
        (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
    
    for (int[] point : points) {
        maxHeap.offer(point);
        
        if (maxHeap.size() > k) {
            maxHeap.poll();
        }
    }
    
    int[][] result = new int[k][2];
    for (int i = 0; i < k; i++) {
        result[i] = maxHeap.poll();
    }
    
    return result;
}
```

### 6. Task Scheduler
```java
public int leastInterval(char[] tasks, int n) {
    Map<Character, Integer> frequency = new HashMap<>();
    
    // Count task frequencies
    for (char task : tasks) {
        frequency.put(task, frequency.getOrDefault(task, 0) + 1);
    }
    
    // Max heap for task frequencies
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    maxHeap.addAll(frequency.values());
    
    int time = 0;
    Queue<int[]> queue = new LinkedList<>(); // [frequency, availableTime]
    
    while (!maxHeap.isEmpty() || !queue.isEmpty()) {
        time++;
        
        if (!maxHeap.isEmpty()) {
            int freq = maxHeap.poll() - 1;
            if (freq > 0) {
                queue.offer(new int[]{freq, time + n});
            }
        }
        
        if (!queue.isEmpty() && queue.peek()[1] <= time) {
            maxHeap.offer(queue.poll()[0]);
        }
    }
    
    return time;
}
```

## Key Points

### Time Complexity
- **Insertion**: O(log n)
- **Deletion**: O(log n)
- **Peek**: O(1)
- **Heapify**: O(n)

### Space Complexity
- O(n) for storing all elements

### Common Mistakes
1. Using wrong heap type (min vs max)
2. Not handling empty heap conditions
3. Incorrect comparator logic
4. Forgetting to balance two heaps

### Tips
- Use min heap to find kth largest (keep only k elements)
- Use max heap to find kth smallest (keep only k elements)
- Consider using two heaps for median problems
- Remember that PriorityQueue is min-heap by default

### Heap vs Sorting
- **Heap**: O(n log k) for kth element, O(n log n) for all elements
- **Sorting**: O(n log n) always, but simpler implementation

## Related Problems
- [215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)
- [347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)
- [23. Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)
- [295. Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/)
- [973. K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/)
- [621. Task Scheduler](https://leetcode.com/problems/task-scheduler/)
- [703. Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/)
- [692. Top K Frequent Words](https://leetcode.com/problems/top-k-frequent-words/)
