package com.globallogic.dc.dao;

import com.globallogic.dc.model.Range;

import java.util.List;

public interface SectionDao {
    List<Range> getRanges();

    Range getRangeById(final String key);
}
