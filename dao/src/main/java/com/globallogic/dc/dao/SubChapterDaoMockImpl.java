package com.globallogic.dc.dao;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.model.Section;

import java.util.List;

public class SubChapterDaoMockImpl implements SubChapterDao {

    private static volatile SubChapterDaoMockImpl instance = null;

    public static SubChapterDaoMockImpl getInstance() {
        if (instance == null) {
            synchronized (SubChapterDaoMockImpl.class) {
                if (instance == null) {
                    instance = new SubChapterDaoMockImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Section> getSections() {
        return null;
    }

    @Override
    public Section getSectionById(final String key) {
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
}
