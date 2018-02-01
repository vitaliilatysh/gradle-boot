package com.globallogic.dc.commons.test;

import com.globallogic.dc.model.SubChapter;
import com.globallogic.dc.model.Chapter;

import java.util.Arrays;

public class ChapterBuilder {

    public static com.globallogic.dc.model.Chapter buildChapter(final boolean fillSubChapters) {
        return buildChapter("1", "Title", "Desc", fillSubChapters);
    }

    private static Chapter buildChapter(
            final String key,
            final String title,
            final String description,
            final boolean fillSubChapters) {
        final Chapter result = new Chapter(key, title, description);

        if (fillSubChapters) {
            result.addSubChapters(Arrays.asList(
                    new SubChapter("1", "Title", "Desc"),
                    new SubChapter("2", "Title", "Desc")));
        }

        return result;
    }
}
