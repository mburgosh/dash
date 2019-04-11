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

        public With with(String with) {
            return new With(toReplace, with);
        }

        public final class With {
            private final String toReplace;
            private final String with;

            private With(String toReplace, String with) {
                this.toReplace = toReplace;
                this.with = with;
            }

            public String in(String in) {
                return StringUtils.replace(in, toReplace, with);
            }
        }
    }
}