package com.globallogic.dc.web.api;

import com.globallogic.dc.model.Section;
import com.globallogic.dc.service.api.SectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "/api/sections", description = "Operations about sections")
@RestController
@RequestMapping(value = "/api/sections", produces = MediaType.APPLICATION_JSON_VALUE)
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @ApiOperation(value = "Get all sections")
    @GetMapping
    public List<Section> getSections() {
        return sectionService.getSections();
    }

    @ApiOperation(value = "Get section by id")
    @GetMapping(value = "/{id}")
    public Section getSectionById(@PathVariable("id") final String id) {
        return sectionService.getSectionById(id);
    }

    @ApiOperation(value = "Get sections by subChapter id")
    @GetMapping(params = "subChapter")
    public List<Section> getSectionsBySubChapterId(@RequestParam("subChapter") final String id) {
        return sectionService.getSectionsBySubChapterId(id);
    }
}
