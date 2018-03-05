package com.globallogic.dc.service;

import com.globallogic.dc.model.Chapter;

import java.util.List;

public interface ChapterService {

    List<Chapter> getChapters();

    Chapter getChapterById(String key);
}
