package com.globallogic.dc.model;

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

    public Section() {
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
    public void setSubChapter(final SubChapter subChapter) {
        if (hasSubChapter() && this.getSubChapter().containsSection(this)) {
            this.getSubChapter().removeSection(this);
        }
        super.setSubChapter(subChapter);

        if (hasSubChapter()) {
            subChapter.addSection(this);
        }
    }
}
