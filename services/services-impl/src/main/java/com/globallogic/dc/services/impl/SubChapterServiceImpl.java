package com.globallogic.dc.services.impl;

import com.globallogic.dc.model.SubChapter;
import com.globallogic.dc.repository.SubChapterDao;
import com.globallogic.dc.services.SubChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SubChapterServiceImpl")
public class SubChapterServiceImpl implements SubChapterService {

    @Autowired
    private SubChapterDao subChapterDaoImpl;

    @Override
    public List<SubChapter> getSubChapters() {
        return subChapterDaoImpl.getAll();
    }

    @Override
    public SubChapter getSubChapterById(final String id) {
        return subChapterDaoImpl.getById(id);
    }

    @Override
    public List<SubChapter> getSubChaptersByChapterId(final String id) {
        return subChapterDaoImpl.getSubChaptersByChapterId(id);
    }
}
