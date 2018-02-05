package com.globallogic.dc.dao;

import com.globallogic.dc.model.Chapter;

import java.util.List;

public class ChapterDaoMockImpl implements ChapterDao {

    private static volatile ChapterDaoMockImpl instance = null;

    public static ChapterDaoMockImpl getInstance() {
        if (instance == null) {
            synchronized (ChapterDaoMockImpl.class) {
                if (instance == null) {
                    instance = new ChapterDaoMockImpl();
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
    public Chapter getChapterById(final String key) {
        return null;
    }
}
