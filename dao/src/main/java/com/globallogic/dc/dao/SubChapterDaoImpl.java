package com.globallogic.dc.dao;

import com.globallogic.dc.connector.FileSystemConnectorImpl;
import com.globallogic.dc.model.Range;
import com.globallogic.dc.model.Section;

import java.util.ArrayList;
import java.util.List;

public class SubChapterDaoImpl implements SubChapterDao {

    private static volatile SubChapterDaoImpl instance = null;
    private String fileName = "D:\\projects\\java-trainee-latysh\\connector\\src\\main\\resources\\subchapters.csv";
    private Section section = new Section();
    private Range range = new Range();
    private List<Section> sections = new ArrayList<>();
    private List<Range> ranges = new ArrayList<>();

    public static SubChapterDaoImpl getInstance() {
        if (instance == null) {
            synchronized (SubChapterDaoImpl.class) {
                if (instance == null) {
                    instance = new SubChapterDaoImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Section> getSections() {
        final List<String> rows = new FileSystemConnectorImpl().readFile(fileName);
        for (String row : rows) {
            final String[] sectionElements = row.split(",");
            final String key = sectionElements[0];
            final String title = sectionElements[1];
            final String description = sectionElements[2];
            sections.add(new Section(key, title, description));
        }
        return sections;
    }

    @Override
    public Section getSectionById(final String sectionKey) {
        final List<String> rows = new FileSystemConnectorImpl().readFile(fileName);
        for (String row : rows) {
            final String[] sectionElements = row.split(",");

            if (sectionElements[0].equals(sectionKey)) {
                final String key = sectionElements[0];
                final String title = sectionElements[1];
                final String description = sectionElements[2];
                section = new Section(key, title, description);
            }
            if (section.getIdentifier() != null && section.getIdentifier().equals(sectionKey)) {
                break;
            }
        }
        return section;
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
