package com.globallogic.dc.model;

import java.util.Collection;
import java.util.List;

public class Section extends SectionBase {

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

    @Override
    public void add(Collection<Range> ranges) {
        this.ranges.addAll(ranges);
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
