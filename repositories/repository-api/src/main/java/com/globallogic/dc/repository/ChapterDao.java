package com.globallogic.dc.repository;

import com.globallogic.dc.model.Chapter;

public interface ChapterDao extends ProductsDao<Chapter> {

    Chapter getChapterById();
}
