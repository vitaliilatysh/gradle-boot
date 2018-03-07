package com.globallogic.dc.service.mock;

import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.service.ChapterService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
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
