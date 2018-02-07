package com.globallogic.dc.dao;

import com.globallogic.dc.connector.FileSystemConnectorImpl;
import com.globallogic.dc.model.Chapter;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ChapterDaoTokenizerImpl implements ChapterDao {

    private static volatile ChapterDaoTokenizerImpl instance = null;
    private String fileName = "D:\\projects\\java-trainee-latysh\\connector\\src\\main\\resources\\chapters.csv";
    private Chapter chapter = new Chapter();
    private List<Chapter> chapters = new ArrayList<>();


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
    public List<Chapter> getChapters() {
        return null;
    }

    @Override
    public Chapter getChapterById(final String chapterKey) {
        final List<String> rows = new FileSystemConnectorImpl().readFile(fileName);
        for (String row : rows) {
            final StringTokenizer stringTokenizer = new StringTokenizer(row, ",", false);
            while (stringTokenizer.hasMoreTokens()) {
                String key = stringTokenizer.nextToken();
                if (key.equals(chapterKey)) {
                    final String title = stringTokenizer.nextToken();
                    final String description = stringTokenizer.nextToken();
                    chapter.setKey(key);
                    chapter.setTitle(title);
                    chapter.setDescription(description);
                    break;
                } else {
                    break;
                }
            }
            if (chapter.getIdentifier() != null && chapter.getIdentifier().equals(chapterKey)) {
                break;
            }
        }
        return chapter;
    }
}
