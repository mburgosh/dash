package com.burgosh.poet;

import com.burgosh.dash.Dash;
import com.google.common.collect.ImmutableSet;

import java.util.Set;

public class GiveAllNotIn<T> {
    private final Set<T> toExclude;

    public GiveAllNotIn(Set<T> toExclude) {
        this.toExclude = toExclude;
    }

    public ImmutableSet<T> butIn(Set<T> toKeep) {
        return Dash.set.giveAllNotIn(toExclude, toKeep);
    }
}
