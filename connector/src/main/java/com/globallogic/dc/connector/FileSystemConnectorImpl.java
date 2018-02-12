package com.globallogic.dc.connector;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileSystemConnectorImpl implements FileSystemConnector {

    private static final String FILE_PATH = "/Users/vitaliilatysh/java-trainee-latysh/connector/src/main/resources/";
    private static FileSystemConnectorImpl instance;

    private FileSystemConnectorImpl() {
    }

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
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(FILE_PATH.concat(fileName)));
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                rows.add(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return rows;
    }
}
