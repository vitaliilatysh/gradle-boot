package com.globallogic.dc.web.api;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.service.api.RangeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "/ranges", description = "Operations about ranges")
@RestController
@RequestMapping(value = "/ranges", produces = MediaType.APPLICATION_JSON_VALUE)
public class RangeController {

    @Autowired
    private RangeService rangeService;

    @ApiOperation(value = "Get all ranges")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "subChapter", value = "SubChapter id", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "section", value = "Section id", dataType = "string", paramType = "query")}
    )
    @GetMapping
    public List<Range> getRanges() {
        return rangeService.getRanges();
    }

    @ApiOperation(value = "Get range by id")
    @GetMapping(value = "/{id}")
    public Range getRangeById(@PathVariable("id") final String id) {
        return rangeService.getRangeById(id);
    }

    @ApiOperation(value = "Get ranges by subChapter id", hidden = true)
    @GetMapping(params = "subChapter")
    public List<Range> getRangesBySubChapterId(@RequestParam("subChapter") final String id) {
        return rangeService.getRangesBySubChapterId(id);
    }

    @ApiOperation(value = "Get ranges by section id", hidden = true)
    @GetMapping(params = "section")
    public List<Range> getRangesBySectionId(@RequestParam("section") final String id) {
        return rangeService.getRangesBySectionId(id);
    }
}
