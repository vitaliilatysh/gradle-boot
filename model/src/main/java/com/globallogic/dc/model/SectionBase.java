package com.globallogic.dc.model;

import java.util.Collection;
import java.util.List;

public abstract class SectionBase extends AbstractProduct {

    private SubChapter subChapter;
    private List<Range> ranges;

    public List<Range> getRanges() {
        return this.ranges;
    }

    public void setRanges(final List<Range> ranges) {
        this.ranges = ranges;
    }

    public boolean hasRanges() {
        return (this.ranges != null) && !(this.ranges.isEmpty());
    }

    public SubChapter getSubChapter() {
        return this.subChapter;
    }

    public void setSubChapter(final SubChapter subChapter) {
        this.subChapter = subChapter;
    }

    public boolean hasSubChapter() {
        return this.subChapter != null;
    }

    public void addRanges(final Collection<Range> ranges) {
        if (this.ranges != null) this.ranges.addAll(ranges);
    }

    public void addRange(final Range range) {
        if (this.ranges != null) this.ranges.add(range);
    }

}