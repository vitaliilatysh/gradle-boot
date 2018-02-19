package com.globallogic.dc.services;

import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.repository.ProductsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ComponentScan(basePackages = "com.globallogic.dc.repository.fs.impl")
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ProductsDao<Chapter> chapterDao;

    @Override
    public List<Chapter> getChapters() {
        return chapterDao.getAll();
    }

    @Override
    public Chapter getChapterById(final String key) {
        return chapterDao.getById(key);
    }
}