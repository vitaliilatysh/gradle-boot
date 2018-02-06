package com.globallogic.dc.connector;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileSystemConnectorImpl implements FileSystemConnector {

    private static FileSystemConnectorImpl instance;

    public static FileSystemConnectorImpl getInstance() {
        if (instance == null) {
            synchronized (FileSystemConnectorImpl.class) {
                if (instance == null) {
                    instance = new FileSystemConnectorImpl();
                }
            }
        }
        return instance;
    }

    public List<String> readFile(final String fileName) {
        final List<String> rows = new ArrayList<>();
        try {
            final BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                rows.add(currentLine);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return rows;
    }
}
