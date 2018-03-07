package com.globallogic.dc.service.api;

import com.globallogic.dc.model.Range;

import java.util.List;

public interface RangeService {

    List<Range> getRanges();

    Range getRangeById(String id);

    List<Range> getRangesBySubChapterId(String id);

    List<Range> getRangesBySectionId(String id);
}
