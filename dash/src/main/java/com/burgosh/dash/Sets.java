package com.burgosh.dash;

import com.google.common.collect.ImmutableSet;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public final class Sets {
    Sets() {
    }

    @SafeVarargs
    public final <T> Set<T> of(T ...elements) {
        return com.google.common.collect.Sets.newHashSet(elements);
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
}
