package com.globallogic.dc.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;
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
            final Chapter chapter,
            final List<Section> sections,
            final List<Range> ranges) {
        super(key, title, description);
        this.chapter = chapter;
        this.sections = sections;
        this.ranges = ranges;
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
        return this.sections;
    }

    public void setSections(final List<Section> sections) {
        this.sections = sections;
    }

    public boolean hasSections() {
        return isNotEmpty(this.sections);
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

    public void addSections(final Collection<Section> sections) {
        if (isEmpty(this.sections)) {
            this.sections = new ArrayList<>();
        }
        this.sections.addAll(sections);
    }

    public void addSection(final Section section) {
        if (isEmpty(this.sections)) {
            this.sections = new ArrayList<>();
        }
        this.sections.add(section);
    }

    public void addRanges(final Collection<Range> ranges) {
        if (isEmpty(this.ranges)) {
            this.ranges = new ArrayList<>();
        }
        this.ranges.addAll(ranges);
    }

    public void addRange(final Range range) {
        if (isEmpty(this.ranges)) {
            this.ranges = new ArrayList<>();
        }
        this.ranges.add(range);
    }

}