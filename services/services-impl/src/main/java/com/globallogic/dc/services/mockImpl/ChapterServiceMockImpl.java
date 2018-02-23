package com.globallogic.dc.services.mockImpl;

import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.services.ChapterService;

import java.util.Arrays;
import java.util.List;

public class ChapterServiceMockImpl implements ChapterService {

    public List<Chapter> getChapters() {
        return Arrays.asList(
                new Chapter("1", "Title", "Desc"),
                new Chapter("2", "Title", "Desc"));
    }

    public Chapter getChapterById(final String key) {
        Chapter chapter = new Chapter("1", "Title", "Desc");

        return chapter.getKey().equals(key) ? chapter : new Chapter();
    }
}
