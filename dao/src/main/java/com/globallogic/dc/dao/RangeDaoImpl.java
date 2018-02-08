package com.globallogic.dc.dao;

import com.globallogic.dc.connector.FileSystemConnectorImpl;
import com.globallogic.dc.model.Range;
import com.globallogic.dc.model.Section;
import com.globallogic.dc.model.SubChapter;

import java.util.ArrayList;
import java.util.List;

public class RangeDaoImpl implements RangeDao {

    private static volatile RangeDaoImpl instance = null;
    private String fileName = "D:\\projects\\java-trainee-latysh\\connector\\src\\main\\resources\\ranges.csv";
    private SubChapter subChapter = new SubChapter();
    private Range range = new Range();
    private Section section = new Section();
    private List<SubChapter> subChapters = new ArrayList<>();
    private List<Range> ranges = new ArrayList<>();
    private List<Section> sections = new ArrayList<>();

    public static RangeDaoImpl getInstance() {
        if (instance == null) {
            synchronized (RangeDaoImpl.class) {
                if (instance == null) {
                    instance = new RangeDaoImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<SubChapter> getSubChapters() {
        final List<String> rows = new FileSystemConnectorImpl().readFile(fileName);
        for (String row : rows) {
            final String[] subChapterElements = row.split(",");
            final String key = subChapterElements[0];
            final String title = subChapterElements[1];
            final String description = subChapterElements[2];
            subChapters.add(new SubChapter(key, title, description));
        }
        return subChapters;
    }

    @Override
    public SubChapter getSubChapterById(final String subChapterKey) {
        final List<String> rows = new FileSystemConnectorImpl().readFile(fileName);
        for (String row : rows) {
            final String[] subChapterElements = row.split(",");

            if (subChapterElements[0].equals(subChapterKey)) {
                final String key = subChapterElements[0];
                final String title = subChapterElements[1];
                final String description = subChapterElements[2];
                subChapter = new SubChapter(key, title, description);
            }
            if (subChapter.getIdentifier() != null && subChapter.getIdentifier().equals(subChapterKey)) {
                break;
            }
        }
        return subChapter;
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
}
