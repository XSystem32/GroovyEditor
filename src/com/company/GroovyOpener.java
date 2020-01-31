package com.company;

import org.apache.commons.validator.routines.InetAddressValidator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroovyOpener {

    public static void main(String[] args) {
        StringBuilder inp = new StringBuilder();

        Scanner grov = new Scanner(System.in);
        Pattern pattern =
                Pattern.compile("([0-9]{1,3}\\\\{2}?.[0-9]{1,3}\\\\{2}?.[0-9]{1,3}\\\\{2}?.[0-9]{1,3})");
        Matcher match = pattern.matcher(inp.toString());
        boolean b = match.matches();

        File file = new File("C:\\Users\\yaz\\Documents\\GroovyFiles\\" + grov.nextLine() + ".groovy");
        try {
            Scanner scan = new Scanner(file);
            while (scan.nextLine().startsWith("dfd.cvr")) {
                inp.append(scan.nextLine()).append(" \n ").append(b);
            }
        } catch (
                FileNotFoundException f) {
            f.printStackTrace();
        }

        System.out.println("File inp string is " + inp);
        boolean found = match.find();
        while (match.find()) {
            if (found) {
                for (int i = 0; i <= match.groupCount(); i++) {
                    String groupStr = match.group(i);

                    int groupStart = match.start(i);
                    int groupEnd = match.end(i);

                    System.out.println(inp.subSequence(groupStart, groupEnd));
                }
            }
        }
    }

}
