package com.globallogic.dc.repository.api;

import com.globallogic.dc.model.SubChapter;

import java.util.List;

public interface SubChapterDao extends ProductsDao<SubChapter> {

    List<SubChapter> getSubChaptersByChapterId(String id);
}
