package com.globallogic.dc.dao;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.model.Section;
import com.globallogic.dc.model.SubChapter;

import java.util.List;

public class RangeDaoImpl implements RangeDao {

    private static volatile RangeDaoImpl instance = null;

    public static RangeDaoImpl getInstance() {
        if (instance == null) {
            synchronized (RangeDaoImpl.class) {
                if (instance == null) {
                    instance = new RangeDaoImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<SubChapter> getSubChapters() {
        return null;
    }

    @Override
    public SubChapter getSubChapterById(final String key) {
        return null;
    }

    @Override
    public List<Range> getRanges() {
        return null;
    }

    @Override
    public Range getRangeById(final String key) {
        return null;
    }

    @Override
    public List<Section> getSections() {
        return null;
    }

    @Override
    public Section getSectionById(final String key) {
        return null;
    }
}
