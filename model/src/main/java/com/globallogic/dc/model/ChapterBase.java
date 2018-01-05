package com.globallogic.dc.model;

import java.util.Collection;
import java.util.List;

public abstract class ChapterBase extends ProductBase {

    private List<SubChapter> subChapters;

    public List<SubChapter> getSubChapters() {
        return subChapters;
    }

    public void setSubChapters(final List<SubChapter> subChapters) {
        this.subChapters = subChapters;
    }

    abstract public void addSubChapters(final Collection<SubChapter> subChapters);
    abstract public void addSubChapter(final Collection<SubChapter> subChapter);

}
