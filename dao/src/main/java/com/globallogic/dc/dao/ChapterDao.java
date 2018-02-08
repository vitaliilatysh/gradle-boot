package com.globallogic.dc.dao;

import com.globallogic.dc.model.Chapter;

import java.util.List;

public interface ChapterDao {

    List<Chapter> getChapters();

    Chapter getChapterById(final String key);
}
