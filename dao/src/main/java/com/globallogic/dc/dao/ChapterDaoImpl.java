package com.globallogic.dc.dao;

import com.globallogic.dc.model.Chapter;

import java.util.List;

public class ChapterDaoImpl implements ChapterDao {

    private static volatile ChapterDaoImpl instance = null;

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
        return null;
    }

    @Override
    public Chapter getChapterById(final String key) {
        return null;
    }
}
