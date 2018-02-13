package com.globallogic.dc.repository;

import com.globallogic.dc.model.Section;

import java.util.List;

public interface SectionDao extends ProductsDao<Section> {

    List<Section> getSectionsBySubChapterId(String id);
}
