package com.globallogic.dc.services.impl;

import com.globallogic.dc.model.Section;
import com.globallogic.dc.repository.SectionDao;
import com.globallogic.dc.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SectionServiceImpl")
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
