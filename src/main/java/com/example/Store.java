package com.example;

import java.io.FileWriter;
import java.io.IOException;

public class Store {
    public static void write(String line) {
        try {
            tryWrite(line);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    private static void tryWrite(String line) throws IOException {
        FileWriter fileWriter = new FileWriter("adat.txt", true);
        fileWriter.write(line);
        fileWriter.write("\n");
        fileWriter.close();
    }
}
