package com.globallogic.dc.web.api;

import com.globallogic.dc.model.Section;
import com.globallogic.dc.service.api.SectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "/sections", description = "Operations about sections")
@RestController
@RequestMapping(value = "/sections", produces = MediaType.APPLICATION_JSON_VALUE)
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @ApiOperation(value = "Get all sections")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "subChapter", value = "SubChapter id", dataType = "string", paramType = "query")
    }
    )
    @GetMapping
    public List<Section> getSections() {
        return sectionService.getSections();
    }

    @ApiOperation(value = "Get section by id")
    @GetMapping(value = "/{id}")
    public Section getSectionById(@PathVariable("id") final String id) {
        return sectionService.getSectionById(id);
    }

    @ApiOperation(value = "Get sections by subChapter id", hidden = true)
    @GetMapping(params = "subChapter")
    public List<Section> getSectionsBySubChapterId(@RequestParam("subChapter") final String id) {
        return sectionService.getSectionsBySubChapterId(id);
    }
}
