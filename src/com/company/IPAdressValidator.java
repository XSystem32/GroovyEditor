package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAdressValidator {

    Pattern pattern;
    Matcher matcher;

    private static final String FIRST_PATTERN = "(([0-9]{1,3}\\\\{2}?\\.{1})" +
            "(([0-9]{1,3}|[^a-zA-Z][\\(\\)\\[\\]\\-\\|\\d\\:\\?]*)\\\\{2}?\\.{1})" +
            "(([0-9]{1,3}|[^a-zA-Z][\\(\\)\\[\\]\\-\\|\\d\\:\\?]*)\\\\{2}?\\.{1})" +
            "([0-9]{1,3}|[^a-zA-Z][\\(\\)\\[\\]\\-\\|\\d\\:\\?]*))";

    public IPAdressValidator() {
        pattern = Pattern.compile(FIRST_PATTERN);
    }

    public CharSequence validate(String ip) {
        matcher = pattern.matcher(ip);
        boolean found = matcher.find();
        if (found) {
            for (int i = 0; i <= matcher.groupCount(); i++) {

                int groupStart = matcher.start(i);
                int groupEnd = matcher.end(i);

                return ip.subSequence(groupStart, groupEnd);
            }
        }
        return null;
    }

    public boolean valide(final String ip){
        matcher = pattern.matcher(ip);
        return matcher.find();
    }


}
