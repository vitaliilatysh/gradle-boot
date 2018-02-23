package com.globallogic.dc.controllers;

import com.globallogic.dc.model.SubChapter;
import com.globallogic.dc.services.impl.SubChapterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subChapters")
public class SubChapterController {

    @Autowired
    @Qualifier("SubChapterServiceImpl")
    private SubChapterServiceImpl subChapterServiceImpl;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SubChapter> getSubChapters() {
        return subChapterServiceImpl.getSubChapters();
    }

    @GetMapping(value = "/subChapter", produces = MediaType.APPLICATION_JSON_VALUE)
    public SubChapter getSubChapterById(@RequestParam("id") final String id) {
        return subChapterServiceImpl.getSubChapterById(id);
    }

    @GetMapping(value = "/chapter", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SubChapter> getSubChaptersByChapterId(@RequestParam("id") final String id) {
        return subChapterServiceImpl.getSubChaptersByChapterId(id);
    }
}
