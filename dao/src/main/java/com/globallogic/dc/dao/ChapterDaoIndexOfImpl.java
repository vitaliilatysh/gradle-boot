package com.globallogic.dc.dao;

import com.globallogic.dc.connector.FileSystemConnectorImpl;
import com.globallogic.dc.model.Chapter;

import java.util.ArrayList;
import java.util.List;

public class ChapterDaoIndexOfImpl implements ChapterDao {

    private static volatile ChapterDaoIndexOfImpl instance = null;
    private String fileName = "D:\\projects\\java-trainee-latysh\\connector\\src\\main\\resources\\chapters.csv";
    private Chapter chapter = new Chapter();
    private List<Chapter> chapters = new ArrayList<>();


    public static ChapterDaoIndexOfImpl getInstance() {
        if (instance == null) {
            synchronized (ChapterDaoIndexOfImpl.class) {
                if (instance == null) {
                    instance = new ChapterDaoIndexOfImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Chapter> getChapters() {
        final List<String> rows = new FileSystemConnectorImpl().readFile(fileName);
        for (String row : rows) {
            Chapter chapter = new Chapter();
            final StringBuilder stringBuilder = new StringBuilder();
            final List<String> stringList = new ArrayList<>();
            stringBuilder.append(row);
            while (stringBuilder.length() != 0) {
                int index = stringBuilder.indexOf(",");
                if (index != -1) {
                    String chapterElement = stringBuilder.substring(0, index);
                    stringList.add(chapterElement);
                    stringBuilder.delete(0, index + 1);
                } else {
                    String chapterElement = stringBuilder.substring(0, stringBuilder.length());
                    stringList.add(chapterElement);
                    stringBuilder.delete(0, stringBuilder.length());
                }
            }
            final String key = stringList.get(0);
            final String title = stringList.get(1);
            final String description = stringList.get(2);

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
            final StringBuilder stringBuilder = new StringBuilder();
            final List<String> stringList = new ArrayList<>();
            stringBuilder.append(row);
            while (stringBuilder.length() != 0) {
                int index = stringBuilder.indexOf(",");
                if (index != -1) {
                    String chapterElement = stringBuilder.substring(0, index);
                    stringList.add(chapterElement);
                    stringBuilder.delete(0, index + 1);
                } else {
                    String chapterElement = stringBuilder.substring(0, stringBuilder.length());
                    stringList.add(chapterElement);
                    stringBuilder.delete(0, stringBuilder.length());
                }
            }
            if (stringList.get(0).equals(chapterKey)) {
                final String key = stringList.get(0);
                final String title = stringList.get(1);
                final String description = stringList.get(2);

                chapter.setKey(key);
                chapter.setTitle(title);
                chapter.setDescription(description);
            }
        }
        return chapter;
    }
}
