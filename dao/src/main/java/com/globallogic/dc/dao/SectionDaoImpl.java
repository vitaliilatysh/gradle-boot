package com.globallogic.dc.dao;

import com.globallogic.dc.model.Range;

import java.util.List;

public class SectionDaoImpl implements SectionDao {

    private static volatile SectionDaoImpl instance = null;

    public static SectionDaoImpl getInstance() {
        if (instance == null) {
            synchronized (SectionDaoImpl.class) {
                if (instance == null) {
                    instance = new SectionDaoImpl();
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
