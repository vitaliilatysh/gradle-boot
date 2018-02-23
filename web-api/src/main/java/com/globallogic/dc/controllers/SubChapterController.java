package com.globallogic.dc.controllers;

import com.globallogic.dc.model.SubChapter;
import com.globallogic.dc.services.SubChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subChapters")
public class SubChapterController {

    @Autowired
    private SubChapterService subChapterServiceImpl;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SubChapter> getSubChapters() {
        return subChapterServiceImpl.getSubChapters();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SubChapter getSubChapterById(@PathVariable("id") final String id) {
        return subChapterServiceImpl.getSubChapterById(id);
    }

    @GetMapping(params = "chapter", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SubChapter> getSubChaptersByChapterId(@RequestParam("chapter") final String id) {
        return subChapterServiceImpl.getSubChaptersByChapterId(id);
    }
}
