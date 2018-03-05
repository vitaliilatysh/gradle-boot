package com.globallogic.dc.controllers;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.service.RangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ranges")
public class RangeController {

    @Autowired
    private RangeService rangeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Range> getRanges() {
        return rangeService.getRanges();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Range getRangeById(@PathVariable("id") final String id) {
        return rangeService.getRangeById(id);
    }

    @GetMapping(params = "subChapter", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Range> getRangesBySubChapterId(@RequestParam("subChapter") final String id) {
        return rangeService.getRangesBySubChapterId(id);
    }

    @GetMapping(params = "section", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Range> getRangesBySectionId(@RequestParam("section") final String id) {
        return rangeService.getRangesBySectionId(id);
    }
}