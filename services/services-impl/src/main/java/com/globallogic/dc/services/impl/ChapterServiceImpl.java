package com.globallogic.dc.services.impl;

import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.repository.ChapterDao;
import com.globallogic.dc.services.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ChapterServiceImpl")
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterDao chapterDao;

    @Override
    public List<Chapter> getChapters() {
        return chapterDao.getAll();
    }

    @Override
    public Chapter getChapterById(final String key) {
        return chapterDao.getById(key);
    }
}