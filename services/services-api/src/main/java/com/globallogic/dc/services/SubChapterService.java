package com.globallogic.dc.services;

import com.globallogic.dc.model.SubChapter;

import java.util.List;

public interface SubChapterService {

    List<SubChapter> getSubChapters();

    SubChapter getSubChapterById(String id);

    List<SubChapter> getSubChaptersByChapterId(String id);
}
