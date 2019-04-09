package com.burgosh.dash;

import com.google.common.collect.ImmutableSet;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public final class Sets {
    Sets() {
    }

    @SafeVarargs
    public final <T> Set<T> of(T ...of) {
        return com.google.common.collect.Sets.newHashSet(of);
    }

    public final <T> Set<T> of(Iterable<? extends T> elements) {
        return com.google.common.collect.Sets.newHashSet(elements);
    }

    @SafeVarargs
    public final <T> LinkedHashSet<T> ordered(T ...elements) {
        return ordered(Arrays.asList(elements));
    }

    public final <T> LinkedHashSet<T> ordered(Iterable<? extends T> elements) {
        return com.google.common.collect.Sets.newLinkedHashSet(elements);
    }

    @SafeVarargs
    public final <T> ImmutableSet<T> immutable(T ...elements) {
        return ImmutableSet.copyOf(elements);
    }


    public final <T> ImmutableSet<T> immutable(Iterable<? extends T> elements) {
        return ImmutableSet.copyOf(elements);
    }

    public <T> ImmutableSet<T> giveAllNotIn(Set<T> all, Set<T> notIn) {
        return com.google.common.collect.Sets.difference(all, notIn).immutableCopy();
    }

    public <T> ImmutableSet<T> giveAllAlsoIn(Set<T> all, Set<T> alsoIn) {
        return com.google.common.collect.Sets.union(all, alsoIn).immutableCopy();
    }
}
