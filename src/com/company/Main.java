package com.company;

import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        IPAdressValidator validator = new IPAdressValidator();

        String[] ips = {
                "dfd.cvr29188459.ip = '131\\\\.165\\\\.169\\\\.13'",
                "123.45",
                "Im.not.IP.address",
                "45\\\\.65\\\\.88\\\\.65",
                "212\\\\.98\\\\.76\\\\.201",
                "93\\.167\\.199\\.1",
                "(185\\.59\\.(?:1(?:0[6-7]))\\.(?:[0-9]|[1-9][0-9]|1(?:[0-9][0-9])|2(?:[0-4][0-9]|5[0-5])))",
                "193\\\\.163\\\\.100\\\\.(8[1-9]|9[0-5])",
                "5\\\\.56\\\\.147\\\\.130, 195\\\\.41\\\\.180\\\\.138, 194\\\\.182\\\\.245\\\\.153",
                "188\\\\.64\\\\.152\\\\.193,188\\\\.64\\\\.156\\\\.193",
                "85\\\\.236\\\\.64\\\\.(1(29|[3-8][0-9]|9[0-1]))"

        };

        for (String ip : ips) {
            System.out.printf("%20s: %b%n", ip, validator.validate(ip));
        }

    }
}
