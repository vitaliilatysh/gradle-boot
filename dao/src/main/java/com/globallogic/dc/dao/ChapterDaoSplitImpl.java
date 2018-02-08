package com.globallogic.dc.dao;

import com.globallogic.dc.connector.FileSystemConnectorImpl;
import com.globallogic.dc.model.Chapter;

import java.util.ArrayList;
import java.util.List;

public class ChapterDaoSplitImpl implements ChapterDao {

    private static volatile ChapterDaoSplitImpl instance = null;
    private String fileName = "D:\\projects\\java-trainee-latysh\\connector\\src\\main\\resources\\chapters.csv";
    private Chapter chapter = new Chapter();
    private List<Chapter> chapters = new ArrayList<>();


    public static ChapterDaoSplitImpl getInstance() {
        if (instance == null) {
            synchronized (ChapterDaoSplitImpl.class) {
                if (instance == null) {
                    instance = new ChapterDaoSplitImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Chapter> getChapters() {
        final List<String> rows = new FileSystemConnectorImpl().readFile(fileName);
        for (String row : rows) {
            final String[] chapterElements = row.split(",");
            final String key = chapterElements[0];
            final String title = chapterElements[1];
            final String description = chapterElements[2];
            chapters.add(new Chapter(key, title, description));
        }
        return chapters;
    }

    @Override
    public Chapter getChapterById(final String chapterKey) {
        final List<String> rows = new FileSystemConnectorImpl().readFile(fileName);
        for (String row : rows) {
            final String[] chapterElements = row.split(",");

            if (chapterElements[0].equals(chapterKey)) {
                final String key = chapterElements[0];
                final String title = chapterElements[1];
                final String description = chapterElements[2];
                chapter = new Chapter(key, title, description);
            }
            if (chapter.getIdentifier() != null && chapter.getIdentifier().equals(chapterKey)) {
                break;
            }
        }
        return chapter;
    }
}
