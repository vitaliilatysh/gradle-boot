package com.globallogic.dc.commons.test;

import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.model.SubChapter;

public class ChapterBuilder extends Chapter{

    private final String key;
    private final String title;
    private final String description;
    private final SubChapter subChapter;

    private ChapterBuilder(final Builder builder) {
        super();
        this.key = builder.key;
        this.title = builder.title;
        this.description = builder.description;
        this.subChapter = builder.subChapter;
    }

    public String getKey() {
        return key;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public SubChapter getSubChapter() {
        return subChapter;
    }

    public static class Builder {
        private String key;
        private String title;
        private String description;
        private SubChapter subChapter;

        public Builder key(final String key) {
            this.key = key;
            return this;
        }

        public Builder title(final String title) {
            this.title = title;
            return this;
        }

        public Builder description(final String description) {
            this.description = description;
            return this;
        }

        public Builder subChapter(final SubChapter subChapter) {
            this.subChapter = subChapter;
            return this;
        }

        public ChapterBuilder build() {
            return new ChapterBuilder(this);
        }
    }
}