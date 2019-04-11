package com.burgosh.poet;

import com.burgosh.dash.Dash;

public final class IsString {
    private final String someString;

    IsString(String someString) {
        this.someString = someString;
    }

    public boolean blank() {
        return Dash.string.isBlank(someString);
    }

    public boolean notBlank() {
        return Dash.string.isNotBlank(someString);
    }
}
