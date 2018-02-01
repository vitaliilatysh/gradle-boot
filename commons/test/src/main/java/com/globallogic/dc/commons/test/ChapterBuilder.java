package com.globallogic.dc.commons.test;

import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.model.SubChapter;

import java.util.List;

public class ChapterBuilder {

    private String key;
    private String title;
    private String description;
    private List<SubChapter> subChapters;

    public ChapterBuilder() {
    }

    public ChapterBuilder withKey(final String key) {
        this.key = key;
        return this;
    }

    public ChapterBuilder witTitle(final String title) {
        this.title = title;
        return this;
    }

    public ChapterBuilder withDescription(final String description) {
        this.description = description;
        return this;
    }

    public ChapterBuilder withSubChapters(final List<SubChapter> subChapters) {
        this.subChapters = subChapters;
        return this;
    }

    public Chapter build() {
        return new Chapter(key, title, description, subChapters);
    }
}