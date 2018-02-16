package com.globallogic.dc.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

public abstract class SubChapterBase extends AbstractProduct {

    private Chapter chapter;
    private List<Section> sections;
    private List<Range> ranges;

    public SubChapterBase(
            final String key,
            final String title,
            final String description) {
        super(key, title, description);
    }

    public SubChapterBase(
            final String key,
            final String title,
            final String description,
            final Chapter chapter) {
        super(key, title, description);
        this.chapter = chapter;
    }

    public SubChapterBase(
            final String key,
            final String title,
            final String description,
            final Chapter chapter,
            final List<Section> sections,
            final List<Range> ranges) {
        super(key, title, description);
        this.chapter = chapter;
        this.sections = sections;
        this.ranges = ranges;
    }

    protected SubChapterBase() {
    }

    public Chapter getChapter() {
        return this.chapter;
    }

    public void setChapter(final Chapter chapter) {
        this.chapter = chapter;
    }

    public boolean hasChapter() {
        return this.chapter != null;
    }

    public List<Section> getSections() {
        return hasSections() ? Collections.unmodifiableList(this.sections) : null;
    }

    public void setSections(final List<Section> sections) {
        this.sections = sections;
    }

    private List<Section> getSectionsSafe() {
        if (sections == null) {
            synchronized (this) {
                if (sections == null) {
                    sections = new ArrayList<>();
                }
            }
        }
        return sections;
    }

    public boolean hasSections() {
        return isNotEmpty(this.sections);
    }

    public void addSection(final Section section) {
        if (section == null) {
            throw new IllegalArgumentException();
        }
        doAddSection(section);
    }

    public void addSections(final Collection<Section> sections) {
        if (sections == null) {
            throw new IllegalArgumentException();
        }
        sections.forEach(this::doAddSection);
    }

    protected void doAddSection(final Section section) {
        getSectionsSafe().add(section);
    }

    public boolean containsSection(final Section section) {
        return getSectionsSafe().contains(section);
    }

    public void removeSection(final Section section) {
        getSectionsSafe().remove(section);
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

}