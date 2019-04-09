package com.burgosh.dash;

import org.apache.commons.lang3.StringUtils;

public class Strings {
    Strings(){
    }

    public Replace replace(String toReplace) {
        return new Replace(toReplace);
    }

    public String replace(String text, String search, String replacement) {
        return StringUtils.replace(text, search, replacement);
    }

    public boolean isNotBlank(final CharSequence cs) {
        return StringUtils.isNotBlank(cs);
    }

    public boolean isNotBlank_andNotNull(final CharSequence cs) {
        /* This method is here to remind yoi that this also checks for null*/
        return StringUtils.isNotBlank(cs);
    }

    public class Replace {
        private final String toReplace;

        private Replace(String toReplace) {
            this.toReplace = toReplace;
        }

        public ReplaceWith with(String replacement) {
            return new ReplaceWith(toReplace, replacement);
        }

        public class ReplaceWith {
            private final String toReplace;
            private final String replacement;

            private ReplaceWith(String toReplace, String replacement) {
                this.toReplace = toReplace;
                this.replacement = replacement;
            }

            public String in(String stringToReplace) {
                return StringUtils.replace(stringToReplace, toReplace, replacement);
            }
        }
    }
}
