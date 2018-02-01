package com.globallogic.dc.commons.test;

import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.model.Range;
import com.globallogic.dc.model.Section;
import com.globallogic.dc.model.SubChapter;

import java.util.Arrays;

public class SubChapterBuilder {
    public static SubChapter buildSubChapter(final boolean fillChapter, final boolean fillSections, final boolean fillRanges) {
        return buildSubChapter("1", "Title", "Desc", fillChapter, fillSections, fillRanges);
    }

    private static SubChapter buildSubChapter(
            final String key,
            final String title,
            final String description,
            final boolean fillChapter,
            final boolean fillSections,
            final boolean fillRanges) {
        final SubChapter result = new SubChapter(key, title, description);

        if (fillRanges) {
            result.addRanges(Arrays.asList(
                    new Range("1", "Title", "Desc"),
                    new Range("2", "Title", "Desc")
            ));
        }
        if (fillSections) {
            result.addSections(Arrays.asList(
                    new Section("1", "Title", "Desc"),
                    new Section("2", "Title", "Desc")
            ));
        }
        if (fillChapter) {
            result.setChapter(new Chapter("1", "Title", "Desc"));
        }
        return result;
    }
}
