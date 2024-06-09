package com.leetcode.practice.graphs.adt;

public class Pair<T, U> {

    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;

        if(!(o instanceof Pair)) return false;

        Pair<?,?> pair = (Pair<?,?>) o;

        return (this.second.equals(pair.second) || this.second.equals(pair.first))
                && (this.first.equals(pair.first) || this.first.equals(pair.second));
    }

    @Override
    public String toString() {
        return String.format("Pair[%s -> %s]", first, second);
    }
}
