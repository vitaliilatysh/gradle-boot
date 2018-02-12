package com.globallogic.dc.repository;

import com.globallogic.dc.model.Section;

public interface SectionDao extends ProductsDao<Section> {

    Section getSectionById();
}
