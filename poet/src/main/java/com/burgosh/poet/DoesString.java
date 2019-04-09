package com.burgosh.poet;

import com.burgosh.dash.Dash;

public final class DoesString {
    private final String someString;

    DoesString(final String someString) {
        this.someString = someString;
    }

    public boolean startWith(final String start) {
        return Dash.string.startsWith(start, someString);
    }

    public boolean endWith(final String end) {
        return Dash.string.endsWith(end, someString);
    }

    public boolean contain(String contain) {
        return Dash.string.contains(contain, someString);
    }
}
