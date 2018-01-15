package com.globallogic.dc.model;

import java.util.List;

public class Chapter extends ChapterBase {

    public Chapter(
            final String key,
            final String title,
            final String description) {
        super(key, title, description);
    }

    public Chapter(
            final String key,
            final String title,
            final String description,
            final List<SubChapter> subChapters) {
        super(key, title, description, subChapters);
    }
}
