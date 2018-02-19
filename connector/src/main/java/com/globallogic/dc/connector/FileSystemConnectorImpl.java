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

    private static final String BASE_CSV_PATH = System.getenv("BASE_CSV_PATH");

    public List<String> readFile(final String fileName) {
        if (isBlank(fileName)) {
            throw new IllegalArgumentException("File should be specified.");
        }

        final List<String> rows = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            if (BASE_CSV_PATH == null) {
                bufferedReader = new BufferedReader(new FileReader(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)).getFile())));
            } else {
                bufferedReader = new BufferedReader(new FileReader(new File(BASE_CSV_PATH.concat(fileName))));
            }
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
