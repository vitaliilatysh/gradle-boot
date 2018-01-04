package com.globallogic.dc.model;

import java.util.List;

public class Chapter {

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
}
