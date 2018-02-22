package com.globallogic.dc.services;

import com.globallogic.dc.model.Section;

import java.util.List;

public interface SectionService {

    List<Section> getSections();

    Section getSectionById(String id);

    List<Section> getSectionsBySubChapterId(String id);
}
