package com.globallogic.dc.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

    protected SectionBase() {
    }

    public List<Range> getRanges() {
        return hasRanges() ? Collections.unmodifiableList(this.ranges) : null;
    }

    public void setRanges(final List<Range> ranges) {
        this.ranges = ranges;
    }

    private List<Range> getRangesSafe() {
        if (ranges == null) {
            synchronized (this) {
                if (ranges == null) {
                    ranges = new ArrayList<>();
                }
            }
        }
        return ranges;
    }

    public boolean hasRanges() {
        return isNotEmpty(this.ranges);
    }

    public void addRange(final Range range) {
        if (range == null) {
            throw new IllegalArgumentException();
        }
        doAddRange(range);
    }

    public void addRanges(final Collection<Range> ranges) {
        if (ranges == null) {
            throw new IllegalArgumentException();
        }
        ranges.forEach(this::doAddRange);
    }

    protected void doAddRange(final Range range) {
        getRangesSafe().add(range);
    }

    public boolean containsRange(final Range range) {
        return getRangesSafe().contains(range);
    }

    public void removeRange(final Range range) {
        getRangesSafe().remove(range);
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

}