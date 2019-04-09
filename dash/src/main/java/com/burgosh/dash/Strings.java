package com.burgosh.dash;

import org.apache.commons.lang3.StringUtils;

public final class Strings {
    Strings(){
    }

    public String replaceIn(String text, String search, String replacement) {
        return StringUtils.replace(text, search, replacement);
    }

    public boolean startsWith(String start, String text) {
        return StringUtils.startsWith(text, start);
    }

    public boolean isNotBlank(final CharSequence cs) {
        return StringUtils.isNotBlank(cs);
    }

    public boolean isBlank(CharSequence cs) {
        return StringUtils.isBlank(cs);
    }

    public boolean isNotBlank_andNotNull(final CharSequence cs) {
        /* This method is here to remind you that this also checks for null*/
        return StringUtils.isNotBlank(cs);
    }

    public boolean endsWith(String end, String text) {
        return StringUtils.endsWith(text, end);
    }

    public boolean contains(String c, String text) {
        return StringUtils.contains(text, c);
    }
}
