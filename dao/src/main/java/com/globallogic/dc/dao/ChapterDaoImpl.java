package com.globallogic.dc.dao;

import com.globallogic.dc.connector.FileSystemConnectorImpl;
import com.globallogic.dc.model.Chapter;

import java.util.ArrayList;
import java.util.List;

public class ChapterDaoImpl implements ChapterDao {

    private static volatile ChapterDaoImpl instance = null;
    private String fileName = "chapters.csv";
    private Chapter chapter = new Chapter();
    private List<Chapter> chapters = new ArrayList<>();


    public static ChapterDaoImpl getInstance() {
        if (instance == null) {
            synchronized (ChapterDaoImpl.class) {
                if (instance == null) {
                    instance = new ChapterDaoImpl();
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

            chapter.setKey(key);
            chapter.setTitle(title);
            chapter.setDescription(description);

            chapters.add(chapter);
        }
        return chapters;
    }

    @Override
    public Chapter getChapterById(final String chapterKey) {
        final List<String> rows = new FileSystemConnectorImpl().readFile(fileName);
        for (String row : rows) {
            final String[] chapterElements = row.split(",");

            final String key = chapterElements[0];
            final String title = chapterElements[1];
            final String description = chapterElements[2];

            if (chapterKey.equals(key)) {
                chapter.setKey(key);
                chapter.setTitle(title);
                chapter.setDescription(description);
            }
        }
        return chapter;
    }
}
