package com.globallogic.dc.connector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class FileSystemConnectorImpl implements FileSystemConnector {

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
        if (isBlank(fileName)) throw new IllegalArgumentException("File should be specified.");

        final List<String> rows = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)).getFile())));
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
