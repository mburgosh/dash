package com.burgosh.poet;

import org.apache.commons.lang3.StringUtils;

public final class Strings {
    Strings(){
    }

    public In in(String text) {
        return new In(text);
    }



    public boolean endsWith(String end, String text) {
        return StringUtils.endsWith(text, end);
    }

    public boolean contains(String c, String text) {
        return StringUtils.contains(text, c);
    }

    public final class In {
        private final String text;

        private In(String text) {
            this.text = text;
        }

        public Replace replace(String replace) {
            return new Replace(text, replace);
        }

        public final class Replace {
            private final String text;
            private final String replace;

            private Replace(String text, String replace) {
                this.text = text;
                this.replace = replace;
            }

            public String with(String with) {
                return StringUtils.replace(text, replace, with);
            }
        }
    }
}