package com.globallogic.dc.controllers;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.services.impl.RangeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ranges")
public class RangeController {

    @Autowired
    @Qualifier("RangeServiceImpl")
    private RangeServiceImpl rangeServiceImpl;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Range> getRanges() {
        return rangeServiceImpl.getRanges();
    }

    @GetMapping(value = "/range", produces = MediaType.APPLICATION_JSON_VALUE)
    public Range getRangeById(@RequestParam("id") final String id) {
        return rangeServiceImpl.getRangeById(id);
    }

    @GetMapping(value = "/subChapter", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Range> getRangesBySubChapterId(@RequestParam("id") final String id) {
        return rangeServiceImpl.getRangesBySubChapterId(id);
    }

    @GetMapping(value = "/section", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Range> getRangesBySectionId(@RequestParam("id") final String id) {
        return rangeServiceImpl.getRangesBySectionId(id);
    }
}
