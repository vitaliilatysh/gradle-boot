package com.globallogic.dc.model;

import java.util.Collection;
import java.util.List;

public class Section extends SectionBase {

    public Section(
            final String key,
            final String title,
            final String description) {
        super(key, title, description);
    }

    public Section(
            final String key,
            final String title,
            final String description,
            final SubChapter subChapter,
            final List<Range> ranges) {
        super(key, title, description, subChapter, ranges);
    }

    public Section(
            final String key,
            final String title,
            final String description,
            final SubChapter subChapter) {
        super(key, title, description, subChapter);
    }

    @Override
    protected void doAddRange(final Range range) {
        if (!range.hasSections() || !range.containsSection(this)) {
            range.addSection(this);
        } else {
            super.doAddRange(range);
        }
    }

    @Override
    public void addRanges(final Collection<Range> ranges) {
        super.addRanges(ranges);
    }

    @Override
    public void setSubChapter(final SubChapter subChapter) {
        if (hasSubChapter() && this.getSubChapter().containsSection(this)) {
            this.getSubChapter().removeSection(this);
        }
        super.setSubChapter(subChapter);
        subChapter.addSection(this);
    }
}
