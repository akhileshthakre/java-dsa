# Merge Intervals Pattern

## Overview
The merge intervals pattern is used to solve problems involving overlapping intervals. The key insight is to sort intervals by start time and then merge overlapping ones. This pattern is commonly used for scheduling, meeting rooms, and time-based problems.

## When to Use
- Problems involving overlapping intervals
- Meeting room scheduling
- Time-based problems
- Range merging operations
- Calendar applications
- Problems requiring finding non-overlapping intervals

## Template

### Basic Interval Class
```java
public class Interval {
    int start;
    int end;
    
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

// Or using int array: int[] interval = {start, end};
```

### Merge Intervals Template
```java
public int[][] merge(int[][] intervals) {
    if (intervals.length <= 1) return intervals;
    
    // Sort intervals by start time
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    
    List<int[]> result = new ArrayList<>();
    int[] current = intervals[0];
    
    for (int i = 1; i < intervals.length; i++) {
        if (current[1] >= intervals[i][0]) {
            // Overlapping intervals, merge them
            current[1] = Math.max(current[1], intervals[i][1]);
        } else {
            // Non-overlapping, add current to result
            result.add(current);
            current = intervals[i];
        }
    }
    
    // Add the last interval
    result.add(current);
    
    return result.toArray(new int[result.size()][]);
}
```

### Insert Interval Template
```java
public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();
    int i = 0;
    
    // Add all intervals that come before newInterval
    while (i < intervals.length && intervals[i][1] < newInterval[0]) {
        result.add(intervals[i]);
        i++;
    }
    
    // Merge overlapping intervals
    while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        i++;
    }
    
    result.add(newInterval);
    
    // Add remaining intervals
    while (i < intervals.length) {
        result.add(intervals[i]);
        i++;
    }
    
    return result.toArray(new int[result.size()][]);
}
```

### Check Overlap Template
```java
public boolean hasOverlap(int[][] intervals) {
    if (intervals.length <= 1) return false;
    
    // Sort by start time
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    
    for (int i = 1; i < intervals.length; i++) {
        if (intervals[i-1][1] > intervals[i][0]) {
            return true; // Overlap found
        }
    }
    
    return false;
}
```

## Common Problems

### 1. Merge Intervals
```java
public int[][] merge(int[][] intervals) {
    if (intervals.length <= 1) return intervals;
    
    // Sort by start time
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    
    List<int[]> result = new ArrayList<>();
    int[] current = intervals[0];
    
    for (int i = 1; i < intervals.length; i++) {
        if (current[1] >= intervals[i][0]) {
            // Overlapping intervals
            current[1] = Math.max(current[1], intervals[i][1]);
        } else {
            // Non-overlapping
            result.add(current);
            current = intervals[i];
        }
    }
    
    result.add(current);
    return result.toArray(new int[result.size()][]);
}
```

### 2. Insert Interval
```java
public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();
    int i = 0;
    
    // Add intervals before newInterval
    while (i < intervals.length && intervals[i][1] < newInterval[0]) {
        result.add(intervals[i]);
        i++;
    }
    
    // Merge overlapping intervals
    while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        i++;
    }
    
    result.add(newInterval);
    
    // Add remaining intervals
    while (i < intervals.length) {
        result.add(intervals[i]);
        i++;
    }
    
    return result.toArray(new int[result.size()][]);
}
```

### 3. Meeting Rooms II
```java
public int minMeetingRooms(int[][] intervals) {
    if (intervals.length == 0) return 0;
    
    // Sort start times and end times separately
    int[] startTimes = new int[intervals.length];
    int[] endTimes = new int[intervals.length];
    
    for (int i = 0; i < intervals.length; i++) {
        startTimes[i] = intervals[i][0];
        endTimes[i] = intervals[i][1];
    }
    
    Arrays.sort(startTimes);
    Arrays.sort(endTimes);
    
    int rooms = 0;
    int endPointer = 0;
    
    for (int startPointer = 0; startPointer < intervals.length; startPointer++) {
        if (startTimes[startPointer] >= endTimes[endPointer]) {
            // A room is freed up
            endPointer++;
        } else {
            // Need a new room
            rooms++;
        }
    }
    
    return rooms;
}
```

### 4. Non-overlapping Intervals
```java
public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length <= 1) return 0;
    
    // Sort by end time (greedy approach)
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
    
    int count = 0;
    int end = intervals[0][1];
    
    for (int i = 1; i < intervals.length; i++) {
        if (intervals[i][0] < end) {
            // Overlapping interval, remove it
            count++;
        } else {
            // Non-overlapping, update end
            end = intervals[i][1];
        }
    }
    
    return count;
}
```

### 5. Meeting Rooms
```java
public boolean canAttendMeetings(int[][] intervals) {
    if (intervals.length <= 1) return true;
    
    // Sort by start time
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    
    for (int i = 1; i < intervals.length; i++) {
        if (intervals[i-1][1] > intervals[i][0]) {
            return false; // Overlap found
        }
    }
    
    return true;
}
```

### 6. Interval List Intersections
```java
public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    List<int[]> result = new ArrayList<>();
    int i = 0, j = 0;
    
    while (i < firstList.length && j < secondList.length) {
        // Find intersection
        int start = Math.max(firstList[i][0], secondList[j][0]);
        int end = Math.min(firstList[i][1], secondList[j][1]);
        
        if (start <= end) {
            result.add(new int[]{start, end});
        }
        
        // Move pointer with smaller end time
        if (firstList[i][1] < secondList[j][1]) {
            i++;
        } else {
            j++;
        }
    }
    
    return result.toArray(new int[result.size()][]);
}
```

### 7. Employee Free Time
```java
public List<int[]> employeeFreeTime(int[][][] schedule) {
    List<int[]> allIntervals = new ArrayList<>();
    
    // Collect all intervals
    for (int[][] employee : schedule) {
        for (int[] interval : employee) {
            allIntervals.add(interval);
        }
    }
    
    // Sort by start time
    Collections.sort(allIntervals, (a, b) -> Integer.compare(a[0], b[0]));
    
    // Merge intervals
    List<int[]> merged = new ArrayList<>();
    int[] current = allIntervals.get(0);
    
    for (int i = 1; i < allIntervals.size(); i++) {
        if (current[1] >= allIntervals.get(i)[0]) {
            current[1] = Math.max(current[1], allIntervals.get(i)[1]);
        } else {
            merged.add(current);
            current = allIntervals.get(i);
        }
    }
    merged.add(current);
    
    // Find free time
    List<int[]> freeTime = new ArrayList<>();
    for (int i = 1; i < merged.size(); i++) {
        freeTime.add(new int[]{merged.get(i-1)[1], merged.get(i)[0]});
    }
    
    return freeTime;
}
```

## Key Points

### Time Complexity
- **Sorting**: O(n log n) - most operations require sorting
- **Merging**: O(n) - single pass after sorting
- **Overall**: O(n log n) for most problems

### Space Complexity
- **Output**: O(n) for storing result
- **Auxiliary**: O(1) to O(n) depending on approach

### Common Mistakes
1. Not sorting intervals before processing
2. Incorrect overlap detection logic
3. Forgetting to handle edge cases (empty input)
4. Wrong sorting criteria (start vs end time)

### Tips
- Always sort intervals first (usually by start time)
- Use end time sorting for greedy approaches
- Consider using separate arrays for start/end times
- Think about whether you need to merge or just check overlap

### Sorting Strategies
- **By start time**: For merging and general interval operations
- **By end time**: For greedy approaches (minimum rooms, non-overlapping)
- **Custom comparator**: For specific requirements

## Related Problems
- [56. Merge Intervals](https://leetcode.com/problems/merge-intervals/)
- [57. Insert Interval](https://leetcode.com/problems/insert-interval/)
- [253. Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/)
- [435. Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/)
- [252. Meeting Rooms](https://leetcode.com/problems/meeting-rooms/)
- [986. Interval List Intersections](https://leetcode.com/problems/interval-list-intersections/)
- [759. Employee Free Time](https://leetcode.com/problems/employee-free-time/)
- [452. Minimum Number of Arrows to Burst Balloons](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/)
