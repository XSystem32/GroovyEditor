package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAdressValidator {

    Pattern pattern;
    Matcher matcher;

    private static final String IPADDRESS_PATTERN =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\\\{2}?." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\\\{2}?." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\\\{2}?." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    private static final String FIRST_PATTERN = "([0-9]{1,3}\\\\{2}?.[0-9]{1,3}\\\\{2}?.[0-9]{1,3}\\\\{2}?.[0-9]{1,3})";

    private static final String THIRD_PATTERN = "([0-9]{1,3}\\\\{2}?.[0-9]{1,3}\\\\{2}?.[0-9]{1,3}\\\\{2}?.[0-9]{1,3})";


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


}
