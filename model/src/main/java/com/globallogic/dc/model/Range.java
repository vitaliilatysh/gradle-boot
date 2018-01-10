package com.globallogic.dc.model;

import java.util.List;

public class Range extends RangeBase {

    public Range(final String key, final String title, final String description) {
        super(key, title, description);
    }

    public Range(final String key, final String title, final String description, final List<SubChapter> subChapters, final List<Item> items, final List<Section> sections) {
        super(key, title, description, subChapters, items, sections);
    }
}
