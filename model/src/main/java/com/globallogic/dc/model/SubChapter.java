package com.globallogic.dc.model;

import java.util.List;

public class SubChapter extends SubChapterBase {

    public SubChapter(
            final String key,
            final String title,
            final String description) {
        super(key, title, description);
    }

    public SubChapter(
            final String key,
            final String title,
            final String description,
            final Chapter chapter,
            final List<Section> sections,
            final List<Range> ranges) {
        super(key, title, description, chapter, sections, ranges);
    }

    @Override
    protected void doAddRange(final Range range) {
        if (!range.hasSubChapters() || !range.containsSubChapter(this)) {
            range.addSubChapter(this);
        } else {
            super.doAddRange(range);
        }
    }

    @Override
    protected void doAddSection(final Section section) {
        if (!section.hasSubChapter() || section.getSubChapter() != this) {
            section.setSubChapter(this);
        } else {
            super.doAddSection(section);
        }
    }

    @Override
    public void setChapter(final Chapter chapter) {
        if (hasChapter() && this.getChapter().containsSubChapter(this)) {
            this.getChapter().removeSubChapter(this);
        }
        super.setChapter(chapter);
        chapter.addSubChapter(this);
    }
}
