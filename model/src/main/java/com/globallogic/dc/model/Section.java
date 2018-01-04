package com.globallogic.dc.model;

import java.util.List;

public class Section {

    private SubChapter chapter;
    private List<Range> ranges;

    public List<Range> getRanges() {
        return ranges;
    }

    public void setRanges(final List<Range> ranges) {
        this.ranges = ranges;
    }

    public SubChapter getChapter() {
        return chapter;
    }

    public void setChapter(final SubChapter chapter) {
        this.chapter = chapter;
    }
}
