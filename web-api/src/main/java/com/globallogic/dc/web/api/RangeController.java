package com.globallogic.dc.web.api;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.service.api.RangeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "/api/ranges", description = "Operations about ranges")
@RestController
@RequestMapping(value = "/api/ranges", produces = MediaType.APPLICATION_JSON_VALUE)
public class RangeController {

    @Autowired
    private RangeService rangeService;

    @ApiOperation(value = "Get all ranges")
    @GetMapping
    public List<Range> getRanges() {
        return rangeService.getRanges();
    }

    @ApiOperation(value = "Get range by id")
    @GetMapping(value = "/{id}")
    public Range getRangeById(@PathVariable("id") final String id) {
        return rangeService.getRangeById(id);
    }

    @ApiOperation(value = "Get ranges by subChapter id")
    @GetMapping(params = "subChapter")
    public List<Range> getRangesBySubChapterId(@RequestParam("subChapter") final String id) {
        return rangeService.getRangesBySubChapterId(id);
    }

    @ApiOperation(value = "Get ranges by section id")
    @GetMapping(params = "section")
    public List<Range> getRangesBySectionId(@RequestParam("section") final String id) {
        return rangeService.getRangesBySectionId(id);
    }
}
