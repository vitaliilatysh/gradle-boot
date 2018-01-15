package com.globallogic.dc.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

public abstract class ChapterBase extends AbstractProduct {

    private List<SubChapter> subChapters;

    public ChapterBase(
            final String key,
            final String title,
            final String description) {
        super(key, title, description);
    }

    public ChapterBase(
            final String key,
            final String title,
            final String description,
            final List<SubChapter> subChapters) {
        super(key, title, description);
        this.subChapters = subChapters;
    }

    public List<SubChapter> getSubChapters() {
        return this.subChapters;
    }

    public void setSubChapters(final List<SubChapter> subChapters) {
        this.subChapters = subChapters;
    }

    public boolean hasSubChapters() {
        return isNotEmpty(this.subChapters);
    }

    public void addSubChapters(final Collection<SubChapter> subChapters) {
        if (isEmpty(this.subChapters)) this.subChapters = new ArrayList<>();
        this.subChapters.addAll(subChapters);
    }

    public void addSubChapter(final SubChapter subChapter) {
        if (isEmpty(this.subChapters)) this.subChapters = new ArrayList<>();
        this.subChapters.add(subChapter);
    }
}
