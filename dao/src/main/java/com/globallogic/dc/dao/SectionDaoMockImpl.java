package com.globallogic.dc.dao;

import com.globallogic.dc.model.Range;

import java.util.List;

public class SectionDaoMockImpl implements SectionDao {

    private static volatile SectionDaoMockImpl instance = null;

    public static SectionDaoMockImpl getInstance() {
        if (instance == null) {
            synchronized (SectionDaoMockImpl.class) {
                if (instance == null) {
                    instance = new SectionDaoMockImpl();
                }
            }
        }
        return instance;
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
