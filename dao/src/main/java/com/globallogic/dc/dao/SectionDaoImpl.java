package com.globallogic.dc.dao;

import com.globallogic.dc.connector.FileSystemConnectorImpl;
import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.model.Range;

import java.util.ArrayList;
import java.util.List;

public class SectionDaoImpl implements SectionDao {

    private static volatile SectionDaoImpl instance = null;
    private String fileName = "D:\\projects\\java-trainee-latysh\\connector\\src\\main\\resources\\sections.csv";
    private Chapter chapter = new Chapter();
    private Range range = new Range();
    private List<Range> ranges = new ArrayList<>();

    public static SectionDaoImpl getInstance() {
        if (instance == null) {
            synchronized (SectionDaoImpl.class) {
                if (instance == null) {
                    instance = new SectionDaoImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Range> getRanges() {
        final List<String> rows = new FileSystemConnectorImpl().readFile(fileName);
        for (String row : rows) {
            final String[] rangeElements = row.split(",");
            final String key = rangeElements[0];
            final String title = rangeElements[1];
            final String description = rangeElements[2];
            ranges.add(new Range(key, title, description));
        }
        return ranges;
    }

    @Override
    public Range getRangeById(final String rangeKey) {
        final List<String> rows = new FileSystemConnectorImpl().readFile(fileName);
        for (String row : rows) {
            final String[] rangeElements = row.split(",");

            if (rangeElements[0].equals(rangeKey)) {
                final String key = rangeElements[0];
                final String title = rangeElements[1];
                final String description = rangeElements[2];
                range = new Range(key, title, description);
            }
            if (range.getIdentifier() != null && range.getIdentifier().equals(rangeKey)) {
                break;
            }
        }
        return range;
    }
}
