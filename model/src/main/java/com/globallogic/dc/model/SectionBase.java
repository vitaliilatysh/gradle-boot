package com.globallogic.dc.model;

import java.util.Collection;
import java.util.List;

public abstract class SectionBase extends AbstractProduct {

    private SubChapter subChapter;
    private List<Range> ranges;

    public List<Range> getRanges() {
        return ranges;
    }

    public void setRanges(final List<Range> ranges) {
        this.ranges = ranges;
    }

    public boolean hasRanges() {
        return this.getRanges().isEmpty();
    }

    public SubChapter getSubChapter() {
        return subChapter;
    }

    public void setSubChapter(final SubChapter subChapter) {
        this.subChapter = subChapter;
    }

    public boolean hasSubChapter() {
        return this.getSubChapter() != null;
    }

    public void addRanges(Collection<Range> ranges){
        this.ranges.addAll(ranges);
    }

    public void addRange(Range range){
        this.ranges.add(range);
    }

}