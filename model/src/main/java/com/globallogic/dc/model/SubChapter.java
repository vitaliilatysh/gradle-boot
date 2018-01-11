package com.globallogic.dc.model;

import java.util.List;

public class SubChapter extends SubChapterBase {

    public SubChapter(final String key, final String title, final String description) {
        super(key, title, description);
    }

    public SubChapter(final String key, final String title, final String description, final Chapter chapter,
                      final List<Section> sections, final List<Range> ranges) {
        super(key, title, description, chapter, sections, ranges);
    }
}
