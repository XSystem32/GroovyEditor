package com.company;

import org.apache.commons.validator.routines.InetAddressValidator;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroovyOpener {

    public static void main(String[] args) {
        Scanner grov = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        /*Pattern pattern2 = Pattern.compile("(([0-9]{1,3}|[^a-z])\\\\{2}?\\.{1}" +
                "([0-9]{1,3}\\\\{2}?|\\(*\\)*\\[*\\]*\\-*\\|*\\d*\\:*\\?*)\\.{1}" +
                "([0-9]{1,3}\\\\{2}?|\\(*\\)*\\[*\\]*\\-*\\|*\\d*).{1}" +
                "([0-9]{1,3}|\\(*\\)*\\[*\\]*\\-*\\|*\\d*))");*/

        Pattern pattern = Pattern.compile("(([0-9]{1,3})\\\\{2}?\\.{1})" +
                "(([0-9]{1,3})|[^a-zA-Z]\\(*\\)*\\[*\\]*\\-*\\|*\\d*\\:*\\?*)\\\\{2}?\\.{1}" +
                "(([0-9]{1,3})|[^a-zA-Z]\\(*\\)*\\[*\\]*\\-*\\|*\\d*\\:*\\?*)\\\\{2}?\\.{1}" +
                "(([0-9]{1,3})|[^a-zA-Z]\\(*\\)*\\[*\\]*\\-*\\|*\\d*\\:*\\?*)");


        try {
            System.out.println("Enter the name of the file: ");
            FileReader file = new FileReader("C:\\Users\\yaz\\Documents\\GroovyFiles\\" + grov.nextLine() + ".groovy");

            input = new Scanner(file);

            boolean check = false;

            while (input.hasNextLine()) {
                String line = input.nextLine();
                Matcher matcher = pattern.matcher(line);
                check = matcher.find();
                System.out.println(check + "\t" + line);
            }
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
