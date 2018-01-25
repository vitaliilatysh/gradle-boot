package com.globallogic.dc.model;

import java.util.Collection;
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
    protected void doAddSection(final Section section) {
        if (!section.hasSubChapter() || section.getSubChapter() != this) {
            if (section.hasSubChapter() && section.getSubChapter().containsSection(section)) {
                section.getSubChapter().removeSection(section);
            }
            section.setSubChapter(this);
        } else {
            super.doAddSection(section);
        }
    }

    @Override
    protected void addSections(final Collection<Section> sections) {
        super.addSections(sections);
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
