package com.globallogic.dc.services.impl;

import com.globallogic.dc.model.SubChapter;
import com.globallogic.dc.repository.SubChapterDao;
import com.globallogic.dc.services.SubChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubChapterServiceImpl implements SubChapterService {

    @Autowired
    private SubChapterDao subChapterDao;

    @Override
    public List<SubChapter> getSubChapters() {
        return subChapterDao.getAll();
    }

    @Override
    public SubChapter getSubChapterById(final String id) {
        return subChapterDao.getById(id);
    }

    @Override
    public List<SubChapter> getSubChaptersByChapterId(final String id) {
        return subChapterDao.getSubChaptersByChapterId(id);
    }
}
