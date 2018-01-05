package com.globallogic.dc.model;

import java.util.Collection;
import java.util.List;

public abstract class SectionBase extends ProductBase {

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

    abstract public void addRanges(Collection<Range> ranges);
    abstract public void addRange(Collection<Range> range);

}