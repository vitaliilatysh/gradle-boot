package com.globallogic.dc.connector;

import com.globallogic.dc.model.Chapter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileSystemConnector {

    private static FileSystemConnector instance = null;
    private File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("chapters.csv")).getFile());
    private Chapter chapter = new Chapter();
    private List<Chapter> chapters = new ArrayList<>();

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

    public List<Chapter> getChapters() {
        {
            try {
                FileReader fileReader = new FileReader(file);
                Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(fileReader);
                for (CSVRecord record : records) {
                    String key = record.get(Headers.Key);
                    String title = record.get(Headers.Title);
                    String description = record.get(Headers.Description);

                    chapter.setKey(key);
                    chapter.setTitle(title);
                    chapter.setDescription(description);

                    chapters.add(chapter);
                }
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
        return chapters;
    }

    public enum Headers {
        Key, Title, Description
    }
}
