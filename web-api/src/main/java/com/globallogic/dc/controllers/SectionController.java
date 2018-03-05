package com.globallogic.dc.controllers;

import com.globallogic.dc.model.Section;
import com.globallogic.dc.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sections", produces = MediaType.APPLICATION_JSON_VALUE)
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @GetMapping
    public List<Section> getSections() {
        return sectionService.getSections();
    }

    @GetMapping(value = "/{id}")
    public Section getSectionById(@PathVariable("id") final String id) {
        return sectionService.getSectionById(id);
    }

    @GetMapping(params = "subChapter")
    public List<Section> getSectionsBySubChapterId(@RequestParam("subChapter") final String id) {
        return sectionService.getSectionsBySubChapterId(id);
    }
}
