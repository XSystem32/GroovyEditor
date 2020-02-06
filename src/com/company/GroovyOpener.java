package com.company;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroovyOpener {

    public static void main(String[] args) {
        Scanner grov = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        Pattern pattern = Pattern.compile("(dfd\\.cvr[0-9]{8}\\.ip = ('([()]*[0-9]{1,3}\\\\{2}?\\.{1})" +
                "(([0-9]{1,3}|[^a-zA-Z][\\(\\)\\[\\]\\-\\|\\d\\:\\?]*)\\\\{2}?\\.{1})" +
                "(([0-9]{1,3}|[^a-zA-Z][\\(\\)\\[\\]\\-\\|\\d\\:\\?]*)\\\\{2}?\\.{1})" +
                "([0-9]{1,3}|[^a-zA-Z][\\(\\)\\[\\]\\-\\|\\d\\:\\?]*)){1,3})");

        try {
            System.out.println("Enter the name of the file: ");
            FileReader file = new FileReader("C:\\Users\\yaz\\Documents\\GroovyFiles\\" + grov.nextLine() + ".groovy");

            input = new Scanner(file);

            boolean check;

            while (input.hasNext()) {
                String line = input.nextLine();
                Matcher matcher = pattern.matcher(line);
                check = matcher.find();
                if (!check) {
                    input.skip(line);
                }
                System.out.println(check + "\t" + line);

            }
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
