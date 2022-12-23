package org.example;

public class Main {
    public static final String FILE_NAME = "hurdat2-nepac-1949-2016-041317.txt";

    public static void main(String[] args) {
        new StormWindSpeedParser().outputListOfStorms(FILE_NAME);
    }
}
