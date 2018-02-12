package com.globallogic.dc.repository;

import com.globallogic.dc.model.SubChapter;

public interface SubChapterDao extends ProductsDao<SubChapter> {

    SubChapter getSubChapterById();
}
