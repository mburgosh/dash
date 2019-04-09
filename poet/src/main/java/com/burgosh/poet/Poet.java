package com.burgosh.poet;

import com.burgosh.dash.Dash;

import java.util.List;
import java.util.Set;

public final class Poet {
    private Poet() {
    }

    private static final Strings strings = new Strings();

    public static DoesString does(String someString) {
        return new DoesString(someString);
    }

    public static IsString is(String someString) {
        return new IsString(someString);
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

    public static Strings.Replace in(String toReplace) {
        return strings.replace(toReplace);
    }
}
