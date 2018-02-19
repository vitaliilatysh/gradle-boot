package com.globallogic.dc.services;

import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.repository.ProductsDao;
import com.globallogic.dc.repository.fs.impl.ChapterDaoImpl;
import com.globallogic.dc.services.config.ServiceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class ChapterServiceImpl implements ChapterService {

    private AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(ServiceConfig.class);
    private ProductsDao<Chapter> chapterDao = container.getBean(ChapterDaoImpl.class);

    @Override
    public List<Chapter> getChapters() {
        return chapterDao.getAll();
    }

    @Override
    public Chapter getChapterById(final String key) {
        return chapterDao.getById(key);
    }
}