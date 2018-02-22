package com.globallogic.dc.services.impl;

import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.repository.ProductsDao;
import com.globallogic.dc.services.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    private final ProductsDao<Chapter> chapterDao;

    @Autowired
    public ChapterServiceImpl(@Qualifier("ChapterDaoImpl") ProductsDao<Chapter> chapterDao) {
        this.chapterDao = chapterDao;
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