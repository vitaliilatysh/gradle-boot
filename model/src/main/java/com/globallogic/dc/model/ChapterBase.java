package com.globallogic.dc.model;

import java.util.Collection;
import java.util.List;

public abstract class ChapterBase extends AbstractProduct {

    private List<SubChapter> subChapters;

    public List<SubChapter> getSubChapters() {
        return this.subChapters;
    }

    public void setSubChapters(final List<SubChapter> subChapters) {
        this.subChapters = subChapters;
    }

    public boolean hasSubChapters() {
        return this.subChapters != null;
    }

    public void addSubChapters(final Collection<SubChapter> subChapters) {
        this.subChapters.addAll(subChapters);
    }

    public void addSubChapter(final SubChapter subChapter) {
        this.subChapters.add(subChapter);
    }

}
