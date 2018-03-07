package com.globallogic.dc.service.api;

import com.globallogic.dc.model.Chapter;

import java.util.List;

public interface ChapterService {

    List<Chapter> getChapters();

    Chapter getChapterById(String key);
}
