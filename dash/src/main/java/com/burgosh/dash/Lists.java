package com.burgosh.dash;

import com.google.common.collect.ImmutableList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class Lists {
    Lists() {
    }

    @SafeVarargs
    public final <T> List<T> of(T ...elements) {
        return com.google.common.collect.Lists.newArrayList(elements);
    }

    public final <T> List<T> of(Iterable<? extends T> elements) {
        return com.google.common.collect.Lists.newArrayList(elements);
    }

    @SafeVarargs
    public final <T> LinkedList<T> linked(T ...elements) {
        return linked(Arrays.asList(elements));
    }

    public final <T> LinkedList<T> linked(Iterable<? extends T> elements) {
        return com.google.common.collect.Lists.newLinkedList(elements);
    }

    @SafeVarargs
    public final <T> CopyOnWriteArrayList<T> concurrent(T ...elements) {
        return concurrent(Arrays.asList(elements));
    }

    public final <T> CopyOnWriteArrayList<T> concurrent(Iterable<? extends T> elements) {
        return com.google.common.collect.Lists.newCopyOnWriteArrayList(elements);
    }

    @SafeVarargs
    public final <T> ImmutableList<T> ofFinal(T ...elements) {
        return ImmutableList.copyOf(elements);
    }

    public final <T> ImmutableList<T> ofFinal(Iterable<? extends T> elements) {
        return ImmutableList.copyOf(elements);
    }
}
