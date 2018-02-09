package com.globallogic.dc.services;

import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.repository.ProductsDao;
import com.globallogic.dc.repository.fs.impl.split.ChapterDaoSplitImpl;

import java.util.List;

public class ChapterServiceImpl implements ChapterService {

    private static volatile ChapterServiceImpl instance = null;
    private ProductsDao<Chapter> chapterDao = ChapterDaoSplitImpl.getInstance();

    public static ChapterServiceImpl getInstance() {
        if (instance == null) {
            synchronized (ChapterServiceImpl.class) {
                if (instance == null) {
                    instance = new ChapterServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Chapter> getChapters() {
        return chapterDao.getAll();
    }

    @Override
    public Chapter getChapterById(final String key) {
        return chapterDao.getById(key);
    }
}