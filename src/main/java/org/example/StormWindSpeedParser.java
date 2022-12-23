package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class StormWindSpeedParser {
    public void outputListOfStorms(String fileName) {
        String path = getFilePath(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] headerLine = line.split(",");
                int year = Integer.parseInt(headerLine[0].substring(4));
                String stormName = headerLine[1].trim();
                int rowsNumber = Integer.parseInt(headerLine[2].trim());
                if (year > 2015 && stormName.endsWith("A")) {
                    int maxWindSpeed = 0;
                    for (int i = 0; i < rowsNumber; i++) {
                        line = reader.readLine();
                        String[] splitLine = line.split(",");
                        int windSpeed = Integer.parseInt(splitLine[6].trim());
                        maxWindSpeed = Math.max(windSpeed, maxWindSpeed);
                    }
                    System.out.println(stormName + ", " + maxWindSpeed);
                }
                else {
                    for (int i = 0; i < rowsNumber; i++) {
                        reader.readLine();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getFilePath(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return Objects.requireNonNull(classLoader.getResource(fileName)).getPath();
    }
}
