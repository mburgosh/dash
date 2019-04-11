package com.burgosh.poet;

import com.burgosh.dash.Dash;

import java.util.List;
import java.util.Set;

public final class Poet {
    private Poet() {
    }

    private static final Strings strings = new Strings();

    public static DoesString does(String does) {
        return new DoesString(does);
    }

    public static boolean isNull(Object isNull) {
        return isNull == null;
    }

    public static IsString is(String is) {
        return new IsString(is);
    }

    public static <T> IsList<T> is(List<T> list) {
        return new IsList<>(list);
    }

    public static <T> GiveAllIn<T> giveAllIn(Set<T> set) {
        return new GiveAllIn<>(set);
    }

    public static <T> GiveAllIn<T> giveAllIn(List<T> list) {
        return giveAllIn(Dash.set.of(list));
    }

    public static <T> GiveAllNotIn<T> giveAllNotIn(Set<T> set) {
        return new GiveAllNotIn<>(set);
    }

    public static <T> GiveAllNotIn<T> giveAllNotIn(List<T> list) {
        return giveAllNotIn(Dash.set.of(list));
    }

    public static Strings.Replace replace(String replace) {
        return strings.replace(replace);
    }
}
