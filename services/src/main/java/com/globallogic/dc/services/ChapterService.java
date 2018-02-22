package com.globallogic.dc.services;

import com.globallogic.dc.model.Chapter;

import java.util.List;

public interface ChapterService {

    List<Chapter> getChapters();

    Chapter getChapterById(final String key);
}
