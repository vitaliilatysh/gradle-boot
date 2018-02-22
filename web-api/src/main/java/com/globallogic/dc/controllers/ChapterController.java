package com.globallogic.dc.controllers;

import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.services.impl.ChapterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChapterController {

    @Autowired
    @Qualifier("ChapterServiceImpl")
    private ChapterServiceImpl chapterService;

    @GetMapping(value = "/chapters", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Chapter> getAllChapters() {
        return chapterService.getChapters();
    }

    @GetMapping(value = "/chapters/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Chapter getChapterById(@PathVariable("id") final String id) {
        return chapterService.getChapterById(id);
    }
}
