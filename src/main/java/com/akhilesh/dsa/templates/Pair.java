package com.akhilesh.dsa.templates;

import java.util.Objects;

/**
 * Generic Pair class for storing key-value pairs
 * Useful for algorithms that need to associate two values
 */
public class Pair<K, V> {
    private final K first;
    private final V second;
    
    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
    
    public K getFirst() {
        return first;
    }
    
    public V getSecond() {
        return second;
    }
    
    public K getKey() {
        return first;
    }
    
    public V getValue() {
        return second;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) obj;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
    
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
    
    /**
     * Static factory method for creating pairs
     */
    public static <K, V> Pair<K, V> of(K first, V second) {
        return new Pair<>(first, second);
    }
    
    /**
     * Convenience methods for common pair types
     */
    public static Pair<Integer, Integer> ofInts(int first, int second) {
        return new Pair<>(first, second);
    }
    
    public static Pair<Long, Long> ofLongs(long first, long second) {
        return new Pair<>(first, second);
    }
    
    public static Pair<String, String> ofStrings(String first, String second) {
        return new Pair<>(first, second);
    }
    
    public static Pair<Integer, String> ofIntString(int first, String second) {
        return new Pair<>(first, second);
    }
    
    public static Pair<String, Integer> ofStringInt(String first, int second) {
        return new Pair<>(first, second);
    }
}

