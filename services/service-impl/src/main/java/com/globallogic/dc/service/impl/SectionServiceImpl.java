package com.globallogic.dc.service.impl;

import com.globallogic.dc.model.Section;
import com.globallogic.dc.repository.api.SectionDao;
import com.globallogic.dc.service.api.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionDao sectionDao;

    @Override
    public List<Section> getSections() {
        return sectionDao.getAll();
    }

    @Override
    public Section getSectionById(final String id) {
        return sectionDao.getById(id);
    }

    @Override
    public List<Section> getSectionsBySubChapterId(final String id) {
        return sectionDao.getSectionsBySubChapterId(id);
    }
}
