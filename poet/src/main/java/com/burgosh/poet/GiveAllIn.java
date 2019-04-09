package com.burgosh.poet;

import com.burgosh.dash.Dash;
import com.google.common.collect.ImmutableSet;

import java.util.Set;

public final class GiveAllIn<T> {
    private final Set<T> all;

    GiveAllIn(Set<T> all) {
        this.all = all;
    }

    public ImmutableSet<T> notIn(Set<T> notIn) {
        return Dash.set.giveAllNotIn(all, notIn);
    }

    public ImmutableSet<T> alsoIn(Set<T> in) {
        return Dash.set.giveAllAlsoIn(all, in);
    }
}
