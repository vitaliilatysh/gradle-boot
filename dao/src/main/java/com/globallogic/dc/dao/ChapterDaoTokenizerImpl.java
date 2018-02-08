package com.globallogic.dc.dao;

import com.globallogic.dc.connector.FileSystemConnectorImpl;
import com.globallogic.dc.model.Chapter;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ChapterDaoTokenizerImpl extends AbstractFileSystemDAO<Chapter> implements ProductsDao<Chapter> {

    private static volatile ChapterDaoTokenizerImpl instance = null;
    private static final String FILE_NAME = "chapters.csv";
    private Chapter chapter = new Chapter();
    private List<Chapter> chapters = new ArrayList<>();

    private ChapterDaoTokenizerImpl() {
    }

    public static ChapterDaoTokenizerImpl getInstance() {
        if (instance == null) {
            synchronized (ChapterDaoTokenizerImpl.class) {
                if (instance == null) {
                    instance = new ChapterDaoTokenizerImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Chapter> getAll() {
        final List<String> rows = FileSystemConnectorImpl.getInstance().readFile(getFileName());
        for (String row : rows) {
            final StringTokenizer stringTokenizer = new StringTokenizer(row, ",", false);
            while (stringTokenizer.hasMoreTokens()) {
                final String key = stringTokenizer.nextToken();
                final String title = stringTokenizer.nextToken();
                final String description = stringTokenizer.nextToken();
                chapters.add(new Chapter(key, title, description));
            }
        }
        return chapters;
    }

    @Override
    public Chapter getById(final String chapterKey) {
        final List<String> rows = FileSystemConnectorImpl.getInstance().readFile(getFileName());
        for (String row : rows) {
            final StringTokenizer stringTokenizer = new StringTokenizer(row, ",", false);
            while (stringTokenizer.hasMoreTokens()) {
                String key = stringTokenizer.nextToken();
                if (key.equals(chapterKey)) {
                    final String title = stringTokenizer.nextToken();
                    final String description = stringTokenizer.nextToken();
                    chapter = new Chapter(key, title, description);
                    break;
                } else {
                    break;
                }
            }
            if (chapter.getIdentifier().equals(chapterKey)) {
                break;
            }
        }
        return chapter;
    }

    @Override
    protected Chapter fromDto(final String dto) {
        return null;
    }

    @Override
    protected String getFileName() {
        return FILE_NAME;
    }
}