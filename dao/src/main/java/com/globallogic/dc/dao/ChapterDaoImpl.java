package com.globallogic.dc.dao;

import com.globallogic.dc.connector.FileSystemConnector;
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
        List<String> rows = new FileSystemConnector().readFile(fileName);
        rows.remove(0);
        for (String row : rows) {
            String[] chapterElements = row.split(",");

            String key = chapterElements[0];
            String title = chapterElements[1];
            String description = chapterElements[2];

            chapter.setKey(key);
            chapter.setTitle(title);
            chapter.setDescription(description);

            chapters.add(chapter);
        }
        return chapters;
    }

    @Override
    public Chapter getChapterById(final String key) {
        return null;
    }
}
