package com.globallogic.dc.web.api;

import com.globallogic.dc.model.SubChapter;
import com.globallogic.dc.service.api.SubChapterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "/subChapters", description = "Operations about subChapters")
@RestController
@RequestMapping(value = "/subChapters", produces = MediaType.APPLICATION_JSON_VALUE)
public class SubChapterController {

    @Autowired
    private SubChapterService subChapterService;

    @ApiOperation(value = "Get all subChapters")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "chapter", value = "Chapter id", dataType = "string", paramType = "query")}
    )
    @GetMapping
    public List<SubChapter> getSubChapters() {
        return subChapterService.getSubChapters();
    }

    @ApiOperation(value = "Get subChapter by id")
    @GetMapping(value = "/{id}")
    public SubChapter getSubChapterById(@PathVariable("id") final String id) {
        return subChapterService.getSubChapterById(id);
    }

    @ApiOperation(value = "Get subChapters by chapter id", hidden = true)
    @GetMapping(params = "chapter")
    public List<SubChapter> getSubChaptersByChapterId(@RequestParam("chapter") final String id) {
        return subChapterService.getSubChaptersByChapterId(id);
    }
}
