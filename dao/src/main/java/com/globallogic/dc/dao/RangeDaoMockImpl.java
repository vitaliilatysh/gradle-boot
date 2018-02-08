package com.globallogic.dc.dao;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.model.Section;
import com.globallogic.dc.model.SubChapter;

import java.util.List;

public class RangeDaoMockImpl implements RangeDao {

    private static volatile RangeDaoMockImpl instance = null;

    public static RangeDaoMockImpl getInstance() {
        if (instance == null) {
            synchronized (RangeDaoMockImpl.class) {
                if (instance == null) {
                    instance = new RangeDaoMockImpl();
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
