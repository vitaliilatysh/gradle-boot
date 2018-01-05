package com.globallogic.dc.model;

import java.util.Collection;
import java.util.List;

public class Chapter extends ChapterBase{

    private List<SubChapter> subChapters;

    public Chapter(final List<SubChapter> subChapters) {
        this.subChapters = subChapters;
    }

    public List<SubChapter> getSubChapters() {
        return subChapters;
    }

    public void setSubChapters(final List<SubChapter> subChapters) {
        this.subChapters = subChapters;
    }

    @Override
    public void add(final Collection<SubChapter> subChapters) {
        this.subChapters.addAll(subChapters);
    }

    @Override
    public boolean hasKey() {
        return this.getKey() != null;
    }

    @Override
    public boolean hasTitle() {
        return this.getTitle() != null;
    }

    @Override
    public boolean hasDescription() {
        return this.getDescription() != null;
    }
}
