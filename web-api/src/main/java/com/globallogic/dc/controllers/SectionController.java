package com.globallogic.dc.controllers;

import com.globallogic.dc.model.Section;
import com.globallogic.dc.services.impl.SectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sections")
public class SectionController {

    @Autowired
    @Qualifier("SectionServiceImpl")
    private SectionServiceImpl sectionServiceImpl;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Section> getSections() {
        return sectionServiceImpl.getSections();
    }

    @GetMapping(value = "/section", produces = MediaType.APPLICATION_JSON_VALUE)
    public Section getSectionById(@RequestParam("id") final String id) {
        return sectionServiceImpl.getSectionById(id);
    }

    @GetMapping(value = "/subChapter", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Section> getSectionsBySubChapterId(@RequestParam("id") final String id) {
        return sectionServiceImpl.getSectionsBySubChapterId(id);
    }
}
