package com.globallogic.dc.services;

import com.globallogic.dc.model.Section;

import java.util.List;

public interface SectionService {

    List<Section> getSections();

    Section getSectionById(final String id);

    List<Section> getSectionsBySubChapterId(final String id);
}
