package com.globallogic.dc.controllers;

import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.services.impl.ChapterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chapters")
public class ChapterController {

    @Autowired
    @Qualifier("ChapterServiceImpl")
    private ChapterServiceImpl chapterServiceImpl;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Chapter> getAllChapters() {
        return chapterServiceImpl.getChapters();
    }

    @GetMapping(value = "/chapter", produces = MediaType.APPLICATION_JSON_VALUE)
    public Chapter getChapterById(@RequestParam("id") final String id) {
        return chapterServiceImpl.getChapterById(id);
    }
}
