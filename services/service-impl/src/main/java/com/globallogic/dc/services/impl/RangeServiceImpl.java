package com.globallogic.dc.services.impl;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.repository.RangeDao;
import com.globallogic.dc.services.RangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RangeServiceImpl implements RangeService {

    @Autowired
    private RangeDao rangeDao;

    @Override
    public List<Range> getRanges() {
        return rangeDao.getAll();
    }

    @Override
    public Range getRangeById(final String id) {
        return rangeDao.getById(id);
    }

    @Override
    public List<Range> getRangesBySubChapterId(final String id) {
        return rangeDao.getRangesBySubChapterId(id);
    }

    @Override
    public List<Range> getRangesBySectionId(final String id) {
        return rangeDao.getRangesBySectionId(id);
    }
}
