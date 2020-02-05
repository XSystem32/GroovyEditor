package com.company;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexSyntax {

    public static void main(String[] args) {

        String regex = "";
        PatternSyntaxException exc = null;
        try {
            Pattern.compile(regex);
        } catch (
                PatternSyntaxException e) {
            exc = e;
        }
        if (exc != null) {
            exc.printStackTrace();
        } else {
            System.out.println("Regex ok!");
        }
    }
}
