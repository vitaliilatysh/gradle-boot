package com.globallogic.dc.services;

import com.globallogic.dc.model.Chapter;

import java.util.Arrays;
import java.util.List;

public class ChapterServiceMockImpl implements ChapterService {

    private static volatile ChapterServiceMockImpl instance = null;

    public static ChapterServiceMockImpl getInstance() {
        if (instance == null) {
            synchronized (ChapterServiceMockImpl.class) {
                if (instance == null) {
                    instance = new ChapterServiceMockImpl();
                }
            }
        }
        return instance;
    }

    public List<Chapter> getChapters() {
        return Arrays.asList(
                new Chapter("1", "Title", "Desc"),
                new Chapter("2", "Title", "Desc"));
    }

    public Chapter getChapterById(final String key) {
        Chapter chapter = new Chapter("1", "Title", "Desc");

        return chapter.getKey().equals(key) ? chapter: new Chapter();
    }
}
