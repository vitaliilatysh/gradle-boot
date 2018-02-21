package com.globallogic.dc.services;

import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.repository.ProductsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan(basePackages = {"com.globallogic.dc.services", "com.globallogic.dc.repository"})
@Configuration
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