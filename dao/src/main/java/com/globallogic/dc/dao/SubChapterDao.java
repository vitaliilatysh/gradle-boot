package com.globallogic.dc.dao;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.model.Section;

import java.util.List;

public interface SubChapterDao {
    List<Section> getSections();

    Section getSectionById(final String key);

    List<Range> getRanges();

    Range getRangeById(final String key);

}
