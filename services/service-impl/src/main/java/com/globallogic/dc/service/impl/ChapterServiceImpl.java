package com.globallogic.dc.service.impl;

import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.repository.api.ChapterDao;
import com.globallogic.dc.service.api.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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