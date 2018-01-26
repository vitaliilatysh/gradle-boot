package com.globallogic.dc.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

public abstract class RangeBase extends AbstractProduct {

    private List<SubChapter> subChapters;
    private List<Item> relatedItems;
    private List<Section> sections;

    public RangeBase(
            final String key,
            final String title,
            final String description) {
        super(key, title, description);
    }

    public RangeBase(
            final String key,
            final String title,
            final String description,
            final List<SubChapter> subChapters,
            final List<Item> relatedItems,
            final List<Section> sections) {
        super(key, title, description);
        this.subChapters = subChapters;
        this.relatedItems = relatedItems;
        this.sections = sections;
    }

    public RangeBase(
            final String key,
            final String title,
            final String description,
            final List<Item> relatedItems) {
        super(key, title, description);
        this.relatedItems = relatedItems;
    }

    public List<SubChapter> getSubChapters() {
        return hasSubChapters() ? Collections.unmodifiableList(this.subChapters) : null;
    }

    public void setSubChapters(final List<SubChapter> subChapters) {
        this.subChapters = subChapters;
    }

    private List<SubChapter> getSubChaptersSafe() {
        if (subChapters == null) {
            synchronized (this) {
                if (subChapters == null) {
                    subChapters = new ArrayList<>();
                }
            }
        }
        return subChapters;
    }

    public boolean hasSubChapters() {
        return isNotEmpty(this.subChapters);
    }

    public void addSubChapter(final SubChapter subChapter) {
        doAddSubChapter(subChapter);
    }

    public void addSubChapters(final Collection<SubChapter> subChapters) {
        if (subChapters == null) {
            throw new IllegalArgumentException();
        }
        subChapters.forEach(this::doAddSubChapter);
    }

    protected void doAddSubChapter(final SubChapter subChapter) {
        getSubChaptersSafe().add(subChapter);
    }

    public boolean containsSubChapter(final SubChapter subChapter) {
        return getSubChaptersSafe().contains(subChapter);
    }

    public void removeSubChapter(final SubChapter subChapter) {
        getSubChaptersSafe().remove(subChapter);
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

    public List<Item> getItems() {
        return hasItems() ? Collections.unmodifiableList(this.relatedItems) : null;
    }

    public void setItems(final List<Item> relatedItems) {
        this.relatedItems = relatedItems;
    }

    private List<Item> getItemsSafe() {
        if (relatedItems == null) {
            synchronized (this) {
                if (relatedItems == null) {
                    relatedItems = new ArrayList<>();
                }
            }
        }
        return relatedItems;
    }

    public boolean hasItems() {
        return isNotEmpty(this.relatedItems);
    }

    public void addItem(final Item item) {
        doAddItem(item);
    }

    public void addItems(final Collection<Item> relatedItems) {
        if (relatedItems == null) {
            throw new IllegalArgumentException();
        }
        relatedItems.forEach(this::doAddItem);
    }

    protected void doAddItem(final Item item) {
        getItemsSafe().add(item);
    }

    public boolean containsItem(final Item item) {
        return getItemsSafe().contains(item);
    }

    public void removeItem(final Item item) {
        getItemsSafe().remove(item);
    }
}