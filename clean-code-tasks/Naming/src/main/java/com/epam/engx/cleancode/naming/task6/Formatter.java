package com.epam.engx.cleancode.naming.task6;

public class Formatter {

    private static final String PLUS = "+";
    private static final String PIPE = "|";
    private static final String MINUS = "-";
    private static final String UNDERSCORE = " _ ";

    public static void main(String[] args) {
        System.out.println(format("enable", "true"));
        System.out.println(format("name", "Bob"));
    }

    private static String format(String key, String value) {
        String content = key + UNDERSCORE + value;
        String minuses = repeat(MINUS, content.length());
        return PLUS +  minuses + PLUS + "\n"
                + PIPE + content + PIPE + "\n" +
                PLUS + minuses + PLUS + "\n";
    }

    private static String repeat(String symbol, int times) {
        String result = "";
        for (int i = 0; i < times; i++)
            result += symbol;
        return result;
    }
}
