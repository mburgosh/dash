package com.burgosh.poet;

import java.util.List;

public final class IsList<T> {
    private final List<T> list;

    IsList(List<T> list) {
        this.list = list;
    }

    public boolean empty() {
        return list.isEmpty();
    }

    public boolean notEmpty() {
        return !list.isEmpty();
    }
}
