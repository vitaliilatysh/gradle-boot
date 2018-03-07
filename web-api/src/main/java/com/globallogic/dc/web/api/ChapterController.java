package com.globallogic.dc.web.api;

import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.service.api.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/chapters", produces = MediaType.APPLICATION_JSON_VALUE)
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @GetMapping
    public List<Chapter> getAllChapters() {
        return chapterService.getChapters();
    }

    @GetMapping(value = "/{id}")
    public Chapter getChapterById(@PathVariable("id") final String id) {
        return chapterService.getChapterById(id);
    }
}
