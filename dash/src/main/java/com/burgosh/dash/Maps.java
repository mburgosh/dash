package com.burgosh.dash;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.SetMultimap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public final class Maps {
    Maps() {
    }

    public final <K, V> Map<K, V> of(K k, V v) {
        return ofEntries(entry(k, v));
    }

    public final <K, V> Map<K, V> of(K k1, V v1, K k2, V v2) {
        return ofEntries(entry(k1, v1), entry(k2, v2));
    }

    public final <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
        return ofEntries(entry(k1, v1), entry(k2, v2), entry(k3, v3));
    }

    public final <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        return ofEntries(entry(k1, v1), entry(k2, v2), entry(k3, v3), entry(k4, v4));
    }

    public final <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return ofEntries(entry(k1, v1), entry(k2, v2), entry(k3, v3), entry(k4, v4), entry(k5, v5));
    }

    @SafeVarargs
    public final <K, V> Map<K, V> ofEntries(Map.Entry<K, V>... entries) {
        HashMap<K, V> map = new HashMap<>();
        for (int i = 0; i < entries.length; i++) {
            map.put(entries[i].getKey(), entries[i].getValue());
        }
        return map;
    }

    public final <K, V> ImmutableMap<K, V> immutable(K k, V v) {
        return ImmutableMap.of(k, v);
    }

    public final <K, V> ImmutableMap<K, V> immutable(K k1, V v1, K k2, V v2) {
        return ImmutableMap.of(k1, v1, k2, v2);
    }

    public final <K, V> ImmutableMap<K, V> immutable(K k1, V v1, K k2, V v2, K k3, V v3) {
        return ImmutableMap.of(k1, v1, k2, v2, k3, v3);
    }

    public final <K, V> ImmutableMap<K, V> immutable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        return ImmutableMap.of(k1, v1, k2, v2, k3, v3, k4, v4);
    }

    public final <K, V> ImmutableMap<K, V> immutable(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return ImmutableMap.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
    }

    public final <K, V> ImmutableMap<K, V> immutableEntries(Map.Entry<K, V>... entries) {
        ImmutableMap.Builder<K, V> builder = ImmutableMap.builder();
        for (int i = 0; i < entries.length; i++) {
            builder.put(entries[i]);
        }
        return builder.build();
    }

    public final <K, V> ConcurrentMap<K, V> concurrent() {
        return com.google.common.collect.Maps.newConcurrentMap();
    }

    public final <K, V> ConcurrentMap<K, V> concurrent(Map<K, V> map) {
        final ConcurrentMap<K, V> concurrentMap = com.google.common.collect.Maps.newConcurrentMap();
        concurrentMap.putAll(map);
        return concurrentMap;
    }

    public final <K, V> ListMultimap<K, V> multimapList() {
        return MultimapBuilder.hashKeys().arrayListValues().build();
    }

    public final <K, V> SetMultimap<K, V> multimapSet() {
        return MultimapBuilder.hashKeys().hashSetValues().build();
    }

    public final <K, V> Map.Entry<K, V> entry(K key, V value) {
        return new DashEntry<>(key, value);
    }

    public static class DashEntry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private       V value;

        private DashEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }
    }
}
