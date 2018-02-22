package com.globallogic.dc.services;

import com.globallogic.dc.model.Range;

import java.util.List;

public interface RangeService {

    List<Range> getRanges();

    Range getRangeById(final String id);

    List<Range> getRangesBySubChapterId(final String id);

    List<Range> getRangesBySectionId(final String id);
}
