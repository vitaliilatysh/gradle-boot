package com.globallogic.dc.dao;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.model.Section;

import java.util.List;

public class SubChapterDaoImpl implements SubChapterDao {

    private static volatile SubChapterDaoImpl instance = null;

    public static SubChapterDaoImpl getInstance() {
        if (instance == null) {
            synchronized (SubChapterDaoImpl.class) {
                if (instance == null) {
                    instance = new SubChapterDaoImpl();
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
