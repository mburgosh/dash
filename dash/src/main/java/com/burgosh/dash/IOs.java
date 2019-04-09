package com.burgosh.dash;

import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.Map;

public class IOs {
    private static final Map<String, String> resourceContentCache = Maps.newConcurrentMap();

    public String resourceContents(String resource) {
        return resourceContentCache.computeIfAbsent(resource, k -> {
            URL url = Resources.getResource(resource);
            try {
                return Resources.toString(url, Charsets.UTF_8);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        });
    }
}
