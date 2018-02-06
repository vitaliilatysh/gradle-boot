package com.globallogic.dc.connector;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSystemConnector {

    private static FileSystemConnector instance;
    private List<String> rows = new ArrayList<>();

    public static FileSystemConnector getInstance() {
        if (instance == null) {
            synchronized (FileSystemConnector.class) {
                if (instance == null) {
                    instance = new FileSystemConnector();
                }
            }
        }
        return instance;
    }

    public List<String> getRows(final File file) {
        try {
            final Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                rows.add(line);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return rows;
    }
}
