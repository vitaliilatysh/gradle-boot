package com.globallogic.dc.repository;

import com.globallogic.dc.model.Range;

import java.util.List;

public interface RangeDao extends ProductsDao<Range> {

    List<Range> getRangesBySubChapterId(String id);

    List<Range> getRangesBySectionId(String id);
}
