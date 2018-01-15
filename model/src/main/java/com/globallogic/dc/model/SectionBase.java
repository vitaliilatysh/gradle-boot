package com.globallogic.dc.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

public abstract class SectionBase extends AbstractProduct {

    private SubChapter subChapter;
    private List<Range> ranges;

    public SectionBase(
            final String key,
            final String title,
            final String description) {
        super(key, title, description);
    }

    public SectionBase(
            final String key,
            final String title,
            final String description,
            final SubChapter subChapter,
            final List<Range> ranges) {
        super(key, title, description);
        this.subChapter = subChapter;
        this.ranges = ranges;
    }

    public SectionBase(
            final String key,
            final String title,
            final String description,
            final SubChapter subChapter) {
        super(key, title, description);
        this.subChapter = subChapter;
    }

    public List<Range> getRanges() {
        return this.ranges;
    }

    public void setRanges(final List<Range> ranges) {
        this.ranges = ranges;
    }

    public boolean hasRanges() {
        return isNotEmpty(this.ranges);
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
        if (isEmpty(this.ranges)) this.ranges = new ArrayList<>();
        this.ranges.addAll(ranges);
    }

    public void addRange(final Range range) {
        if (isEmpty(this.ranges)) this.ranges = new ArrayList<>();
        this.ranges.add(range);
    }

}