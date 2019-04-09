package com.burgosh.poet;

import org.apache.commons.lang3.StringUtils;

public final class Strings {
    Strings(){
    }

    public Replace replace(String toReplace) {
        return new Replace(toReplace);
    }



    public boolean endsWith(String end, String text) {
        return StringUtils.endsWith(text, end);
    }

    public boolean contains(String c, String text) {
        return StringUtils.contains(text, c);
    }

    public final class Replace {
        private final String toReplace;

        private Replace(String toReplace) {
            this.toReplace = toReplace;
        }

        public ReplaceWith replace(String replacement) {
            return new ReplaceWith(toReplace, replacement);
        }

        public final class ReplaceWith {
            private final String toReplace;
            private final String replacement;

            private ReplaceWith(String toReplace, String replacement) {
                this.toReplace = toReplace;
                this.replacement = replacement;
            }

            public String with(String stringToReplace) {
                return StringUtils.replace(stringToReplace, toReplace, replacement);
            }
        }
    }
}