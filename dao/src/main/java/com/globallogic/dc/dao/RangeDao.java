package com.globallogic.dc.dao;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.model.Section;
import com.globallogic.dc.model.SubChapter;

import java.util.List;

public interface RangeDao {
    List<SubChapter> getSubChapters();

    SubChapter getSubChapterById(final String key);

    List<Range> getRanges();

    Range getRangeById(final String key);

    List<Section> getSections();

    Section getSectionById(final String key);
}
