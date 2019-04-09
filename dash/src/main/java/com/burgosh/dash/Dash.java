package com.burgosh.dash;

import one.util.streamex.EntryStream;
import one.util.streamex.StreamEx;

import java.util.Collection;
import java.util.Map;

public class Dash {
    public static final Lists   list   = new Lists();
    public static final Sets    set    = new Sets();
    public static final IOs     io     = new IOs();
    public static final Maps    map    = new Maps();
    public static final Strings string = new Strings();

    private Dash() {
    }

    public static <T> StreamEx<T> stream(Collection<? extends T> collection) {
        return StreamEx.of(collection);
    }

    public static <K, V> EntryStream<K, V> stream(Map<K, V> map) {
        return EntryStream.of(map);

    }
}
