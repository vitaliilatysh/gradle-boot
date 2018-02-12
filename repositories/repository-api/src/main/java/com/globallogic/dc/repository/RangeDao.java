package com.globallogic.dc.repository;

import com.globallogic.dc.model.Range;

public interface RangeDao extends ProductsDao<Range> {

    Range getRangeById(String id);
}
