package com.akhilesh.dsa.sliding_window;

import java.util.HashMap;
import java.util.Map;

class LongestSubStringWithAtMostKDistinctChar {

    public static void main(String[] args) {
        String s = "aaabbccd";
        int k = 2;
        int result = longestSubStringWithAtMostKDistinctChar(s, k);
        System.out.println(result);
    }

    private static int longestSubStringWithAtMostKDistinctChar(String s, int k) {
        Map<Character, Integer> hmap = new HashMap<>();
        int start = 0;
        int end = 0;
        int max = 0;
        while(end < s.length()) {
            char c = s.charAt(end);
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);
            while(hmap.size() > k) {
                hmap.put(s.charAt(start), hmap.get(s.charAt(start)) -1);
                if(hmap.get(c) == 0) {
                    hmap.remove(c);
                }
                start++;
            }
            if(hmap.size() <= k) {
                max = Math.max(max, end - start + 1);
            }

            end++;
        }
        return max;
    }
}